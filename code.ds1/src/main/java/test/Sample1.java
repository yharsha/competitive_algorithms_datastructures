package test;

import java.awt.print.Printable;
import java.util.HashMap;

import javax.swing.text.StyledEditorKit.ForegroundAction;

/**
 * 
 Problem2: Given a list of metrics which represents number of tasks running or completed at a time.
{ “timestamp”: 131221343434, “count”: 3, “status”: “RUNNING”}
This means 3 tasks are running at time: 131221343434
{ “timestamp”: 3143141344314, “count”: 3, “status”: “COMPLETED”}
This means 3 tasks are completed at time: 3143141344314

You need to find busiest time interval when more number of  tasks were running.
Input:
[


  { “timestamp”: t1 “count”: 1, “status”: “RUNNING”}, 1
 { “timestamp”: t2, “count”: 3, “status”: “RUNNING”}, 4
  { “timestamp”: t3, “count”: 4, “status”: “COMPLETED”}, 0
 { “timestamp”: t4, “count”: 6, “status”: “RUNNING”}, 6
  { “timestamp”: t5 “count”: 1, “status”: “COMPLETED”}, 5
  { “timestamp”: t6, “count”: 2, “status”: “RUNNING”}, 7
  { “timestamp”: t7 “count”: 1, “status”: “COMPLETED”}, 2
  { “timestamp”: t8 “count”: 1, “status”: “COMPLETED”}, 1

]

Output:
{
  “start”: t4,
  “end”: t6
}
//
 * HMap
 * 1,7
 * 2,12 : t4 : t6 - 6
 * 3,18 - 6
 * 4,20 - 5
 * 
 * 
 * 1.get curr task at every timestamp
 *  1 4 0 6 5 7 2 1 
 *  t1 t2 
 *  2.max value in arr
 * 2.

 * @author hyadala
 *
 */
public class Sample1 {
	
	class node{
		int timestamp;
		int count;
		String status;
	}
	class result{
		String start;
		String end;
	}
	
	public static result calulateBusyTimeSlot(node [] slots)
	{
		int maxIndex=-1;
		int tasks=0,max=Integer.MIN_VALUE;
		int [] runningTasks = new int [slots.length];
		//array of running tasks
		for(int i=0;i<slots.length;i++)
		{
			node curr =slots[i];
			if(curr.status.equals("RUNNING"))
			{
				tasks+=curr.count;
			}else if(curr.status.equals("COMPLETED")) {
				tasks-=curr.count;
			}
			if(max<tasks)
			{
				max=tasks;
				maxIndex = i;
			}
			runningTasks[i]=tasks;	
		}
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		//map for sliding window
		map.put(1, runningTasks[maxIndex]);
		int i=maxIndex-1,j=maxIndex+1;
		
		int prevValue=max;
		while(i>=0 && j<runningTasks.length)
		{
	
		
			int value = (runningTasks[i] > runningTasks[j] )? runningTasks[i]:runningTasks[j];
			value+=prevValue;
			map.put(j-i+1, value/(j-i+1));
			prevValue=value;
		}
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		printUtility(0);
	}
	
	
	
	public static void printUtility(int val) {
		if(val>10) return;
		System.out.println(val);
		printUtility(val+1);
	}
	

}
