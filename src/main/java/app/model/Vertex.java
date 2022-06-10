package app.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Objects;
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
    private Path optimalPathToVertex;
    private int distanceToOrigin = -1; // -1 represents infinity.

    public void addEdge(Vertex vertex, int distance) {

        final app.model.Edge edge = new app.model.Edge(this, vertex, distance);

        this.edges.add(edge);
        vertex.edges.add(new app.model.Edge(vertex, this, distance));

    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Vertex other = (Vertex) obj;
        return Objects.equals(id, other.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
