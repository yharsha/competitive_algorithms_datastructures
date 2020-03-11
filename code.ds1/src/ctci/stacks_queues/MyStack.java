package stacks_queues;

import java.util.Arrays;
import java.util.EmptyStackException;

public class MyStack <T> {
	
	public class stackNode <T> {
		private T data;
		private stackNode<T> next;
		public stackNode(T data) {
			this.data=data;
		}
	}
	
	private stackNode top;
	
	public boolean isEmpty()
	{
		return top==null;
	}
	
	public T pop()
	{
		if(top==null) throw new EmptyStackException();
		T item = (T) top.data;
		top=top.next;
		return item;
		
	}
	
	public void push(T data)
	{
		stackNode<T> newNode = new stackNode<T>(data);
		newNode.next=top;
		top=newNode;
	}
	
	public T peek()
	{
		if(top==null) throw new EmptyStackException();
		return (T) top.data;
	}

}
