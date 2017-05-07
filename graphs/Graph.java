import java.util.*;

public class Graph {

	private int V;
	private LinkedList[] adj;

	public Graph(int V) {
		this.V = V;
		adj = new LinkedList[V];
		for(int i = 0; i < V; i++)
			adj[i] = new LinkedList();
	}

	public void addEdge(int v, int w) {
		adj[v].add(w);
		adj[w].add(v);
	}

	public LinkedList getAdjacentVertices(int v) {
		return adj[v];
	}

	public int getVertexCount() {
		return V;
	}

	public int getEdgeCount() {
		int count = 0;
		for(int i = 0; i < V; i++)
			count += adj[i].size();
		return count;
	}
}