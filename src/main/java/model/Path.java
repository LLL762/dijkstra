package model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 09/06/2022.
 *
 * @author Laurent Lamiral
 */
@NoArgsConstructor
@Data
public class Path {

	private final ArrayList<Edge> edges = new ArrayList<>();
	private int length;

	public void addEdge(final Edge edge) {

		edges.add(edge);
		length += edge.getDistance();

	}

	public List<Edge> getPath() {
		return new ArrayList<>(edges);
	}

}
