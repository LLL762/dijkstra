package service;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import comparator.VertexComparator;
import model.Edge;
import model.MyTree;
import model.Path;
import model.Vertex;

/**
 * 09/06/2022.
 *
 * @author Laurent Lamiral
 */
public class DijkstraService {

	public Iterable<Path> findShortestPath(final MyTree tree, final Vertex start, final Vertex end) {

		Vertex currentVertex = start;
		int currentDistance = 0;

		final List<Path> currentPaths = new ArrayList<>();
		final PriorityQueue<Vertex> unvisitedVertex = new PriorityQueue<>(
				tree.getVertices().size(),
				new VertexComparator());

		unvisitedVertex.addAll(tree.getVertices());

		start.setDistanceToOrigin(0);
		unvisitedVertex.remove(start);

		for (Edge edge : currentVertex.getEdges()) {

			final Vertex neighbor = edge.getVertexEnd();
			final int pathLengthToNeighbor = currentDistance + edge.getDistance();
			int distanceToCompare;

			if (!unvisitedVertex.contains(neighbor)) {
				break;
			}

			distanceToCompare = neighbor.getDistanceToOrigin();

			if (distanceToCompare == -1 || pathLengthToNeighbor < distanceToCompare) {

				neighbor.setDistanceToOrigin(pathLengthToNeighbor);

			}
		}

		unvisitedVertex.remove(currentVertex);

		if (currentVertex == end) {

			return currentPaths;
		}

		unvisitedVertex.peek();

		return currentPaths;

	}

}
