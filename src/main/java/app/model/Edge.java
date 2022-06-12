package app.model;

import lombok.RequiredArgsConstructor;
import lombok.Value;

/**
 * 09/06/2022.
 *
 * @author Laurent Lamiral
 */
@RequiredArgsConstructor
@Value
public class Edge {

	Vertex vertexStart;
	Vertex vertexEnd;
	int distance;

	@Override
	public String toString() {
		return "Edge [vertexStart=" + vertexStart.getId() + ", vertexEnd=" + vertexEnd.getId() + ", distance="
				+ distance + "]";
	}

}
