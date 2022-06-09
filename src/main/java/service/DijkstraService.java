package service;

import model.Edge;
import model.MyTree;
import model.Path;
import model.Vertex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        final List<Vertex> unvisitedVertex = tree.getVertices();
        final Map<Vertex, Integer> tentativeDistance = new HashMap<>();

        tentativeDistance.put(start, 0);

        for (Edge edge : currentVertex.getEdges()) {

            final Vertex neighbor = edge.getVertex2();
            final int pathLengthToNeighbor = currentDistance + edge.getDistance();
            int distanceToCompare;

            if (!unvisitedVertex.contains(neighbor)) {
                break;
            }

            distanceToCompare = tentativeDistance.get(neighbor);

            if (pathLengthToNeighbor < distanceToCompare) {

                tentativeDistance.put(neighbor, pathLengthToNeighbor);
            }
        }

        unvisitedVertex.remove(currentVertex);

        if (currentVertex == end) {

            return currentPaths;
        }


        //  unvisitedVertex.


        return currentPaths;

    }


}
