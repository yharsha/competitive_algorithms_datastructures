package bfs_dfs;

import java.beans.IntrospectionException;
import java.util.LinkedList;
import java.util.Queue;


public class WallsAndGates {
	//l,u,r,d
	public static final  int[] dir = {0, 1, 0, -1, 0};
	public static void wallsAndGates(int[][] rooms) {
		int m=rooms.length;
		int n=rooms[0].length;
		for(int i =0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(rooms[i][j]==0)
					//dfs(i,j,0,rooms,m,n);
					bfs(i,j,0,rooms,m,n);
					
			}
		}
	}
	
	public static void dfs(int i,int j, int count,int [][] rooms,int m,int n) {
		if(i<0 || i>=m || j<0 || j>=n || rooms[i][j]<count) return;
		
		rooms[i][j] = count;
		dfs(i,j-1,count+1,rooms,m,n);
		dfs(i+1,j,count+1,rooms,m,n);
		dfs(i,j+1,count+1,rooms,m,n);
		dfs(i-1,j,count+1,rooms,m,n);
		
	}
	
	public static void bfs(int i,int j, int count,int [][] rooms,int m,int n) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(i*n+j);
		
		while(!queue.isEmpty())
		{
			int curr=queue.poll();
			int x=curr/n;
			int y=curr%n;
			
			for(int k=0;k<4;k++) {
				
				int p=x+dir[k];
				int q=y+dir[k+1];
				if(p>=0 && p<m && q>=0 && q<n && rooms[p][q]>rooms[x][y]+1) {
					rooms[p][q]=rooms[x][y]+1;
					queue.add(p*n+q);
				}
			}
			
		}
		
	}
	
	

	public static void main(String[] args) {
	
		int INF = (int) (Math.pow(2, 31)-1);
		int [][] rooms = {
				{INF,-1,0,INF},
				{INF,INF,INF,-1},
				{INF,-1,INF,-1},
				{0,-1,INF,INF}
		};
		
		wallsAndGates(rooms);
		
		for(int i=0;i<rooms.length;i++)
		{
			System.out.println();
			for(int j=0;j<rooms[0].length;j++)
			{
				System.out.print(rooms[i][j]+" ");
			}
		}
		
		
	}

}
