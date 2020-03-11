package graphs;

public class GraphImpl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph<Integer> graph = new Graph<Integer>();
		graph.addEdge(0, 1, true);
		graph.addEdge(0, 4, true);
		graph.addEdge(1, 4, true);
		graph.addEdge(1, 3, true);
		graph.addEdge(1, 2, true);
		graph.addEdge(2, 3, true);
		graph.printVertices();
		graph.getEdgesCount(true);
		System.out.println(graph.toString());
		graph.dfs_recursive(0);
		graph.dfs_withoutRecursion(0);
		graph.bfs(0);
		System.out.println("Path exists:"+graph.checkPathExists(0, 4));
	}

}
