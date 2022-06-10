package app.model;

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

    private ArrayList<Edge> edges = new ArrayList<>();
    private int length;

    public void addEdge(final Edge edge) {

        edges.add(edge);
        length += edge.getDistance();

    }

    public List<Edge> getPath() {
        return new ArrayList<>(edges);
    }

}
