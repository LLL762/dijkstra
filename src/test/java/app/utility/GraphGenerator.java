package app.utility;

import app.model.MyGraph;

/**
 * 13/06/2022.
 *
 * @author Laurent Lamiral
 */
public final class GraphGenerator {

    private GraphGenerator() {
    }

    public static MyGraph generateComplexGraph() {

        MyGraph output = new MyGraph();

        output.addVertex(15);

        output.addEdge(1L, 7L, 7);
        output.addEdge(1L, 2L, 2);
        output.addEdge(1L, 15L, 1);

        output.addEdge(2L, 7L, 12);
        output.addEdge(2L, 4L, 36);
        output.addEdge(2L, 5L, 42);
        output.addEdge(2L, 12L, 21);
        output.addEdge(2L, 3L, 10);
        output.addEdge(2L, 6L, 15);

        output.addEdge(3L, 12L, 5);
        output.addEdge(3L, 14L, 1);
        output.addEdge(3L, 15L, 4);

        output.addEdge(4L, 8L, 24);
        output.addEdge(4L, 5L, 42);

        output.addEdge(5L, 8L, 16);
        output.addEdge(5L, 9L, 5);
        output.addEdge(5L, 12L, 1);

        output.addEdge(6L, 7L, 1);

        output.addEdge(10L, 12L, 1);

        output.addEdge(11L, 12L, 7);
        output.addEdge(11L, 13L, 4);

        output.addEdge(12L, 13L, 1);
        output.addEdge(12L, 14L, 5);

        output.addEdge(13L, 14L, 78);

        output.addEdge(14L, 15L, 4);


        return output;
    }


}
