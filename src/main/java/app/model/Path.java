package app.model;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 09/06/2022.
 *
 * @author Laurent Lamiral
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Path {

	private ArrayList<Edge> edges = new ArrayList<>();

}
