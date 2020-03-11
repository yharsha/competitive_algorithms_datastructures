package stacks_queues;

public class QueueUsingStacksImpl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QueueUsingStacks<Integer> queue = new QueueUsingStacks<Integer>();
		queue.add(1);
		queue.add(2);
		queue.add(3);
		queue.add(4);
		queue.add(5);
		queue.add(6);
		System.out.println(queue.remove());
		System.out.println(queue.peek());
		System.out.println(queue.remove());
		System.out.println(queue.peek());
		System.out.println(queue.remove());
		System.out.println(queue.peek());
		System.out.println(queue.remove());
		System.out.println(queue.peek());
		System.out.println(queue.remove());
		System.out.println(queue.peek());
		queue.add(7);
	}

}
