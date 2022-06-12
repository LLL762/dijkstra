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
	private String name;
	private List<Edge> edges = new ArrayList<>();

	protected Vertex(Long id, String name, List<Edge> edges) {
		this.id = id;
		this.name = name;
		this.edges = edges;
	}

	public void addEdge(Vertex vertex, int distance) {

		final Edge edge = new Edge(vertex.getId(), distance);

		this.edges.add(edge);

	}

	public void removeEdge(Edge edge) {

		this.edges.remove(edge);

	}

	public Vertex copy() {

		return new Vertex(this.id, this.name, edges.stream().map(Edge::copy).toList());

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
