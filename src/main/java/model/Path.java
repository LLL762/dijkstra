package model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * 09/06/2022.
 *
 * @author Laurent Lamiral
 */
@NoArgsConstructor
@Data
public class Path {

    private final ArrayList<Edge> edges = new ArrayList<>();
    private int sumDistance;


    public void addEdge(final Edge edge) {

        edges.add(edge);
        sumDistance += edge.getDistance();

    }


    public List<Edge> getPath() {
        return new ArrayList<>(edges);
    }


}
