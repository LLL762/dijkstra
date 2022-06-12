package app.comparator;

import java.util.Comparator;

import app.model.DijktraVertex;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DijktraVertexComparator implements Comparator<DijktraVertex> {

	private final DijktraVertex endVertex;

	@Override
	public int compare(final DijktraVertex v1, final DijktraVertex v2) {

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
