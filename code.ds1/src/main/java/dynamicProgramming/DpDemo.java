package dynamicProgramming;

public class DpDemo {
	
	//By Recursion
	public static long fibonacci(long n)
	{
		if(n<=1) return n;
		return fibonacci(n-1)+fibonacci(n-2);
		//time taken by recursive Fibonacci is O(2^n) or exponential.
	}
	
	
	
	//DP-Time Complexity: O(n) , Space Complexity : O(n)
	//By Memoization-Top down approach

	public static class Fibonacci 
	{ 
	  int MAX=100;
	  int NIL=-1;
	  
	  int lookup[]=new int[MAX];
	  void _initialize()
	  {
		  for (int i=0;i<MAX;i++)
			  lookup[i]=NIL;
	  }
	  
	  int fib(int n)
	  {
		  if(lookup[n]==NIL)
		  {
			  if(n<=1)lookup[n]= n;
			  else
				  
				  lookup[n]= fib(n-1)+fib(n-2);
		  }
		  return lookup[n];
	  }  
	} 
	
	////By Tabulation (Bottom Up) approach
	public static int fib_tab(int n)
	{
		int f[]=new int[n+1];
		f[0]=0;
		f[1]=1; 
		
		for(int i=2;i<=n;i++)
		{
			f[i]=f[i-1]+f[i-2];
		}
		return f[n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fibonacci(10));
	    Fibonacci f = new Fibonacci(); 
	    int n = 10; 
	    f._initialize(); 
	    System.out.println("Fibonacci number by By Memoization-Top down approach" + " " + f.fib(n)); 
	    System.out.println("Fibonacci number by Tabulation (Bottom Up) approach" + " " + fib_tab(n)); 
		

	}

}
//Ref: https://www.geeksforgeeks.org/overlapping-subproblems-property-in-dynamic-programming-dp-1/
