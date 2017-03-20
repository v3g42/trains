package com.vivekaditya.trains;

import java.util.*;

/**
 * Class exposing functions to calculate routeDistance, shortestPath, all paths possible on a given Graph
 */
public class Traversals {
    Graph g;

    /**
     * @param g Graph on which traversal functions can be called
     */
    public Traversals(Graph g) {
        this.g = g;
    }

    /**
     *
     * @param distances
     * @param visited
     * @return int closest node
     */
    private int getClosest (int [] distances, boolean [] visited) {
        int x = Integer.MAX_VALUE;
        int y = -1;   // graph not connected, or no unvisited vertices
        for (int i=0; i < distances.length; i++) {
            if (!visited[i] && (distances[i]<x)) {
                y=i;
                x=distances[i];
            }
        }
        return y;
    }

    /**
     * Implementation of dijkstra (https://en.wikipedia.org/wiki/Dijkstra's_algorithm)
     * @param s
     * @return int[] distances to all nodes from a given node s
     */
    private int [] dijkstra (int s) {
        final int [] dist = new int [g.getSize()];  // shortest known distance from "s"
        final int [] prev = new int [g.getSize()];  // previous node in path
        final boolean [] visited = new boolean [g.getSize()]; // all false initially

        // Initialising with infinity, in this case MAX INT VALUE
        for (int i=0; i<dist.length; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[s] = 0;
        int next = s;
        for (int i=0; i<dist.length; i++) {
            // The shortest path to next is dist[next] and via pred[next].
            final ListIterator<Edge> itr = g.getNeighbors(next).listIterator(0);

            while (itr.hasNext()) {
                Edge n = itr.next();
                final int v = n.getNode();
                final int d = dist[next] + g.distance(next,v);
                // Minor modification to dijkstra to find route other than 0
                if(dist[v] > d || dist[v] ==0) {
                    dist[v] = d;
                    prev[v] = next;
                }

            }
            next = getClosest(dist, visited);
            if(next ==-1) {
                break;
            }
            visited[next] = true;
        }
        return dist;  // (ignore prev[s]==0!)
    }

    /**
     *
     * @param arr array of nodes defining a path
     * @return distance cast as String or "NO SUCH ROUTE" if no route possible.
     */
    public String routeDistance(int[] arr) {
        try {
            int d = 0;
            for(int i=0;i < arr.length-1; i++) {
                d = d + g.distance(arr[i], arr[i+1]);
            }
            return String.valueOf(d);
        } catch (IllegalArgumentException e) {
            return "NO SUCH ROUTE";
        }
    }

    /**
     *
     * @param s initital node
     * @param f final node
     * @param hops if no of hops is to be counted
     * @param maxDistance maximum distance to traverse(either by weight or by hops)
     * @return Returns distances of all possible paths
     */
    public List<Integer> paths(int s, int f, boolean hops, int maxDistance) {
        LinkedList<Integer> distances = new LinkedList();
        // queue for BFS
        LinkedList<Map.Entry<Integer,Integer>> queue = new java.util.LinkedList<>();

        Map.Entry<Integer,Integer> current = new AbstractMap.SimpleEntry<>(s,0);
        queue.add(current);

        while (queue.size() != 0) {
            current = queue.poll();
            if(current.getKey()==f && current.getValue() > 0) {
                distances.push(current.getValue());
            }

            // Get all adjacent vertices of the dequeued vertex s
            // calculate distance based on no of hops or edge distance
            ListIterator<Edge> i = g.getNeighbors(current.getKey()).listIterator(0);
            while (i.hasNext()) {
                Edge n = i.next();

                int distance = current.getValue();
                if(hops) {
                    distance++;
                } else {
                    distance = distance + n.getDistance();
                }
                if(distance <= maxDistance) {
                    Map.Entry<Integer, Integer> neighbour = new AbstractMap.SimpleEntry<>(n.getNode(),distance);
                    queue.add(neighbour);
                }
            }
        }
        return distances;
    }

    /**
     *
     * @param s source
     * @param f destination
     * @return minimum distance between s and f (returns Integer.MAX_VALUE if no path found)
     */
    public String shortestDistance(int s, int f) {
        int [] dist = dijkstra(s);
        return dist[f] < Integer.MAX_VALUE ? String.valueOf(dist[f]) :  "NO SUCH ROUTE";
    }
}
