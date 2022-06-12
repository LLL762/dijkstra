package app.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * 09/06/2022.
 *
 * @author Laurent Lamiral
 */
@RequiredArgsConstructor
@Data
public class Vertex {

	private final Long id;
	private List<Edge> edges = new ArrayList<>();
	private List<Edge> optimalPathToVertex = new ArrayList<>();
	private int distanceToOrigin = -1; // -1 represents infinity.

	public void addEdge(Vertex vertex, int distance) {

		final Edge edge = new Edge(this, vertex, distance);

		this.edges.add(edge);
		vertex.edges.add(new Edge(vertex, this, distance));

	}

	public void addEdgeToPath(Edge edge) {

		optimalPathToVertex.add(edge);

	}

	public List<Edge> getOptimalPathToVertex() {

		return new ArrayList<>(optimalPathToVertex);

	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Vertex other = (Vertex) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

}
