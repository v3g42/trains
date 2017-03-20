package com.vivekaditya.trains;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

public class Trains {
    private WeightedDirectedGraph g;

    public Traversals getT() {
        return t;
    }
    private Traversals t;

    public Trains() {
        this.g = createDirectedGraph();
        this.t = new Traversals(g);
    }

    public static void main(String[] args) {
        Trains trains = new Trains();

        // Printing all test cases

        // distance between two nodes (1-5)
        List<String> list = Arrays.asList("ABC", "AD", "ADC", "AEBCD", "AED");
        ListIterator iter = list.listIterator();

        while (iter.hasNext()) {
            String val = trains.getT().routeDistance(TrainUtil.mapString((String)iter.next()));
            System.out.println(String.format("Output #%d: %s", iter.previousIndex()+1, val));
        }

        // 6) no of paths with hops
        System.out.println("Output #6: " +
                trains.getT().paths(TrainUtil.mapCharacter('C'), TrainUtil.mapCharacter('C'), true, 3).size());

        // 7) no of paths with extract hops
        int exactDistance = 4;
        System.out.println("Output #7: " +
                        trains.getT().paths(TrainUtil.mapCharacter('A'), TrainUtil.mapCharacter('C'), true, exactDistance)
                                .stream()
                                .filter(d -> d == exactDistance)
                                .collect(Collectors.toList())
                                .size()
        );

        // 8

        System.out.println("Output #8: " + trains.getT().shortestDistance(TrainUtil.mapCharacter('A'), TrainUtil.mapCharacter('C')));

        System.out.println("Output #9: " + trains.getT().shortestDistance(TrainUtil.mapCharacter('B'), TrainUtil.mapCharacter('B')));

        // no of paths with distance
        System.out.println("Output #10: " +
                trains.getT().paths(TrainUtil.mapCharacter('C'), TrainUtil.mapCharacter('C'), false, 29).size());
    }

    /**
     * Creates a WeightedDirectedGraph based on input file input.txt from resources
     * @return WeightedDirectedGraph
     */
    private WeightedDirectedGraph createDirectedGraph() {
        // Initialising with length of alphabets in this case
        WeightedDirectedGraph g = new WeightedDirectedGraph(27);

        InputStream is = getClass().getResourceAsStream("/input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        br.lines().map(l -> l.split(","))
                .flatMap(Arrays::stream)
                .map(r -> {
                    r = r.trim();
                    int s = TrainUtil.mapCharacter(r.charAt(0)); // First node
                    int v = TrainUtil.mapCharacter(r.charAt(1)); // Second node
                    int d = Integer.valueOf(r.substring(2, r.length())); // Weight
                    g.addEdge(s, v, d);
                    return r;
                })
                .collect(Collectors.toList());
        return g;
    }
}
