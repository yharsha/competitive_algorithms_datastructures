package dynamicProgramming;

import java.util.Arrays;

public class DPprobs {
	
	
	public static int countways(int n)
	{
		if(n<0) {return 0;}
		if(n==0) return 1;
		else {
			return countways(n-1)+countways(n-2)+countways(n-3);
		}
		
	}
	
	public static int countWays_dp(int n)
	{
		int arr[] = new int[n+1];
		Arrays.fill(arr,-1);
		return countWays_dp_util(n,arr);
	}
	

	private static int countWays_dp_util(int n, int[] arr) {
		
		if(n==0)return 1;
		if(n<0)return 0;
		if(arr[n]==-1)
		{
			arr[n]=countWays_dp_util(n-1,arr)+countWays_dp_util(n-2,arr)+countWays_dp_util(n-3,arr);
		}
		return arr[n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countways(25));
		System.out.println(countWays_dp(25));
	}

}
