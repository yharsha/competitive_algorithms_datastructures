package test;

import java.sql.BatchUpdateException;
import java.sql.DatabaseMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import javax.naming.ldap.ExtendedRequest;
import javax.sound.midi.VoiceStatus;

import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * 
 * arrival
 * deptarture
 *
 */
class officeSpace{
	Elevator [];
	
	
	public void processElevetors(Elevator []) {
		
	}
	
}

class Elevator{
	int status;
	booelan emergency;
	
	public void processRequests(controlPanel) {
		//---
	}
	
	Public void emergencyRequest() {
		
	}
	
}


class floor{
	//inouts up or down
	boolean up;
	boolean down;
}

class controlPanel{
	//1-9
	//Queue<E>
}


public class Sample3 {
	/**
	 * 	DatabaseMetaData
		//50 gb 
		//ram - 50mb ~ batch 
		1. Batch - check src -target
		2.Hashing - src - target -Ext file - sharding
		
		a-e.txt f-h.txt ..z.txt
		
		banglore : [hyd,mum,del]
				
		hyd:[]
		
				bfs 
		3.**/
	
	public static boolean isRouteAvailable(String src,String target)
	{
		if(src.equals(target))return true;
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		ArrayList<String> [] buckets = new ArrayList [10];
		for(int i=0;i<10;i++)
		{
			buckets[i]=new ArrayList<String>();		
		}
		HashSet<Integer> visited = new HashSet<Integer>();
		//assume i have data in graph structure
		
		
		//doing bfs
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(map.get(src));
		visited.add(map.get(src));
		while(!q.isEmpty())
		{
			int curr = q.poll();
			if(curr==map.get(target))
			{
				return true;
			}
			
			for(ArrayList<String> list : buckets[curr])
			{
				
			}

		}
		
		return true;
	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n=10;
		int [] arr = new int [10];
		
		for(int i=0;i<arr.length;i++) {
			PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
			
			//5 elements
			int k=5;
			if(queue.size()<k)
			{
				queue.add(arr[i]);
			}else if(queue.peek()<arr[i]){
				queue.poll();
				queue.add(arr[i]);				
				
			}
			
			//5th largest element
			System.out.println(queue.peek());
			
			
		}
		
	}

}
