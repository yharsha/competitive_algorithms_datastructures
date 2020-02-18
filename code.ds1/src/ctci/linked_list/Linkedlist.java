package linked_list;

//Node class
class Node {
	public int data;
	public Node next;

	Node(int d) {
		this.data = d;
		this.next=null;
	}

	public Node getNext(Node curr) {
		if (curr != null) {
			return curr.next;
		}
		return null;
	}
}

public class Linkedlist {
	

	Node head;
	
	public boolean isEmpty() {
		return head==null;
	}
	
	public void insertNodeAtEnd(int d)
	{
		Node newNode= new Node(d);
		if(head==null) { head=newNode;System.out.println("head is pointed to"+d); return;}
		
		//traverse till end
		Node curr= head;
		while(curr.next!=null)
		{
			curr=curr.next;
		}
		curr.next=newNode;		
	}
	
	public void insertNodeAtStart(int d)
	{
		Node newNode= new Node(d);
		if(head==null) { head=newNode; return;}
		newNode.next=head;
		head=newNode;
	}
	
	public void deleteFirst() {
		if(isEmpty())return;
		Node temp=head;
		head=head.next;
		temp.next=null;
	}
	
	public void removeDups()
	{
		
	}
	
	public void printList()
	{
		Node temp=head;
		while(temp!=null)
		{
			System.out.print(temp.data + " ");
			temp=temp.next;
		}
		System.out.println("");
	}


}

//https://java2blog.com/implement-singly-linked-list-in-java/
