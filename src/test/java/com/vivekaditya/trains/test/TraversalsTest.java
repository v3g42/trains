package com.vivekaditya.trains.test;

import static org.junit.Assert.*;

import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.Before;

import java.util.List;

/**
 * Created by vivek on 20/3/17.
 */
public class TraversalsTest {
    Graph graph;
    Traversals t;
    @Before
    public void setUp() {
        // There are two paths possible 1->2->3->4 and 1-2->4
        graph = new WeightedDirectedGraph(5);
        graph.addEdge(1, 2, 2);
        graph.addEdge(2, 3, 2);
        graph.addEdge(2, 4, 2);
        graph.addEdge(3, 4, 2);
        t = new Traversals(graph);

    }
    @Test
    public void routeDistance() {
        assertEquals( t.routeDistance(new int[]{1, 2, 3}),  String.valueOf(4));
    }

    @Test
    public void countPathsWithMaxHops() {
        List paths = t.paths(1, 4, true, 2);
        assertEquals(paths.size(), 1);

        paths = t.paths(1, 4, true, 3);
        assertEquals(paths.size(), 2);
    }

    @Test
    public void countPathsWithMaxDistance() {
        List paths = t.paths(1, 4, false, 4);
        assertEquals(paths.size(), 1);

        paths = t.paths(1, 4, false, 6);
        assertEquals(paths.size(), 2);
    }

    @Test
    public void shortestDistance() {
        assertEquals(t.shortestDistance(1, 4), String.valueOf("4"));
    }
}
