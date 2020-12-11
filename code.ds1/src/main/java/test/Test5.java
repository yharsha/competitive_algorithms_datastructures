package test;

import java.util.HashMap;
import java.util.HashSet;

/**
 public interface Intervals {

     //Adds an interval [from, to) into an internal structure.
  
     * Returns a total length covered by the added intervals.
     * If several intervals intersect, the intersection should be counted only once.
     * Example:
     * <p>
     * addInterval(3, 6)
     * addInterval(8, 9)
     * addInterval(1, 5)
     * 
     * (3,5) (8) (1,4)
     * 1...4..5 8
     * <p>
     * getTotalCoveredLength() -> 6
     * <p>
     * i.e. [1,5) and [3,6) intersect and give a total covered interval [1,6) with a length of 5.
     * [1,6) and [8,9) don't intersect, so the total covered length is a sum of both intervals, that is 5+1=6.
     * <p>
     *          |__|__|__|                  (3,6)
     *                         |__|         (8,9)
     *    |__|__|__|__|                     (1,5)
     * <p>
     * 0  1  2  3  4  5  6  7  8  9  10
 
}**/
public class Test5 implements Intervals{
	
	HashSet<Integer> set = new HashSet<Integer>();


	public void addInterval(int from, int to) {
		
		for(int i=from;i<to;i++)
		{
			if(!set.contains(i))
				set.add(i);
				
		}
		
	}

	public int getTotalCoveredLength() {
		// TODO Auto-generated method stub
		return set.size();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test5 obj = new Test5();
	obj.addInterval(3, 6);
	obj.addInterval(8,9);
	obj.addInterval(1, 5);
	System.out.println(obj.getTotalCoveredLength());

	}


}
