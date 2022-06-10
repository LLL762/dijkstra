package app.service;

import app.model.MyTree;
import app.model.Path;
import app.model.Vertex;
import org.junit.jupiter.api.Test;

/**
 * 10/06/2022.
 *
 * @author Laurent Lamiral
 */
class DijkstraServiceTest {

    private final DijkstraService dijkstraService = new DijkstraService();


    @Test
    void test_simple_tree() {

        Vertex start = new Vertex(1L);
        Vertex vertex2 = new Vertex(2L);
        Vertex vertex3 = new Vertex(3L);
        Vertex vertex4 = new Vertex(4L);
        Vertex end = new Vertex(5L);
        

        start.addEdge(vertex2, 2);
        start.addEdge(vertex3, 1);
        vertex2.addEdge(vertex4, 36);
        start.addEdge(end, 42);

        MyTree tree = new MyTree();

        tree.getVertices().add(start);
        tree.getVertices().add(vertex2);
        tree.getVertices().add(vertex3);
        tree.getVertices().add(vertex4);
        tree.getVertices().add(end);

        Path expectedResult = new Path();


        dijkstraService.findShortestPath(tree, start, end);


    }


}