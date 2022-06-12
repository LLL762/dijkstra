package app.utility;

import java.util.Collection;
import java.util.Optional;

import app.model.DijktraVertex;
import app.model.Vertex;

public final class VertexUtility {

	private VertexUtility() {

	}

	public static Optional<Vertex> getVertexById(final Long id, final Collection<Vertex> collection) {

		return collection	.stream()
							.filter(v -> v.getId().equals(id))
							.findFirst();

	}

	public static Optional<DijktraVertex> getDijktraVertexById(final Long id,
			final Collection<DijktraVertex> collection) {

		return collection	.stream()
							.filter(v -> v.getId().equals(id))
							.findFirst();

	}

}
