package dynamicProgramming;

public class FibinocciDPdemo {
	
	
	//tc : o(2^n)
	public static int fibonacii_recursive(int n)
	{
		if(n==0)return 0;
		if(n==1)return 1;
		return fibonacii_recursive(n-1)+fibonacii_recursive(n-2);
		
	}
	
	
	//top_down:memoization..tc : o(n)
	public static int fibonacii_dp_topdown(int n)
	{
		int []fib = new int [n+1];
		fib[1]=1;
		return dp_topdown_recursive(n, fib);
	}
	
	public static int dp_topdown_recursive(int n,int []fib)
	{
		if(n==0 || n==1) return n;
	
		if(fib[n]==0)
		{
			fib[n]=dp_topdown_recursive(n-1,fib)+dp_topdown_recursive(n-2,fib);
		}
		return fib[n];
	}
	
	//bottom_up:Tabulation..tc : o(n)
	public static int fibonacii_dp_bottomup(int n)
	{
		int []fib = new int [n+1];
		fib[0]=0;
		fib[1]=1;
		
		for(int i=2;i<=n;i++)
		{
			fib[i]=fib[i-1]+fib[i-2];
		}
		return fib[n];
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Long start= System.currentTimeMillis();
		int value = fibonacii_recursive(42);
		Long end= System.currentTimeMillis();
		System.out.println("fibonacii_recursive...tc : o(2^n)");
		System.out.println(" TotalTime in sec: "+((end-start)/1000F) + " FibValue: "+value);
		
		System.out.println("\n");
		 start= System.currentTimeMillis();
		 value = fibonacii_dp_topdown(64);
		 end= System.currentTimeMillis();
			System.out.println("fibonacii_dp_topdown...tc : o(n)");
			System.out.println(" TotalTime in sec: "+((end-start)/1000F) + " FibValue: "+value);
			
			
			
			System.out.println("\n");
			 start= System.currentTimeMillis();
			 value = fibonacii_dp_bottomup(64);
			 end= System.currentTimeMillis();
				System.out.println("fibonacii_dp_bottomup...tc : o(n)");
				System.out.println(" TotalTime in sec: "+((end-start)/1000F) + " FibValue: "+value);
	}

}
