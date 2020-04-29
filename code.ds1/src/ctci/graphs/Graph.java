package graphs;

import java.io.BufferedWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import javax.management.Descriptor;
import javax.print.attribute.standard.Destination;

import com.sun.corba.se.impl.orbutil.graph.Node;

public class Graph<T> {
	
	// We use Hashmap to store the edges in the graph 
	HashMap<T, LinkedList<T>> map = new HashMap<T, LinkedList<T>>();
	
	public void addVertex(T s)
	{
		map.put(s, new LinkedList<T>());
	}
	
	public void addEdge(T source,T destination,boolean bidirectional)
	{
		if(!map.containsKey(source))
		map.put(source, new LinkedList<T>());
		
		if(!map.containsKey(destination))
			map.put(destination, new LinkedList<T>());
		
		map.get(source).addLast(destination);
		if(bidirectional)
		map.get(destination).addLast(source);

	}
	
	public void printVertices()
	{
		System.out.println("Graph vertices are:");
		
		for( T x : map.keySet())
		{
			System.out.print(x+" ");
		}
	}
	
    public void getVertexCount() 
    { 
        System.out.println("The graph has "
                           + map.keySet().size() 
                           + " vertex"); 
    } 
    
    public void getEdgesCount(boolean bidirectional)
    {
    	int count=0;
    	for( T v:map.keySet())
    	{
    		count+=map.get(v).size();
    	}
    	
    	if(bidirectional)count=count/2;
    	
    	  System.out.println("The graph has "
                  + count 
                  + " edges."); 
    }
    
    public void hasVertex(T s)
    {
    	if(map.containsKey(s)) {System.out.println("The graph contains "
                + s + " as a vertex."); }
    	else {
    	    System.out.println("The graph does not contain "
                    + s + " as a vertex."); 
    	}
    }
    
    public void hasEdge(T s,T d)
    {
    	if(map.get(s).contains(d)) {
    		System.out.println("The graph has an edge between "
                    + s + " and " + d + "."); 
    	}
    	else {
    		  System.out.println("The graph has no edge between "
                      + s + " and " + d + "."); 
    		  
    	}
    }

    @Override
    public String toString() {
    	
    	StringBuilder builder = new StringBuilder();
    	System.out.println("Printing Graph...");
    	
    	for(T v:map.keySet())
    	{
    		builder.append(v.toString()+" : ");
    		for(T w:map.get(v))
    		{
    			builder.append(w.toString()+" ");
    		}
    		builder.append("\n");
    	}
    	
    	return builder.toString();
    	
    }    
    
    public void dfs_recursive(T data)
    {
    	//for  integers
    	boolean [] visited = new boolean [map.keySet().size()];
    	System.out.println("---DFS---");
    	dfs_util(data, visited);
    	
    	
    }
    
    private void dfs_util(T data,boolean [] visited)
    {
    	System.out.print(data+" ");
    	visited[(Integer) data]=true;
    	for(T node:map.get(data) )
    	{
    		if(!visited[(Integer) node])
    		dfs_util(node, visited);
    	}
    	
    }
    
    
    public void dfs_withoutRecursion(T data)
    {
    	System.out.println("");
    	System.out.println("---DFS---");
    	boolean [] visited = new boolean[map.keySet().size()];
		Stack<Integer> stack = new Stack<Integer>();
		stack.push((Integer) data);
		while (!stack.isEmpty()) {
			int value = stack.pop();
			if (!visited[value]) {
				System.out.print(value + " ");
				visited[value] = true;
				for (T node : map.get(value)) {
					if (!visited[(Integer) node])
						stack.push((Integer) node);
				}
			}
		}
    }
    
    public void bfs(T data)
    {
    	System.out.println("");
    	System.out.println("---BFS---");
    	
    	boolean visited[]=new boolean[map.keySet().size()];
    	Queue<Integer> queue =  new LinkedList<Integer>();
    	queue.add((Integer) data);
    	
    	while(!queue.isEmpty())
    	{
    		int value=queue.remove();
    		if(!visited[value])
    		{
    			visited[value]=true;
    			System.out.print(value+" ");
    			for(T node : map.get(value))
    			{
    				if(!visited[(Integer) node])
    					queue.add((Integer) node);
    			}
    			
    		}
    	}
    }
    
    public boolean checkPathExists(T source,T destination)
    {
    	boolean visited[]=new boolean[map.keySet().size()];
    	return checkPathExistsUtil(source,destination,visited);
    }
   
    private boolean checkPathExistsUtil(T source,T destination,boolean [] visited)
    {
    	visited[(Integer) source]=true;
    	
    
    		for(T node:map.get(source))
    		{
    			if(node==destination) return true;

    			if(!visited[(Integer) node])
    				return checkPathExistsUtil(node,destination,visited);
    		}
    	
    	return false;
    }
    
    
    public void TopologicalSort()
    {
    	boolean visited [] = new boolean[map.keySet().size()];
    	Stack<Integer> stack =  new Stack<Integer>();
    	for(T x:map.keySet())
    	{
    		TopologicalSort(x,visited,stack);
    	}
    	System.out.println("topological sort...parent at left..childs at right");
    	while(!stack.isEmpty())
    	{
    		System.out.print(stack.pop());
    	}
    	
    }
    
    public void TopologicalSort(T vertex,boolean visited [],Stack<Integer> stack)
    {
    	visited[(Integer) vertex]=true;
    	
    	//iterate all its children...child need to be executed before parent
    	for(T child:map.get(vertex))
    	{
    		if(!visited[(Integer) child])
    			TopologicalSort(child,visited,stack);
    	}
    	stack.add((Integer) vertex);
    	
    }

}



//ref: https://www.geeksforgeeks.org/implementing-generic-graph-in-java/
//https://www.baeldung.com/java-depth-first-search
