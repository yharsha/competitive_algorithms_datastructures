package arrays_strings;

public class ArrayProblems {
	
	public static Boolean checkUniqueString(String str)
	{
		if(str.length()>128)return false;
		boolean [] char_Set = new boolean[128];
		for(int i=0;i<str.length();i++)
		{
			int val = str.charAt(i);
			if(char_Set[val])
			{
				return false;
			}
			char_Set[val]=true;
		}
		return true;
	}
	
	public static void permute(String str,int start,int end)
	{
		if(start==end) {System.out.println(str.toString());}
		else {
			for(int i=start;i<=end;i++)
			{
				str=swap(str, start,i );
				permute(str, start+1, end);
				str=swap(str, start, i);
			}
			
		}
		
	}
	
	
	public static String swap(String str1,int i,int j)
	{
		char [] ch = str1.toCharArray();
		char tmp = ch[i];
		ch[i]=ch[j];
		ch[j]=tmp;
		str1=String.valueOf(ch);
		
		return str1;
	}
	
	public static boolean checkStringPermutation(String s,String t) {
		
		if(s.length()!=t.length()) return false;
		int [] arr = new int [128];
		
		for (char c:s.toCharArray()) {
			arr[c]++;
		}
		
		for (char c:t.toCharArray()) {
			arr[c]--;
			if(arr[c]<0) return false;
		}
		
		return true;
	}
	
