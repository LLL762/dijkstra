package app.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DijktraVertex extends Vertex {

	private List<Edge> optimalPathToVertex = new ArrayList<>();
	private int distanceToOrigin = -1; // -1 represents infinity.

	public DijktraVertex(Long id) {
		super(id);

	}

	public DijktraVertex(final Vertex vertex) {

		super(vertex.getId(), vertex.getName(), vertex.getEdges());

	}

	public void addEdgeToPath(Edge edge) {

		optimalPathToVertex.add(edge);

	}

	public List<Edge> getOptimalPathToVertex() {

		return new ArrayList<>(optimalPathToVertex);

	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

}
