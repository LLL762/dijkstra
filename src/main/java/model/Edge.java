package model;

import lombok.RequiredArgsConstructor;
import lombok.Value;

/**
 * 09/06/2022.
 *
 * @author Laurent Lamiral
 */
@RequiredArgsConstructor
@Value
public class Edge {

    Vertex vertex1;
    Vertex vertex2;
    int distance;


}
