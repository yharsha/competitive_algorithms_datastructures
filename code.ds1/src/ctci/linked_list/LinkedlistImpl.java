package linked_list;

import java.util.HashSet;
import java.util.Stack;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.IconifyAction;

public class LinkedlistImpl {
	
	public static void removeDups(Node head)
	{
		Node curr=head,prev=null;
		if(head==null) return;
		HashSet<Integer> hs = new HashSet<Integer>();

		while(curr!=null)
		{
			if(hs.contains(curr.data))
			{
				//delete the node
				prev.next=curr.next;

			}
			else {
				hs.add(curr.data);
				prev=curr;
			}
			curr=curr.next;
		}

		
	}
	
	public static void kthElementFromLast(Node head,int k)
	{
		if(head==null)return;
		Node fast=head,slow=head;
		//diff will be k-1
		while(k>1)
		{
			fast=fast.next;
			k--;
		}
		
		while(fast.next!=null)
		{
			fast=fast.next;
			slow=slow.next;
		}
		System.out.println(k+ "element from last :"+slow.data);
			
	}
	
	public static Node partition(Node head,int x)
	{
		if(head==null)return null;
		Node head1=null,tail1=null;
		Node head2=null,tail2=null;
		
		Node curr=head;
		while(curr!=null)
		{
			//smaller linkedlist
			if(curr.data<x)
			{
				if(head1==null)
				{
					head1=curr;
					tail1=curr;
				}
				else
				{
				tail1.next=curr;
				tail1=curr;
				}
			}else {
				if(head2==null)
				{
					head2=curr;
					tail2=curr;
				}
				else
				{
				tail2.next=curr;
				tail2=curr;
				}
			}
			curr=curr.next;
		}
		if(head1==null)return head2;
		//merge lists
		tail1.next=head2;
		tail2.next=null;
		return head1;
		
	}
	
	public static Node sumLists(Node head1,Node head2)
	{
		if(head1==null || head2 == null)return null;
		//find lengths
		int len1=listLength(head1);
		int len2=listLength(head2);
		
		//1's digit is at head
		int diff = len1>len2 ? len1-len2 : len2-len1 ;
		if(len1>len2)
		{
			padding(head2, diff);
		}
		else if(len1<len2)
		{
			padding(head1, diff);
		}
		
		Node result = addLists(head1,head2,0);
		
		return result;
	}
	
	public static Node addLists(Node temp1,Node temp2,int carry)
	{
		if(temp1==null || temp2 ==null)return null;
		
		int value=0;
		if(temp1!=null)
		{
			value+=temp1.data;
		}
		if(temp2!=null)
		{
			value+=temp2.data;
		}
		value+=carry;
		Node result= new Node(value%10);
		result.next=addLists(temp1.next,temp2.next,value>10?1:0);
		
		return result;
	}
	
	
	public static void padding(Node head,int diff)
	{
		Node curr=head;
		while(curr.next!=null)
		{
			curr=curr.next;
		}
		while(diff>0)
		{
			diff--;
			Node zeroNode = new Node(0);
			curr.next=zeroNode;
			curr=zeroNode;
		}
		
		
	}
	public static int listLength(Node head)
	{
		int len=0;
		Node curr=head;
		while(curr!=null)
		{
			len++;
			curr=curr.next;
		}
		
		return len;
	}
	
	public static boolean checkPalindrome(Node head)
	{
		if(head==null)return false;
		Node fast=head,slow=head;
		Stack<Integer> st = new Stack<Integer>();
		
		//move fast 2times,slow 1times
		while(fast!=null && fast.next!=null)
		{
			st.push(slow.data);
			slow=slow.next;
			fast=fast.next.next;
		}
		
		//checking list odd or even
		if(fast!=null)
		{
			slow=slow.next;
		}
		
		while(slow!=null)
		{
			if(st.pop()!=slow.data) return false;
			slow=slow.next;
		}
		
		return true;
	}
	
	class Result{
		public Node tail;
		public int size;
		public Result(Node tail,int size)
		{
			this.tail=tail;
			this.size=size;
		}
	}
	
	public Node checkIntersection(Node head1,Node head2) {
		if(head1==null||head2==null)return null;
		Result result1=getSizeAndTail(head1);
		Result result2=getSizeAndTail(head2);
		
		//checkif tail nodes equal
		if(result1.tail!=result2.tail)return null;
		
		
		
		int diff = Math.abs(result1.size-result2.size);
		Node longer = result1.size > result2.size ? head1 :	head2;
		Node shorter = result1.size<result2.size ? head1:head2;
		
		
		while(diff>0)
		{
			longer=longer.next;
			diff--;
		}
		
		while(shorter!=longer)
		{
			shorter=shorter.next;
			longer=longer.next;
		}
		
		return longer;
		
	}
	
	public Result getSizeAndTail(Node head)
	{
		if(head==null)return null;
		Node temp=head;
		int len=1;
		while(temp.next!=null)
		{
			temp=temp.next;
			len++;
		}
		Result result1= new Result(temp, len);
		return result1;
		
		
	}
	
	public Node findBeginingOfLoop(Node head)
	{
		if(head==null)return null;
		Node slow=head,fast=head;
		
		while(fast!=null && fast.next!=null)
		{
			if(slow==fast)
				{
				System.out.println("Meeting point found at :"+fast.data);
				break;}
		
		}
		
		if(fast==null) {return null;}
		
		slow=head;
		while(fast!=slow)
		{
			slow=slow.next;
			fast=fast.next;
		}
		
		return fast;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Linkedlist list = new Linkedlist();
		list.insertNodeAtEnd(1);
		list.insertNodeAtEnd(2);
		list.insertNodeAtEnd(3);
		list.insertNodeAtEnd(4);
		list.insertNodeAtEnd(5);
		list.printList();
		list.deleteFirst();
		list.insertNodeAtEnd(1);
		list.insertNodeAtEnd(2);
		list.insertNodeAtEnd(3);
		list.insertNodeAtEnd(4);
		list.printList();
		System.out.println("Delete duplicates");
		removeDups(list.head);
		list.printList();
		kthElementFromLast(list.head,5);
		
		
		Linkedlist l2 = new Linkedlist();
		l2.insertNodeAtEnd(3);
		l2.insertNodeAtEnd(5);
		l2.insertNodeAtEnd(8);
		l2.insertNodeAtEnd(5);
		l2.insertNodeAtEnd(10);
		l2.insertNodeAtEnd(2);
		l2.insertNodeAtEnd(1);
		l2.printList();
		l2.head=partition(l2.head, 5);
		System.out.println("After partioning with 5..");
		l2.printList();
		
		
		Linkedlist list1 = new Linkedlist();
		list1.insertNodeAtEnd(7);
		list1.insertNodeAtEnd(1);
		list1.insertNodeAtEnd(6);
		
		Linkedlist list2 = new Linkedlist();
		list2.insertNodeAtEnd(5);
		list2.insertNodeAtEnd(9);
		list2.insertNodeAtEnd(2);
		
		System.out.println("Sum two lists...");
		Linkedlist list3 = new Linkedlist();
		list3.head=sumLists(list1.head, list2.head);
		list3.printList();
		
		System.out.println("");
		Linkedlist plist = new Linkedlist();
		plist.insertNodeAtEnd(1);
		plist.insertNodeAtEnd(2);
		plist.insertNodeAtEnd(3);
		plist.insertNodeAtEnd(2);
		plist.insertNodeAtEnd(1);
		System.out.println("Is List palindrome: "+checkPalindrome(plist.head));
		
		
	}

}
