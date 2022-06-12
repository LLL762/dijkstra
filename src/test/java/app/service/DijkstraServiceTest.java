package app.service;

import org.junit.jupiter.api.Test;

import app.model.MyGraph;
import app.model.Vertex;

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
		vertex2.addEdge(end, 42);

		MyGraph graph = new MyGraph();

		graph.getVertices().add(start);
		graph.getVertices().add(vertex2);
		graph.getVertices().add(vertex3);
		graph.getVertices().add(vertex4);
		graph.getVertices().add(end);

		System.out.println(dijkstraService.findShortestPath(graph, start, end));

	}

	@Test
	void test_simple_tree2() {

		Vertex start = new Vertex(1L);
		Vertex vertex2 = new Vertex(2L);
		Vertex vertex3 = new Vertex(3L);
		Vertex vertex4 = new Vertex(4L);
		Vertex end = new Vertex(5L);

		start.addEdge(vertex2, 2);
		start.addEdge(end, 74);
		start.addEdge(vertex3, 1);
		vertex2.addEdge(vertex4, 36);
		vertex2.addEdge(end, 42);
		vertex4.addEdge(end, 1);

		MyGraph graph = new MyGraph();

		graph.getVertices().add(start);
		graph.getVertices().add(vertex2);
		graph.getVertices().add(vertex3);
		graph.getVertices().add(vertex4);
		graph.getVertices().add(end);

		System.out.println(dijkstraService.findShortestPath(graph, start, end));

	}

}