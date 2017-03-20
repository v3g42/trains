# TRAINS

## Description

At a very high this a Java project solving following three graph problems
- Distance between two nodes along a certain route.
- Number of routes between two nodes.
- Shortest route between two nodes.

Detailed description is [here][0].

### Implementation

This solution implements [WeightedDirectedGraph][2] using *Adjacency List*. (Other popular way is to use Adjacency Matrix) 

- *Graph*  Defiines the interface of an abstract Graph data structure.
- *WeightedDirectedGraph*  Weighted Directed Graph implementation of Graph interface
- *Traversals*  Class implementing following methods solving the traversals defined in the problem statement
    - *routeDistance* distance between any two nodes in the graph
    - *paths* all the possible paths between two nodes either based on max hop count or max distance
    - *shortestDistance*  shortest distance based on dijkstra algorithm
    
[Input File][1] is available in the resources folder.

[Further documentation can be generated using Maven][#generate-java-doc].

## Dependencies
Java 8
Maven

## Running Locally
```
mvn clean
mvn package
mvn exec:java

```

### Testing
```
mvn test
```

### Generate Java Doc
```
mvn javadoc:javadoc
```

#### Export git
```
git archive master | gzip > ~/Desktop/trains-thoughtworks.tgz
```




[0]: ./problem.md
[1]: ./src/main/java/com/vivekaditya/trains/GraphRepresentation.java
[2]: ./src/main/java/com/vivekaditya/trains/WeightedDirectedGraph.java

