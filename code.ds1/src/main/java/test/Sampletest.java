package test;

public class Sampletest {
	
	public static int countDisplacement(String input)
	{
		//LL?RR??L?RLL - L:5 R:3 M:4 --> L:5 R:5 M:2 --> L:6 R:6
		if(input==null || input.length()==0)return 0;
		
		int leftCount=0,rightCount=0,missing=0;
		for(int i=0;i<input.length();i++)
		{
			char dir = input.charAt(i);
			if(dir=='L')
			{
				leftCount++;
			}else if (dir=='R') {
				rightCount++;
			}else {
				missing++;
			}
		}
		/**min displacement**/
		int diff = Math.abs(leftCount-rightCount);
		
		//L:5 R:3 d:2 M:4 
		// d:5 M:2 --> d: 3 //(d-m)
		// R:11 L:6 M:2 
		
		if(diff>=missing)
		{
			return diff-missing;
		}else
		{
			missing-=diff;
			if(missing%2==0)
				return 0;
			
			return 1;
		}

	
		
		return Math.abs(leftCount-rightCount)+missing;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
