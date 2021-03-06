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

	Long vertexEndId;
	int distance;

	public Edge copy() {

		return new Edge(this.vertexEndId, this.distance);

	}

}
