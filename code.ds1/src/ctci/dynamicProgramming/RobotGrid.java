package dynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import javax.security.auth.x500.X500Principal;

public class RobotGrid {
	
    public static boolean validPath(int row,int col,int[][] arr,int maxRow,int maxCol)
    {
        if(row<0 || row>=maxRow) return false;
        if(col<0 || col >= maxCol) return false;
        if(arr[row][col]==1)return false;
        return true;
    }
    
    //An obstacle and empty space are marked as 1 and 0 respectively in the grid.
    // if you are on (x, y), you can either go to (x, y + 1) or (x + 1, y).
    public static int  uniquePath(int [][] arr,int m,int n)
    {
    	return uniquePathUtil(0,0,arr,m,n);
    }

	private static int uniquePathUtil(int i, int j, int[][] arr, int m, int n) {
		
		if(!validPath(i,j,arr,m,n))return 0;
		if(i==m-1 && j==n-1)return 1;
		
		return uniquePathUtil(i+1,j,arr,m,n) + uniquePathUtil(i,j+1,arr,m,n);
		
	}
	
		//dp...along with paths
	   public static int  uniquePath_dp(int [][] arr,int m,int n)
	    {
		   int [][]count=new int [m][n];
		   HashSet<String> set = new HashSet<String>();
		   String path = "(0,0) ->";
	    	int result= uniquePathUtil_dp(0,0,arr,m,n,count,set,path);
	    	printArray(count,m,n);
	    	
	    	System.out.println("Printing Paths");
	    	for(String s:set)
	    	{
	    		System.out.println(s);
	    	}
	    	
	    	return result;
	    	
	    }
	   
	   public static int MagicIndex(int [] arr)
	   {
		   return MagicIndexFast(0,arr.length-1,arr);
	   }
	   


	private static int MagicIndexFast(int start, int end, int[] arr) {
		if(start > end)return -1;
		
		 int mid =(start+end)/2;
		 if(arr[mid]==mid)return mid;
		 else if(arr[mid]>mid)
		 {
			 return MagicIndexFast(start,mid-1,arr);
		 }
		 else 
		 {
			 return MagicIndexFast(mid+1,end,arr);
		 }
	
	}

	private static int uniquePathUtil_dp(int i, int j, int[][] arr, int m, int n, int[][] count, 
			HashSet<String> set,String path) {
		
		if(!validPath(i,j,arr,m,n))return 0;
		path = path + " ("+i+","+j+") ->" ;
		if(i==m-1 && j==n-1) {
			count[i][j]=1;
			set.add(path);
			return count[i][j];
		}
		if(count[i][j]==0)
		{
			count[i][j]=uniquePathUtil_dp(i+1,j,arr,m,n,count,set,path) + uniquePathUtil_dp(i,j+1,arr,m,n,count,set,path);
		}
	
		return count[i][j];
	}
	
	
	   private static void printArray(int [][]  arr,int m,int n)
	   {
	    	for(int i=0;i<m;i++)
	    	{
	    		for(int j=0;j<n;j++)
	    		{
	    			System.out.print(arr[i][j] + " ");
	    		}
	    		System.out.println("");
	    	}
	   }
	   
	   public static ArrayList<ArrayList<Character>> getSubsets(char[] set)
	   {
		   //2^n combinations...equals 1<<set.length
		   ArrayList<ArrayList<Character>> allSubsets = new ArrayList<ArrayList<Character>>();
		   for(int k=0;k<(1<<set.length);k++)
		   {
			   allSubsets.add(getSubsets(k,set,allSubsets));
		   }
		   
		   return allSubsets;
	   }
	   
	private static ArrayList<Character> getSubsets(int k, char[] set, ArrayList<ArrayList<Character>> allSubsets) {
		ArrayList<Character> subset = new ArrayList<Character>();
		int index=0;
		for(int val=k;val>0;val=val>>1)
		{
			if((val&1)==1)subset.add(set[index]);
			
			index++;
		}
		return subset;
	}
	
	public static void permute(String s)
	{
		 permuteUtil(s,0,s.length()-1);
	}

	private static void permuteUtil(String s, int start, int end) {
		
		if(start==end)
		{
			//last character
			System.out.println(s);
		}
			
		for(int i=start;i<=end;i++)
		{
			//swap start with i
			s =swap(s,start,i);
			// remaning part for permute
			permuteUtil(s,start+1,end);
			
			//swap back start with i
			s =swap(s,start,i);
		}
	}

	private static String swap(String s, int start, int i) {
		
		char [] c1 = s.toCharArray();
		char temp = c1[start];
		c1[start]=c1[i];
		c1[i]=temp;
		return String.valueOf(c1);
	}

	public static void main(String[] args) {
		
		int grid [][]= {{0,0,0},
						{0,1,0},
						{0,0,0}
				
		};
		System.out.println(uniquePath(grid,grid.length,grid[0].length));
		System.out.println(uniquePath_dp(grid,grid.length,grid[0].length));
		
		int arr[] = {-40,-20,-1,1,2,3,5,7,9,12,13};
		System.out.println("MagicIndex:"+MagicIndex(arr));
		
		System.out.println("\n");
		System.out.println("Generating subsets of char set");
		char [] set = {'a','b','c','d'};
		ArrayList<ArrayList<Character>> allSubsets = getSubsets(set);
		for(ArrayList<Character> subset:allSubsets)
		{
			System.out.println(subset.toString());
		}
		System.out.println("\n");
		System.out.println("\n Permutations of a string");
		permute("abc");
	}

}
