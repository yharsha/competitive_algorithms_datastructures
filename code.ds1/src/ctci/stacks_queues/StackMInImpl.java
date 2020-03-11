package stacks_queues;

public class StackMInImpl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackWithMin minStack = new StackWithMin();
		minStack.push(5);
		System.out.println(minStack.min());
		minStack.push(6);
		System.out.println(minStack.min());
		minStack.push(3);
		System.out.println(minStack.min());
		minStack.push(7);
		System.out.println(minStack.min());
		minStack.pop();
		System.out.println(minStack.min());
		minStack.pop();
		System.out.println(minStack.min());
		minStack.pop();
		System.out.println(minStack.min());

	}

}
