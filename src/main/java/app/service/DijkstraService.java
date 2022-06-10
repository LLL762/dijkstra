package app.service;

import app.comparator.VertexComparator;
import app.exception.NoPathExist;
import app.model.Edge;
import app.model.MyTree;
import app.model.Path;
import app.model.Vertex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 09/06/2022.
 *
 * @author Laurent Lamiral
 */
public class DijkstraService {

    public Path findShortestPath(final MyTree tree, final Vertex start, final Vertex end) {

        Vertex currentVertex = start;
        int currentDistance = 0;


        final VertexComparator comparator = new VertexComparator(end);
        final List<Vertex> unvisitedVertex = new ArrayList<>(tree.getVertices());


        start.setDistanceToOrigin(0);
        unvisitedVertex.remove(currentVertex);

        while (currentVertex.getDistanceToOrigin() > -1) {

            for (Edge edge : currentVertex.getEdges()) {

                final Vertex neighbor = edge.getVertexEnd();
                final int pathLengthToNeighbor = currentDistance + edge.getDistance();
                int distanceToCompare;

                if (!unvisitedVertex.contains(neighbor)) {
                    continue;
                }

                distanceToCompare = neighbor.getDistanceToOrigin();

                if (distanceToCompare == -1 || pathLengthToNeighbor < distanceToCompare) {

                    neighbor.setDistanceToOrigin(pathLengthToNeighbor);

                    neighbor.setOptimalPathToVertex(
                            currentVertex.getOptimalPathToVertex());

                    neighbor.getOptimalPathToVertex().addEdge(edge);

                }

                if (currentVertex.equals(end)) {

                    return currentVertex.getOptimalPathToVertex();
                }


            }

            currentVertex = Collections.min(unvisitedVertex, comparator);

        }


        throw new NoPathExist();

    }

}
