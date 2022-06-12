package app.comparator;

import java.util.Comparator;

import app.model.Vertex;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class VertexComparator implements Comparator<Vertex> {

	private final Vertex endVertex;

	@Override
	public int compare(final Vertex v1, final Vertex v2) {

		final int distance1 = v1.getDistanceToOrigin();
		final int distance2 = v2.getDistanceToOrigin();
		final boolean haveSameDistance = distance1 == distance2;

		if (distance1 == -1) {

			return haveSameDistance ? 0 : 1;

		}

		if (distance2 == -1) {

			return -1;
		}

		if (haveSameDistance) {

			if (v2.equals(endVertex)) {

				return -1;
			}
			if (v1.equals(endVertex)) {

				return 1;
			}
			return 0;

		}

		return Integer.signum(distance1 - distance2);

	}

}
