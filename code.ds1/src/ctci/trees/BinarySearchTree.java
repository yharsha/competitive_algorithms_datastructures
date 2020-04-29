package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import com.sun.org.apache.xalan.internal.xsltc.compiler.Template;

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
	
	public void generateDepthLists(Node root)
	{
		System.out.println();
		System.out.println("----generateDepthLists---");
		
		ArrayList<LinkedList<Node>> result=new ArrayList<LinkedList<Node>>();
		 result = generateDepthListsUtil(root,result,0);
		
		for(int i=0;i<result.size();i++)
		{
			LinkedList<Node> list = result.get(i);
			System.out.print("Depth "+ i +" : ");
			for( Node x:list)
			{
				System.out.print(x.data+ " ");
			}
			System.out.println();
		}
	}
	
	public ArrayList<LinkedList<Node>> generateDepthListsUtil(Node root,ArrayList<LinkedList<Node>> lists,int level)
	{
		if(root==null) return lists;
		
		//list is not yet created for that level
		if(lists.size()==level) {
			lists.add(level, new LinkedList<Node>());
		}
		LinkedList<Node> list =lists.get(level);
		list.add(root);
		generateDepthListsUtil(root.left,lists,level+1);
		generateDepthListsUtil(root.right,lists,level+1);
		return lists;
	}
	
	public boolean checkBalancedTree(Node curr)
	{
		return !(checkBalanced(curr)==Integer.MIN_VALUE);
	}
	private int checkBalanced(Node curr)
	{
		if (curr==null)return -1;
		//left subtree height
		int h1 = checkBalanced(curr.left);
		if(h1==Integer.MIN_VALUE) return Integer.MIN_VALUE;
		
		int h2= checkBalanced(curr.right);
		if(h2==Integer.MIN_VALUE) return Integer.MIN_VALUE;
		
		if(Math.abs(h1-h2)>1)return Integer.MIN_VALUE;//error value
		else
		{
			return Math.max(h1, h2)+1;
		}
			
	}
	
	public boolean validateBST(Node curr,Integer min,Integer max)
	{
		return validateBSTUtil(curr,min,max);
	}
	
	public boolean validateBSTUtil(Node curr,Integer min,Integer  max )
	{
		if (curr==null) return true;
		
		if((min!=null && curr.data<min ) || (max!=null && curr.data>max))
			return false;
		
		if(!(validateBST(curr.left, min, curr.data)) || !(validateBST(curr.right, curr.data, max)))
			return false;
		
		return true;
	}
	
	public Node findLCA(Node root,int n1,int n2)
	{
		boolean [] visited = new boolean[2];
		
		Node temp = findLCAUtil(root, n1, n2,visited);
		if(visited[0] && visited[1])
		{
			System.out.println("FOUND LCA...."+temp.data);
			return temp;
		}
		System.out.println("NO LCA EXISTS....");
		return null;
	}
	
	private Node findLCAUtil(Node root,int n1,int n2,boolean [] visited) 
	{
		if(root==null) return null;
		Node temp=null;
		if(root.data==n1)
		{
			visited[0]=true;
			temp=root;
		}
		if(root.data==n2)
		{
			visited[1]=true;
			temp=root;
		}
		
		Node left_lca = findLCAUtil(root.left, n1, n2,visited);
		Node right_lca = findLCAUtil(root.right, n1, n2,visited);
		
		if(temp!=null)return temp;
		
		if(left_lca!=null && right_lca!=null) return root;
		
		return left_lca==null ? right_lca:left_lca;
	}
	
	//if t2 is a subtree of t1
	public boolean checkSubtree(Node t1,Node t2)
	{
		if(t2==null)return true;
		return subtree(t1, t2);
	}
	
	private boolean subtree(Node t1,Node t2)
	{
		if(t1==null) {
			return false;
		}
		else if(t1.data==t2.data && matchtree(t1,t2))
		{return true;}
		
		return subtree(t1.left, t2) || subtree(t1.right, t2);
		
	}
	
	private boolean  matchtree(Node t1,Node t2)
	{
		if(t1==null && t2==null) {return true;}
		else if(t1==null || t2==null){
			return false;
		}
		
		return matchtree(t1.left, t2.left) && matchtree(t1.right, t2.right);
	}
	
}
