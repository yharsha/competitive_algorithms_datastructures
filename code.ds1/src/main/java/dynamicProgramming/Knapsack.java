package dynamicProgramming;


public class Knapsack {
	
	static int max(int a,int b)
	{
		return a>b?a:b;
	}
	
	//tc:o(2^n)
	private static int knapSack(int W,int [] wt,int [] val,int n)
	{
		if(n==0||W==0) return 0;
		
		//if weight of nth item > W ..then exclude it
		if(wt[n-1]>W)
			return knapSack(W, wt, val, n-1);
		
		//two options including nth item or without including nth item
		return max(val[n-1]+knapSack(W-wt[n-1], wt, val, n-1),knapSack(W, wt, val, n-1));
	}
	
	//dp-bottom up
	private static int knapSack_dp(int W,int []wt,int [] val,int n)
	{
		int dp[][]= new int [n+1][W+1];
		int i,w;
		
		 // Build table dp[][] in bottom up manner 
		for( i=0;i<=n;i++)
		{
			for(w=0;w<=W;w++)
			{
				if(i==0||w==0)dp[i][w]=0;
				
				else if(wt[i-1]<=w)
					dp[i][w]=max(val[i-1]+dp[i-1][w-wt[i-1]], dp[i-1][w]);
				else {
					dp[i][w]=dp[i-1][w];
				}
			}
		}
		return dp[n][W];
	}
	
	//memeoization
	private static int knapSack_dp_topdown(int W,int []wt,int [] val,int n)
	{
		int dp[][]=new int [n+1][W+1];
		for(int i=0;i<=n;i++)
			for(int w=0;w<=W;w++)
				dp[i][w]=-1;
		return knapSack_dp_topdown_utility( W,wt,val,n,dp);
	}
	
	
	private static int knapSack_dp_topdown_utility(int W, int[] wt, int[] val, int n, int[][] dp) {
		if(n==0||W==0)return 0;
		if(dp[n][W]!=-1)
			return dp[n][W];
		if(wt[n-1]>W) {
			dp[n][W]=knapSack_dp_topdown_utility(W,wt,val,n-1,dp);
			return dp[n][W];
		}
		else
		{
			dp[n][W]=max(val[n-1]+knapSack_dp_topdown_utility(W-wt[n-1],wt,val,n-1,dp),
					knapSack_dp_topdown_utility(W,wt,val,n-1,dp));
			return dp[n][W];
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int val[] = new int[] { 60, 100, 120 }; 
        int wt[] = new int[] { 10, 20, 30 }; 
        int W = 50; 
        int n = val.length; 
        System.out.println(knapSack(W, wt, val, n)); 
        System.out.println(knapSack_dp(W, wt, val, n)); 
        System.out.println(knapSack_dp_topdown(W, wt, val, n)); 
	}

	

}
