package com.vivekaditya.trains.test;

import static org.junit.Assert.*;

import com.vivekaditya.trains.Edge;
import com.vivekaditya.trains.Graph;
import com.vivekaditya.trains.WeightedDirectedGraph;
import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.util.LinkedList;

/**
 * Created by vivek on 20/3/17.
 */
public class GraphTest {

    @Test
    public void addEdgeAndCheckNeighbours() {

        Graph graph = new WeightedDirectedGraph(5);
        // assert statements
        graph.addEdge(1, 3, 4);
        LinkedList<Integer> neighbours = new LinkedList();
         for( Edge edge: graph.getNeighbors(1)) {
             neighbours.add(edge.getNode());
         }
        assertThat(neighbours,  CoreMatchers.hasItem(3));
    }
}
