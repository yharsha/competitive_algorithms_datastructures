package stacks_queues;

import java.util.Stack;

public class QueueUsingStacks <T> {
	Stack<T> stackNew;
	Stack<T> stackOld;
	
	QueueUsingStacks()
	{
		stackNew= new Stack<T>();
		stackOld= new Stack<T>();
	}
	
	public void add(T data)
	{
		stackNew.add(data);
	}
	
	public void shiftStacks()
	{
		if(stackOld.isEmpty())
		{
			while(!stackNew.isEmpty())
			{
				stackOld.push(stackNew.pop());
			}
		}
	}
	
	public T remove()
	{
		shiftStacks();
		return stackOld.pop();
	}
	
	public T peek()
	{
		shiftStacks();
		return stackOld.peek();
	}

}
