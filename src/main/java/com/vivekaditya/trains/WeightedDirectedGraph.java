package com.vivekaditya.trains;

import java.util.*;

/**
 * WeightedDirectGraph implementation using AdjacencyList
 */

public class WeightedDirectedGraph implements Graph {

    /**
     * Initialize with a given size, Adjacency List is created.
     * @param size size of the graph
     */
    public WeightedDirectedGraph(int size) {
        this.size = size;
        this.adjacencyList = new LinkedList[size];
    }

    @Override
    public int getSize() {
        return size;
    }

    private int size;
    private LinkedList<Edge> [] adjacencyList;


    /**
     *
     * @param v1 source node
     * @param v2 destination node
     * @param dist weight
     */
    public void addEdge(int v1, int v2, int dist)
    {
        if(dist < 0)
            throw new IllegalArgumentException("Distance must be >= 0");

        if(adjacencyList[v1] == null) adjacencyList[v1] = new LinkedList();

        Edge edge = new Edge(v2,dist);
        adjacencyList[v1].add(edge);
    }

    /**
     *
     * @param v1 source node
     * @param v2 destination node
     * @return distance between two nodes
     */
    public int distance(int v1, int v2)
    {
        ListIterator i = adjacencyList[v1].listIterator(0);
        while(i.hasNext())
        {
            Edge current = (Edge) i.next();			//get the next edge in the adjacency-list
            if(current.node == v2) return current.distance;
        }
        throw new IllegalArgumentException("Cannot find route");
    }

    /**
     *
     * @param v given node
     * @return List of all edges to v
     */
    public LinkedList<Edge> getNeighbors(int v)
    {
        if(adjacencyList[v] == null) adjacencyList[v] = new LinkedList();
        return adjacencyList[v];
    }

}
