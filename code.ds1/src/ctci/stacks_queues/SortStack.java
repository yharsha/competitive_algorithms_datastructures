package stacks_queues;

import java.util.Stack;

public class SortStack {
	
	
	public static Stack<Integer> sort(Stack<Integer> s)
	{
		//buffer will have sorted elements
		Stack<Integer> buffer = new Stack<Integer>();
		
		while(!s.isEmpty())
		{
			int temp=s.pop();
			
			while(!buffer.isEmpty() && temp <buffer.peek() )
			{
				s.push(buffer.pop());
			}
			buffer.push(temp);
		}
		
		while(!buffer.isEmpty()) {
			System.out.println("Pushing to stack"+buffer.peek());
			s.push(buffer.pop());
			}
		
		
		return s;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> stack= new Stack<Integer>();
		stack.push(2);
		stack.push(9);
		stack.push(12);
		stack.push(5);
		stack.push(2);
		stack.push(19);
		stack.push(6);
		stack.push(3);
		sort(stack);
	}

}
