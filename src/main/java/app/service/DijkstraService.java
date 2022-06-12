package app.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import app.comparator.VertexComparator;
import app.exception.NoPathExist;
import app.model.Edge;
import app.model.MyGraph;
import app.model.Vertex;

/**
 * 09/06/2022.
 *
 * @author Laurent Lamiral
 */
public class DijkstraService {

	public List<Edge> findShortestPath(final MyGraph graph, final Vertex start, final Vertex end) {

		Vertex currentVertex = start;

		final VertexComparator comparator = new VertexComparator(end);
		final List<Vertex> unvisitedVertex = new ArrayList<>(graph.getVertices());

		start.setDistanceToOrigin(0);

		while (currentVertex.getDistanceToOrigin() > -1) {

			unvisitedVertex.remove(currentVertex);

			for (Edge edge : currentVertex.getEdges()) {

				final Vertex neighbor = edge.getVertexEnd();
				final int pathLengthToNeighbor = currentVertex.getDistanceToOrigin() + edge.getDistance();

				int distanceToCompare;

				if (!unvisitedVertex.contains(neighbor)) {
					continue;
				}

				distanceToCompare = neighbor.getDistanceToOrigin();

				if (distanceToCompare == -1 || pathLengthToNeighbor < distanceToCompare) {

					neighbor.setDistanceToOrigin(pathLengthToNeighbor);

					neighbor.setOptimalPathToVertex(
							currentVertex.getOptimalPathToVertex());

					neighbor.addEdgeToPath(edge);

				}

			}

			if (currentVertex.equals(end)) {

				return currentVertex.getOptimalPathToVertex();
			}

			currentVertex = Collections.min(unvisitedVertex, comparator);

		}

		throw new NoPathExist();

	}

}
