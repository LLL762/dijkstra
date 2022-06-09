import java.util.List;
import java.util.PriorityQueue;

import comparator.VertexComparator;
import model.Vertex;

public class Main {

	public static void main(String[] args) {

		// TODO write a test instead.

		List<Vertex> vertices = List.of(new Vertex(1L),
				new Vertex(2L),
				new Vertex(3L),
				new Vertex(4L),
				new Vertex(5L));

		vertices.get(0).setDistanceToOrigin(47);
		vertices.get(4).setDistanceToOrigin(25);
		vertices.get(2).setDistanceToOrigin(78);

		final PriorityQueue<Vertex> unvisitedVertex = new PriorityQueue<>(
				5,
				new VertexComparator());

		unvisitedVertex.addAll(vertices);

		// System.out.println(unvisitedVertex.peek());

		unvisitedVertex.poll();

		System.out.println(unvisitedVertex);

	}

}
