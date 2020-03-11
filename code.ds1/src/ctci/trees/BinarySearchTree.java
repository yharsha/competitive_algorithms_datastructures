package trees;

import java.util.LinkedList;
import java.util.Queue;

class Node
{
	public int data;
	Node left;
	Node right;
	public Node(int data) {
		this.data=data;
	}
	
	public Node(int data,Node left,Node right) {
		this.data=data;
		this.left=left;
		this.right=right;
	}
}
//https://github.com/eugenp/tutorials/blob/master/data-structures/src/main/java/com/baeldung/tree/BinaryTree.java
public class BinarySearchTree {
	Node root;
	public void add(int data)
	{
		root=addRecursive(root,data);
	}
	
	public Node addRecursive(Node curr,int data)
	{
		if(curr==null)
		{
			return new Node(data);
		}
		if(data<=curr.data)
		{
			curr.left=addRecursive(curr.left,data);
		}
		else if(data>curr.data)
		{
			curr.right=addRecursive(curr.right,data);
		}
		
		return curr;
	}
	
	public boolean isEmpty()
	{
		return root==null;
	}
	
	public int getSize(Node root)
	{
		return getSizeRecursive(root);
	}
	
	public int getSizeRecursive(Node curr)
	{
		if (curr==null) return 0;
		return getSizeRecursive(curr.left)+1+getSizeRecursive(curr.right);
	}
	
	public boolean containsNode(int value)
	{
		return containsNodeRecursive(root,value);
	}
	
	public boolean containsNodeRecursive(Node curr,int value)
	{
		if(curr==null) return false;
		if(curr.data==value)return true;
		return curr.data <value ? containsNodeRecursive(curr.left,value) : containsNodeRecursive(curr.right,value); 

	}
	
	public void delete(int value)
	{
		root= deleteRecursive(root,value);
	}
	
	public Node deleteRecursive(Node curr,int value)
	{
		if(curr==null) return null;
		
		if (value == curr.data) {
		//no childs
		if( curr.left==null && curr.right==null ) {
			return null;
		}
		
		//1child
		if(curr.left==null)
		{
			return curr.right;
		}
		
		if(curr.right==null)
		{
			return curr.left;
		}	
		
		//2childs
		int smallestValue = findSmallestValue(curr.right);
		curr.data=smallestValue;
		curr.right=deleteRecursive(curr.right,smallestValue);
		}
		
		if(value<curr.data)
		{
			curr.left=deleteRecursive(curr.left, value);
			return curr;
		}
		
		curr.right=deleteRecursive(curr.left, value);
		return curr;
		
	}
	
	public int findSmallestValue(Node curr)
	{
		return root.left==null ? curr.data:findSmallestValue(curr.left);
	}
	//Traversals
	//inorder - LDR at every node
	public void printInorder(Node curr)
	{
		if(curr==null) return;
		printInorder(curr.left);
		System.out.print(curr.data+" ");
		printInorder(curr.right);	
	}
	
	public void printPreorder(Node curr)
	{
		if(curr==null) return;
		System.out.print(curr.data+" ");
		printPreorder(curr.left);
		printPreorder(curr.right);	
	}
	
	public void printPostorder(Node curr)
	{
		if(curr==null) return;
		printPreorder(curr.left);
		printPreorder(curr.right);	
		System.out.print(curr.data+" ");
	}
	
	public void traverseLevelOrder() {
		if(root==null)return;
		Queue<Node> queue = new LinkedList<Node>();
		
		queue.add(root);
		while(!queue.isEmpty())
		{
			Node curr=queue.remove();
			System.out.print(curr.data);
			if(curr.left!=null)
			{
				queue.add(curr.left);
			}
			if(curr.right!=null)
			{
				queue.add(curr.right);
			}
		
		}
	}
}
