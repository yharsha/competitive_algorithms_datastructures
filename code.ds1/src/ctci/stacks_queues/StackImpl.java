package stacks_queues;

public class StackImpl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyStack<Integer> st = new MyStack<Integer>();
		st.push(1);
		st.push(2);
		st.push(3);
		
		System.out.println(st.peek());
		st.pop();
		System.out.println(st.peek());
		st.pop();
		System.out.println(st.peek());
		st.pop();
		System.out.println(st.isEmpty());
		//System.out.println(st.peek());
		//st.pop();
	}

}
