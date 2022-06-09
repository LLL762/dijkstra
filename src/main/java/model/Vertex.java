package model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Set;

/**
 * 09/06/2022.
 *
 * @author Laurent Lamiral
 */
@RequiredArgsConstructor
@Data
public class Vertex {

    private final Long id;
    private Set<Edge> edges;


    public void addVertex(Vertex vertex, int distance) {

        final Edge edge = new Edge(this, vertex, distance);

        this.edges.add(edge);
        vertex.edges.add(new Edge(vertex, this, distance));

    }


}
