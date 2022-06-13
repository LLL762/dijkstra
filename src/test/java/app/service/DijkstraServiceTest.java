package app.service;

import app.exception.NoPathExist;
import app.model.Edge;
import app.model.MyGraph;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;

import static app.utility.GraphGenerator.generateComplexGraph;
import static org.assertj.core.api.Assertions.*;

/**
 * 10/06/2022.
 *
 * @author Laurent Lamiral
 */
class DijkstraServiceTest {

    private final DijkstraService dijkstraService = new DijkstraService();

    private MyGraph simpleGraph;

    @BeforeEach
    private void setUpBaseGraph() {

        simpleGraph = new MyGraph();

        simpleGraph.addVertex(5);

        simpleGraph.addEdge(1L, 2L, 2);
        simpleGraph.addEdge(1L, 3L, 1);
        simpleGraph.addEdge(2L, 4L, 36);
        simpleGraph.addEdge(2L, 5L, 42);

    }

    @Test
    @DisplayName(value = "simple-graph-00.jpg")
    void test_simple_tree() {

        final Edge[] expectedResult = {new Edge(2L, 2), new Edge(5L, 42)};

        final List<Edge> actualResult = dijkstraService.findShortestPath(simpleGraph, 1L, 5L);

        assertThat(actualResult).containsExactly(expectedResult);

    }

    @Test
    @DisplayName(value = "simple-graph-01.jpg")
    void test_simple_tree2() {

        final Edge[] expectedResult = {new Edge(2L, 2), new Edge(4L, 36), new Edge(5L, 1)};

        simpleGraph.addEdge(4L, 5L, 1);

        final List<Edge> actualResult = dijkstraService.findShortestPath(simpleGraph, 1L, 5L);

        assertThat(actualResult).containsExactly(expectedResult);

    }

    @Test
    @DisplayName(value = "start=end")
    void when_start_equal_end_should_empty() {

        final List<Edge> actualResult = dijkstraService.findShortestPath(simpleGraph, 1L, 1L);

        assertThat(actualResult).isEmpty();

    }

    @Test
    @DisplayName(value = "Start id is null")
    void when_start_id_is_null() {

        assertThatExceptionOfType(NoSuchElementException.class).isThrownBy(
                () -> dijkstraService.findShortestPath(simpleGraph, null, 5L));

    }

    @Test
    @DisplayName(value = "End id is negative")
    void when_end_id_is_negative() {

        assertThatExceptionOfType(NoSuchElementException.class).isThrownBy(
                () -> dijkstraService.findShortestPath(simpleGraph, 1L, -5L));

    }

    @Test
    @DisplayName(value = "Start id not in graph")
    void when_start_id_is_not_in_the_graph() {

        assertThatExceptionOfType(NoSuchElementException.class).isThrownBy(
                () -> dijkstraService.findShortestPath(simpleGraph, 7L, 5L));

    }

    @Test
    @DisplayName(value = "End id not in graph")
    void when_end_id_is_not_in_the_graph() {

        assertThatExceptionOfType(NoSuchElementException.class).isThrownBy(
                () -> dijkstraService.findShortestPath(simpleGraph, 1L, 7L));

    }

    @Test
    @DisplayName(value = "no path beween start and end")
    void when_start_and_end_are_not_connected() {

        simpleGraph.removeEdge(2L, new Edge(5L, 42));

        assertThatExceptionOfType(NoPathExist.class).isThrownBy(
                () -> dijkstraService.findShortestPath(simpleGraph, 1L, 5L));

    }

    @Test
    @DisplayName(value = "Graph is null")
    void when_graph_is_null() {

        assertThatNullPointerException().isThrownBy(
                () -> dijkstraService.findShortestPath(null, 1L, 5L));

    }

    @Test
    @DisplayName(value = "complex-graph-01.jpg")
    void test_more_complex_graph_01() {

        final MyGraph graph = generateComplexGraph();

        final Edge[] expectedResult1 = {
                new Edge(15L, 1),
                new Edge(3L, 4),
                new Edge(12L, 5),
                new Edge(5L, 1)
        };

        final Edge[] expectedResult2 = {
                new Edge(15L, 1),
                new Edge(14L, 4),
                new Edge(12L, 5),
                new Edge(5L, 1)
        };

        final List<Edge> actualResult = dijkstraService.findShortestPath(graph, 1L, 5L);
        

        assertThat(actualResult).satisfiesAnyOf(
                a -> assertThat(actualResult).containsExactly(expectedResult1),
                a -> assertThat(actualResult).containsExactly(expectedResult2)

        );


    }

    @Test
    @DisplayName(value = "complex-graph-02.jpg")
    void test_more_complex_graph_02() {

        final MyGraph graph = generateComplexGraph();

        graph.removeEdge(1L, new Edge(15L, 1));
        graph.addEdge(1L, 15L, 12);

        graph.removeEdge(2L, new Edge(3L, 10));
        graph.addEdge(2L, 3L, 25);


        final Edge[] expectedResult1 = {
                new Edge(15L, 12),
                new Edge(3L, 4),
                new Edge(12L, 5),
                new Edge(5L, 1)
        };

        final Edge[] expectedResult2 = {
                new Edge(15L, 12),
                new Edge(14L, 4),
                new Edge(12L, 5),
                new Edge(5L, 1)
        };

        final List<Edge> actualResult = dijkstraService.findShortestPath(graph, 1L, 5L);

        assertThat(actualResult).satisfiesAnyOf(
                a -> assertThat(actualResult).containsExactly(expectedResult1),
                a -> assertThat(actualResult).containsExactly(expectedResult2)

        );


    }


}