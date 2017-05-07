import java.util.*;

public class DriverProgram {

	public static void main(String[] args) {

		Graph graph = new Graph(4);

		graph.addEdge(0,1);
		graph.addEdge(1,2);
		graph.addEdge(1,3);
		graph.addEdge(0,3);

		System.out.println("Vertex count:" + graph.getVertexCount());
		System.out.println("Edge count:" + graph.getEdgeCount() / 2);

		for(int i = 0; i < graph.getVertexCount(); i++) {
			System.out.println(i + " " + graph.getAdjacentVertices(i));
		}
	}
}