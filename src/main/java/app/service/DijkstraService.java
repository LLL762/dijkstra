package app.service;

import static app.utility.VertexUtility.getDijktraVertexById;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import app.comparator.DijktraVertexComparator;
import app.exception.NoPathExist;
import app.model.DijktraVertex;
import app.model.Edge;
import app.model.MyGraph;

/**
 * 09/06/2022.
 *
 * @author Laurent Lamiral
 */
public class DijkstraService {

	public List<Edge> findShortestPath(final MyGraph graph, final Long startId, final Long endId) {

		final Set<DijktraVertex> unvisitedVertices = graph.mapToDijktraVertices();
		final DijktraVertex start = getDijktraVertexById(startId, unvisitedVertices)
																					.orElseThrow();

		final DijktraVertex end = getDijktraVertexById(endId, unvisitedVertices)
																				.orElseThrow();

		final DijktraVertexComparator comparator = new DijktraVertexComparator(end);

		DijktraVertex currentVertex = start;

		start.setDistanceToOrigin(0);

		while (currentVertex.getDistanceToOrigin() > -1) {

			unvisitedVertices.remove(currentVertex);

			checkNeighbors(currentVertex, unvisitedVertices);

			if (currentVertex.equals(end)) {

				return currentVertex.getOptimalPathToVertex();
			}

			currentVertex = Collections.min(unvisitedVertices, comparator);

		}

		throw new NoPathExist();

	}

	private void checkNeighbors(final DijktraVertex currentVertex, final Set<DijktraVertex> unvisitedVertices) {

		for (Edge edge : currentVertex.getEdges()) {

			final Optional<DijktraVertex> neighbor = getDijktraVertexById(edge.getVertexEndId(), unvisitedVertices);

			if (neighbor.isEmpty()) {
				continue;
			}

			final int pathLengthToNeighbor = currentVertex.getDistanceToOrigin() + edge.getDistance();

			final int distanceToCompare = neighbor.get().getDistanceToOrigin();

			if (distanceToCompare == -1 || pathLengthToNeighbor < distanceToCompare) {

				neighbor.get().setDistanceToOrigin(pathLengthToNeighbor);

				neighbor.get().setOptimalPathToVertex(
						currentVertex.getOptimalPathToVertex());

				neighbor.get().addEdgeToPath(edge);

			}

		}

	}
}
