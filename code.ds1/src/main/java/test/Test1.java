package test;
//Rate limiter - token bucket

import java.util.LinkedList;
import java.util.Queue;


class TokenAccess extends Thread{
	Queue<Integer> queue;
	
	TokenAccess(Queue<Integer> queue)
	{
		this.queue=queue;
	}
	public void run()
	{
		
			while(true) {
			System.out.println("Accessing a token...");
			if(queue.isEmpty())
			{
				System.out.println("Checked queue condition");
	
				while(queue.isEmpty())
				{
					System.out.println("Waiting for token...");
					try {
						this.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}else
			{
				//grab a single token
					System.out.println(queue.poll());
			}
			}
	}
}


class fillToken extends Thread{
	Queue<Integer> queue;
	
	fillToken(Queue<Integer> queue)
	{
		this.queue=queue;
	}
	
	public void run() {
		
		
			while(true) {
			int count=1;
			System.out.println("Adding tokens"+Thread.class.getName());
			while(count<11)
				queue.add(count++);
			try {
				this.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		
	}
}

public class Test1 {
	static Queue<Integer> queue = new LinkedList<Integer>();



	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		TokenAccess t1 = new TokenAccess(queue);
		TokenAccess t2 = new TokenAccess(queue);
		fillToken fill1 = new fillToken(queue);
		fillToken fill2 = new fillToken(queue);
		fill1.start();
		t1.start();
		//fill2.start();
		//t2.start();
		

	}

}
