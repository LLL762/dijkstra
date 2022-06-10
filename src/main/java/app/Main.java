package app;

import app.comparator.VertexComparator;
import app.model.Vertex;

import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {

        // TODO write a test instead.

        Vertex v = new Vertex(6L);


        List<Vertex> vertices = List.of(new Vertex(1L),
                new Vertex(2L),
                new Vertex(3L),
                new Vertex(4L),
                new Vertex(5L));


        vertices.get(0).setDistanceToOrigin(47);
        vertices.get(4).setDistanceToOrigin(25);
        vertices.get(2).setDistanceToOrigin(78);

        System.out.println(Collections.min(vertices, new VertexComparator(new Vertex(7L))));


        final PriorityQueue<Vertex> unvisitedVertex = new PriorityQueue<>(
                5,
                new VertexComparator(new Vertex(7L)));

        unvisitedVertex.addAll(vertices);

        unvisitedVertex.add(v);

        unvisitedVertex.remove(v);
        v.setDistanceToOrigin(12);
        unvisitedVertex.add(v);


        // System.out.println(unvisitedVertex.peek());


        System.out.println(unvisitedVertex.peek());
        System.out.println(unvisitedVertex);

    }

}
