package model;

import java.util.Objects;
import java.util.Set;

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
	private Set<Edge> edges;
	private int distanceToOrigin = -1; // -1 represents infinity.

	public void addVertex(Vertex vertex, int distance) {

		final Edge edge = new Edge(this, vertex, distance);

		this.edges.add(edge);
		vertex.edges.add(new Edge(vertex, this, distance));

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
