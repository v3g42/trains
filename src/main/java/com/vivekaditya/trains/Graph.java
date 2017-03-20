package com.vivekaditya.trains;

import java.util.*;

/**
 * Interface defining Graph contract
 */
public interface Graph {
    void addEdge(int v1, int v2, int dist);
    int distance(int v1, int v2);
    int getSize();
    LinkedList<Edge> getNeighbors(int v);
}
