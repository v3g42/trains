package com.vivekaditya.trains;

/**
 * Created by vivek on 20/3/17.
 */
public class Edge {
    public int getNode() {
        return node;
    }

    public int getDistance() {
        return distance;
    }

    int node;
    int distance;

    /**
     *
     * @param node destination node of this edge
     * @param distance weight of this edge
     */
    public Edge(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }
}
