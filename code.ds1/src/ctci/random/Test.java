package random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Test {

	public static void main (String[] args) throws IOException
	 {
	 //code
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tests = Integer.parseInt(br.readLine());
		for(int i=0;i<tests;i++)
		{
		    String [] str1 = br.readLine().split(" ");
		    int len1=Integer.parseInt(str1[0]);
		    int len2=Integer.parseInt(str1[1]);
		    int [] arr1 = new int[len1];
		    int [] arr2 = new int[len2];
		    
		    str1 = br.readLine().split(" ");
		    String [] str2 = br.readLine().split(" ");
		    
		    for(int j=0;j<len1;j++)
		    {
		        arr1[j]=Integer.parseInt(str1[j]);
		    }
		    
		  for(int j=0;j<len2;j++)
		    {
		        arr2[j]=Integer.parseInt(str2[j]);
		    }
		    sortArrays(arr1,arr2,len1,len2);
		   System.out.println("");
		}
	 }
	 
	public static void sortArrays(int [] arr1,int [] arr2,int len1,int len2)
	{
	    int p1=0,p2=0;
	    while(p1<len1)
	    {
    	    if(arr1[p1]<arr2[p2])
    	    {
    	        p1++;
    	    }
    	    else if (arr1[p1]<arr2[p2])
    	    {
        	        //swap
        	    swap(arr1,arr2,p1,p2);
        	    p1++;
        	      //adjust temp in array2
        	    Arrays.sort(arr2);
    	    }
	    }
	    	    for(int j=0;j<len1;j++)
		    {
		        System.out.print(arr1[j]+" ");
		    }
		    
		  for(int j=0;j<len2;j++)
		    {
		        System.out.print(arr2[j]+" ");
		    }
	}
	
	public static void swap(int [] arr1,int []arr2,int p1,int p2)
	{
	      int temp=  arr1[p1];
	      arr1[p1]=arr2[p2];
	      arr2[p2]=temp;
	}


}