	public static String replaceSpace(String s) {
		char [] arr = s.toCharArray();
		int spaceCount=0;
		
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]==' ') spaceCount++;
		}
		
		int newLength = arr.length+(spaceCount*2);
		
		char [] newArr = new char[newLength];
		int index =0;
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]==' ')
			{
				newArr[index++]='%';
				newArr[index++]='2';
				newArr[index++]='0';
			}
			else
			{
			newArr[index]=arr[i];
			index++;
			}
		}
		return String.valueOf(newArr);
		
	}
	
	public static boolean isPermutationOfPalindrome(String s) {
		char arr [] = new char [128];
		int oddCount=0;
		
		for(char c:s.toCharArray()) {
			arr[c]++;
			if(arr[c]%2==0)
			{
				oddCount--;
			}
			else {
				oddCount++;
			}
		}
		
		return oddCount <=1 ;
	}
	
	public static boolean checkIfOneEditAway(String s1,String s2) {
		if(s1.length()==s2.length()) {
		 return oneEditReplace(s1,s2);
		}
		else if(s1.length()+1 == s2.length()) {
			//shoter,bigger
			return oneEditInsert(s1,s2);
		}
		else if (s1.length()-1	 == s2.length()) {
			return oneEditInsert(s2,s1);
		}

		
		return false;
	}
	
	public static boolean oneEditReplace(String s1,String s2) {
		
		int index1=0,index2=0;
		boolean foundDiff=false;
		
		while(index1<s1.length() && index2<s2.length()) {
			
			if(s1.charAt(index1)!=s2.charAt(index2)) {
				if(foundDiff) return false;
				foundDiff=true;
			}
			index1++;
			index2++;
		}
		
		return true;
	}
	
	
	public static boolean oneEditInsert(String s1,String s2) {
		int index1=0,index2=0;
	
		
		while(index1<s1.length() && index2<s2.length()) {
			if(s1.charAt(index1)!=s2.charAt(index2)) {
			if(index1!=index2) {return false;}
				index2++;
			}
			else {
			index1++;
			index2++;
			
		}
		}
		
		return true;
	}
	
	public static String compressString(String s)
	{
		int count=0;
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<s.length();i++)
		{
			count++;
			if( (i+1)>= s.length() || s.charAt(i)!=s.charAt(i+1))
			{
				sb.append(s.charAt(i));
				sb.append(count);
				count=0;
			}
		}
		
		return sb.length() < s.length() ? sb.toString() : s;
	}
	
	public static void rotateMatrix(int N,int arr[][])
	{
		//find no of squares to shift
		for(int x=0;x<N/2;x++)
		{
			//consider like a normal 1d array
			for(int y=x;y<N-1-x;y++)
			{
				int val=arr[x][y];
				//shift left to top
				arr[x][y] = arr[N-1-y][x];
				
				//shift bottom to left
				arr[N-1-y][x]= arr[N-1-x][N-1-y];
				
				//right to bottom
				arr[N-1-x][N-1-y] = arr[y][N-1-x];
				
				//top to right
				arr[y][N-1-x] = val;
			}
		}
	}
	
   public  static void displayMatrix(int N, int mat[][]) 
    { 
        for (int i = 0; i < N; i++) 
        { 
            for (int j = 0; j < N; j++) 
                System.out.print(" " + mat[i][j]); 
       
            System.out.print("\n"); 
        } 
        System.out.print("\n"); 
    } 
   
   public static void zeroMatrix(int arr[][],int N)
   {
	   boolean rowHasZero = false,columnHasZero=false;
	   
	   
	   int m=arr.length;
	   int n=arr[0].length;
	   
	 //check if first row has zero
	   for(int j=0;j<n;j++)
	   {
		   if(arr[0][j]==0)
		   {
			   rowHasZero=true;
			   break;
		   }
	   }
	   
		 //check if first column has zero
	   for(int i=0;i<m;i++)
	   {
		   if(arr[i][0]==0)
		   {
			   columnHasZero=true;
			   break;
		   }
	   }
	   
	   //check which all rows or columns have zero
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] == 0) {
					arr[i][0] = 0;
					arr[0][j] = 0;
				}
			}
		}
		
		//Nullify rows
		for(int i=1;i<m;i++)
		{
			if(arr[i][0]==0) nullifyRow(arr, i);
		}
		
		//Nullify cols
		for(int j=1;j<n;j++)
		{
			if(arr[0][j]==0) nullifyColumn(arr, j);
		}
		
		if(rowHasZero)nullifyRow(arr, 0);
		if(columnHasZero)nullifyColumn(arr, 0);
		
   }
   
   public static void nullifyRow(int arr[][],int row)
   {
	   for(int j=0;j<arr[0].length;j++)
	   {
		   arr[row][j]=0;
	   }
   }
   
   public static void nullifyColumn(int arr[][],int col)
   {
	   for(int i=0;i<arr.length;i++)
	   {
		   arr[i][col]=0;
	   }
   }
   
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(checkUniqueString("Harsha.."));
		String name="ABC";
		//permute("ABC", 0, name.length()-1);
		System.out.println("Is it a permuation? " + checkStringPermutation("Abc","bAc"));
		System.out.println("After Replace space "+ replaceSpace("Mr John Smith"));
		System.out.println("isPermutationOfPalindrome: "+ isPermutationOfPalindrome("HAH"));
		System.out.println("Is one Edit Away: "+checkIfOneEditAway("pale", "bae"));
		System.out.println("Compressed String: "+compressString("aabcccccaaa"));
		  int N = 4; 
          
	        // Test Case 1 
	        int mat[][] = 
	        { 
	            {1, 2, 3, 4}, 
	            {5, 6, 7, 8}, 
	            {9, 10, 11, 12}, 
	            {13, 14, 15, 16} 
	        }; 
	        rotateMatrix(N,mat); 
	        
	        // Print rotated matrix 
	        System.out.println("-----Rotated clockwise 90 degree Matrix----");
	        displayMatrix(N,mat); 
	        System.out.println("");
	        System.out.println("-----Zero Matrix----");
	        int mat1[][] = 
		        { 
		            {1, 2, 3, 4}, 
		            {5, 0, 7, 8}, 
		            {9, 10, 11, 12}, 
		            {13, 14, 15, 0} 
		        }; 
	        zeroMatrix(mat1, N);
	        displayMatrix(N, mat1);

	}

}
