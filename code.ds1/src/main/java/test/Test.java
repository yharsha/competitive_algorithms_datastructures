package test;

public class Test {
	
	//start-(1,1) //end(4,5)
	//R,D
	
	public static int findPaths(int m,int n) {
		//default -0
		int [][] memo = new int [m+1][n+1];
		memo[1][1]=1;
	
		return findPathsUtil(m,n,memo);
	}
	
	public static int findPathsUtil(int m,int n,int [][] memo) {
		
		if(memo[m][n]!=0)return memo[m][n];
		if(m==1 && n==1) return 1;
		
		//boundary cases
		if(m<1 || n<1) return 0;
		
		memo[m][n]=findPathsUtil(m,n-1,memo)+findPathsUtil(m-1,n,memo);
		return memo[m][n];
		
	}

	public static void main(String[] args) {
	
		System.out.println(findPaths(3,1));
	}

}
