package model;

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

}
