package stacks_queues;

import java.util.NoSuchElementException;

public class MyQueue <T> {
	
	private static class QueueNode<T>{
		private T data;
		private QueueNode next;
		public QueueNode(T data)
		{
			this.data=data;
		}
	}
	
	private QueueNode <T> first;
	private QueueNode <T> last;

	//remove at first...add at last
	public void add(T data)
	{
		QueueNode<T> node = new QueueNode<T>(data);
		if(last!=null) {
			last.next=node;
		}
		last=node;
		if(first==null)first=node;
	}
	
	public T remove() {
		if(first==null)throw new NoSuchElementException();
		T data = first.data;
		first=first.next;
		if(first==null)
		{
			last=null;
		}
		return data;
		
	}
	
	public T peek() {
		if(first==null)throw new NoSuchElementException();
		return first.data;
	}
	
	public boolean isEmpty() {
		return first==null;
	}
}
