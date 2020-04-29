package bitManipulation;

public class BitManipulationDemo {
	
	public static void shiftDifference()
	{
		int x =-93242,count=40;
		
		//logical shift >>> will replace sign bit by 0
		
		for(int i=0;i<count;i++)
		{
			x>>>=1;
		}
		System.out.println("logical shift: "+x);
		
	//Arithmetic shift >> will replace sign bit by 1
		x =-93242;
		for(int i=0;i<count;i++)
		{
			x>>=1;
		}
		System.out.println("Arithmetic shift: "+x);
	}
	
	public static void commonBitTasks()
	{
		//Get bit- (1<<i) will be like 000010000 do & ,u get particular bit
		int num=12;
		System.out.println("get bit for num 12(1100) # 1<<2 =(0100)...{(num &(1<<2))!=0)}:  " + ((num &(1<<2))!=0));
		
		//Set bit- (1<<i) will be like 000010000 do | ,u set particular bit
		int num1=4;
		System.out.println("Set bit for num1 4(0100) # 1<<3 =(1000)...{(num | (1<<2)))}:  " + ((num1 | (1<<3))));

		//to clear a particular bit
		int num2=12;
		int mask=~(1<<3);
		System.out.println("Clear bit for num2 12(1100) # 1<<3 =(1000)...{(num & ~(1<<3)))}:  " + ((num2 & mask)));
		
		//to clear most significant bits till i(inclusive) 1<<i
		int mask1 = (1<<2)-1;
		System.out.println("to clear most significant bits till i..mask:0011: num 15(1111):   "+ (15 & mask1));
		
		
		//to clear most significant bits from i(inclusive)  till end (-1<<(i+1))
		//-1 is seqeunce of all1's
		int x=-1;
	
		System.out.println(Integer.toBinaryString(x));
		int i=2;
		int mask3=x<<(i+1);
		System.out.println(Integer.toBinaryString(mask3));
		System.out.println(Integer.toBinaryString(mask3&-1));
		
	}
	/**
	 
	Input: N 10000000000, M 10011, 
	i 2, j 6 
	Output:N = 10001001100
	 **/
	 
	public static void Insertion()
	{
		int M=(int)Math.pow(2, 10);
		int N=19;
		int j=6,i=2;
		System.out.println("\n");
		System.out.println("\n -------Insertion in between positions----");
		System.out.println("M: "+Integer.toBinaryString(M));
		System.out.println("N: "+Integer.toBinaryString(N));
		
		
		//create a mask to clear between i & j positions
		int left_mask = (~0)  <<(j+1); //all ones to left of j
		int right_mask = (1<<i)-1; //all ones to right of i
		
		int mask = left_mask | right_mask;
		
		//clear M with mask
		M = M& mask;
		
		//shift N by i places
		M =  M |( N  << i);
		
		System.out.println("Result: "+Integer.toBinaryString(M));
		
		
	}
	
	public static String ConvertToBinary(double num)
	{
		if(num>=1 || num <=0)
		{
			return "Error";
		}
		
		StringBuilder result = new StringBuilder();
		
		result.append(".");
		
		while(num>0)
		{
			if(result.length()>32)return "Error";
			
			num*=2;
			if(num>=1)
			{
				result.append("1");
				num-=1;
			}
			else
			{
				result.append("0");
			}
		}
		return result.toString();
	}
	
	/**
	 Input: 29 (or: 11101), 15 (or: 01111)
	 Output: 2
	 **/
	public static void conversionDiff()
	{
		int a =29,b=15;
		int count=0;
		System.out.println("a=29: > " + Integer.toBinaryString(a));
		System.out.println("b=15: > " + Integer.toBinaryString(b));
		System.out.println("a ^ b > " + Integer.toBinaryString(a^b));
		//xor
		for(int c=a^b;c!=0;c=c>>1)
		{
			count+=c&1;;
		}
		System.out.println("count"+ count);
	}
	
	public static void swapOddEven()
	{
		int num = 37;
		System.out.println("num:"+Integer.toBinaryString(num));
		int value =( (num&0xAAAAAA) >>> 1 | (num&0x555555) << 1);
		
		System.out.println(value);
		System.out.println("num:"+Integer.toBinaryString(value));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		shiftDifference();
		//bit position starts from 0
		System.out.println("1<<0: " + (1<<0));
		System.out.println("1<<1: " + (1<<1));
		commonBitTasks();
		Insertion();
		System.out.println("\n");
		System.out.println("ConvertToBinary:> "+ConvertToBinary(0.125));
		
		System.out.println("\n");
		conversionDiff();
		swapOddEven();
	}

}
