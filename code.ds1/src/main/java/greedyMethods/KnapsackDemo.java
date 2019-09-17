package greedyMethods;

import java.util.Arrays;

public class KnapsackDemo {
	
	static int max(int a,int b) {return (a>b)?a:b;}

	//returns maximum value 
	// Time complexity of this naive recursive solution is exponential (2^n).
	static int knapsack(int W,int n,int val[],int wt[])
	{
		//base case
		if(n==0|| W==0) return 0;
		
	      
	    // If weight of the nth item is more than Knapsack capacity W, then 
	    // this item cannot be included in the optimal solution 
		if(wt[n-1]>W)
			return knapsack(W, n-1, val, wt);
		
		  // Return the maximum of two cases:  
	    // (1) nth item included  
	    // (2) not included 
		//get max of(  nth item included,nth item excluded)
		return max(val[n-1]+knapsack(W-wt[n-1], n-1, val, wt),
				knapsack(W, n-1, val, wt));
	}
	
	// Returns the maximum value that can be put in a knapsack of capacity W 
	static int knapsack_dp(int W,int n,int val[],int wt[])
	{
		int karr[][]=new int[n+1][W+1];
		
		//i is item
		for(int i=0;i<=n;i++)
		{
			//j-weight 0 to W
			for(int j=0;j<=W;j++)
			{
			
				if(i==0||j==0)karr[i][j]=0;
				
				else if(wt[i-1]<= j)
				{
					karr[i][j]=max(val[i-1]+karr[i-1][j-wt[i-1]],karr[i-1][j]);
				}
				else
					karr[i][j]=karr[i-1][j];
			}
		}
		//System.out.println(Arrays.deepToString(karr));
		
		for (int i = 0; i < karr.length; i++)
			System.out.println(Arrays.toString(karr[i]));
		return karr[n][W];
			
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			System.out.println("Hello AlgoDS..!!");
			System.out.println("KnapSack  Demo by Greedy");
			int wt[]=new int[] {10,20,30};
			int val[]=new int[] {60,100,120};
			int  W = 50; 
			int n = val.length; 
			System.out.println("max value by greedy:"+knapsack(W, n, val, wt));
			System.out.println("max value by dp:"+knapsack_dp(W, n, val, wt));   
			
	}

}
/**
Resources:
	https://www.geeksforgeeks.org/greedy-algorithms/	
	https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/
	https://www.guru99.com/knapsack-problem-dynamic-programming.html
**/
