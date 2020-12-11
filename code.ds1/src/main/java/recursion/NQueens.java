package recursion;

public class NQueens {
	
	 public static int totalNQueens(int n) {
		 
		int [] [] mat = new int [n][n];
		NQueensUtil(mat,0,n);
		return n;
		 
	 }
	 
	 public static void NQueensUtil(int [][]mat ,int col,int n)
	 {
		 //base case
		 if(col>=n) {
			 System.out.println(); 
			 printSolution(mat,n);
			 return;
			 }
		 
		 for(int row =0;row<n;row++)
		 {
			 //check place of queen
			 if(isSafe(mat, row, col, n))
			 {
				 mat[row][col]=1;
				 NQueensUtil(mat,col+1,n);
				
					//backtrack 
					mat[row][col]=0;
				
			 }
			 
			 
		 }
		 
		 
	 }
	 
	 private static boolean isSafe(int [][]mat,int row,int col,int n)
	 {
		 
		 //check row
		 for(int i=0;i<col;i++)
		 {
			 if(mat[row][i]==1) return false;
		 }
		 
		 
		 //check upper left diagonal
		 int i=row,j=col;
		 while(i>=0 && j>=0)
		 {
			 if(mat[i][j]==1)return false;
			 i--;
			 j--;
		 }
		 
		 //check lower left diagonal
		  i=row;j=col;
		 while(i<n && j>=0 )
		 {
			 if(mat[i][j]==1)return false;
			 i++;
			 j--;
		 }
		 
		 
		 return true;
	 }
	 
	 static void printSolution(int board[][],int N) 
	    { 
	        for (int i = 0; i < N; i++) { 
	            for (int j = 0; j < N; j++) 
	                System.out.print(" " + board[i][j] 
	                                 + " "); 
	            System.out.println(); 
	        } 
	    } 
	 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		totalNQueens(6);
	}

}
