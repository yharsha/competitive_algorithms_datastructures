package test;

import java.util.ArrayList;
import java.util.List;

public class Sample implements Runnable{
	
	public void run() {
		System.out.printf("%d",2);
	}

	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		String s="Fab";
		String t = new String(s);
		int value=0;
		value= (s==t)?1:2;
		System.out.println(value);
		System.out.println(t.equals(s));
	}

}
