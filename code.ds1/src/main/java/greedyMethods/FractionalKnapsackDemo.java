package greedyMethods;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsackDemo {
	
	public static void main(String [] args)
	{
		System.out.println("Hello AlgoDS..!!");
		System.out.println("Fractional KnapSack  Demo by Greedy");
		int wt[]=new int[] {10,20,30};
		int val[]=new int[] {60,100,120};
		int  capacity = 50; 
		
		double maxValue = getMaxValue_fractionalKnapsack(wt, val, capacity); 
	    System.out.println("Maximum value we can obtain = " +  
	                            maxValue); 
	}
	
	static double getMaxValue_fractionalKnapsack(int []wt,int []val,int  capacity)
	{
		ItemValue[] iVal=new ItemValue[wt.length];
		for (int i=0;i<wt.length;i++)
		{
			iVal[i]=new ItemValue(wt[i], val[i], i);
		}
				
		//sorting items by value; 
		Arrays.sort(iVal, new Comparator<ItemValue>() {

			public int compare(ItemValue o1, ItemValue o2) {
				// TODO Auto-generated method stub
				
				return o2.cost.compareTo(o1.cost);
			}
			
		});
		
		
		double totalValue=0d;
		
		for(ItemValue x:iVal)
		{
			
			int curWt= (int)x.wt;
			int curVal=(int)x.val;
			
			if(curWt<=capacity)
			{
				capacity=capacity-curWt;
				totalValue=totalValue+curVal;
			}
			else
			{
				// item cant be picked whole 
				double fraction = ((double)capacity/(double)curWt);
				totalValue+=fraction*curVal;
				capacity-=(int)fraction*curWt;
				break;
			}
		}
		
		return totalValue;
		
	}
	
	//item value class
	static class ItemValue
	{
		Double cost;
		double wt,val,ind;
		public ItemValue(int wt,int val,int ind)
		{
			this.wt=wt;
			this.val=val;
			this.ind=ind;
			this.cost=new Double(val/wt);
		}
	}
}

/**
Resources:
https://www.geeksforgeeks.org/fractional-knapsack-problem/
https://www.guru99.com/fractional-knapsack-problem-greedy.html
https://www.geeksforgeeks.org/comparable-vs-comparator-in-java/
**/


