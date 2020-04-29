package mathPuzzles;

public class Mathpuzzles {
	
	
	public static boolean checkPrime(int n)
	{
		
		if(n<2)return false;
		
		int limit=(int)Math.sqrt(n);
		
		for(int i=2;i<=limit;i++)
		{
			if(n%i==0)return false;
		}
		return true;
	}
	
	public static boolean [] getPrimeList(int n)
	{
		boolean flags[]=new boolean[n+1];
		
		for(int i=2;i<=n;i++)
		{
			flags[i]=true;
		}
		
		int prime=2;
		
		
		while(prime*prime<=n)
		{
			//crossoff all multiples of prime
			crossoff(prime,flags);
			//get next prime from list
			prime=getNextPrime(prime,flags);
		}
		
		return flags;
		
	}
	
	public static void crossoff(int prime,boolean [] flags)
	{
		for(int i=prime*prime;i<flags.length;i=i+prime)
		{
			flags[i]=false;
		}
	}
	
	public static int getNextPrime(int prime,boolean [] flags)
	{
		int next=prime+1;
		
		while(next<flags.length && !flags[next] )
		{
			next++;
		}
		return next;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(checkPrime(4));
		int num=100;
		System.out.println("\n Prime numbers List");
		boolean [] flags = getPrimeList(num);
		for(int i=2;i<=num;i++)
		{
			if(flags[i])
			System.out.print(i+" ");
		}
		
	}
	
	

}
