package comparator;

import java.util.Comparator;

import model.Vertex;

public class VertexComparator implements Comparator<Vertex> {

	@Override
	public int compare(final Vertex v1, final Vertex v2) {

		final int distance1 = v1.getDistanceToOrigin();
		final int distance2 = v2.getDistanceToOrigin();

		if (distance1 == -1) {

			return distance1 == distance2 ? 0 : 1;

		}

		if (distance2 == -1) {

			return -1;
		}

		return Integer.signum(distance1 - distance2);

	}

}
