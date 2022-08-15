package com.learn.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**This class will create a graph using Adjacency List
 * following the graph
 *
 *       3----4--------5
 *       |    |        |
 *       1----2        6
 *       \   /
 *         0
 * **/

public class GraphUsingAdjacencyList {
    private int numberOfNodes;

    public HashMap<Integer, List<Integer>> getAdjacentList() {
        return adjacentList;
    }

    private final HashMap<Integer, List<Integer>> adjacentList;

    public GraphUsingAdjacencyList(){
        numberOfNodes = 0;
        this.adjacentList = new HashMap<>();
    }

    public void addVertex(Integer node){
        // there can be only unique nodes
        adjacentList.putIfAbsent(node, new ArrayList<>());
    }

    public void addEdge(Integer node1, Integer node2){
        // undirected graph edges
        if(adjacentList.containsKey(node1) && adjacentList.containsKey(node2)){
            List<Integer> node1List = adjacentList.get(node1);
            List<Integer> node2List = adjacentList.get(node2);
            if(node1List.contains(node2)){
                return;
            } else{
                node1List.add(node2);
            }
            if(node2List.contains(node1)){
                return;
            } else{
                node2List.add(node1);
            }
        } else{
            System.out.println(node1 + "or " + node2 + " --> does not exist");
        }
    }

    public static void main(String[] args) {
        GraphUsingAdjacencyList myGraph = new GraphUsingAdjacencyList();
        myGraph.addVertex(0);
        myGraph.addVertex(1);
        myGraph.addVertex(2);
        myGraph.addVertex(3);
        myGraph.addVertex(4);
        myGraph.addVertex(5);
        myGraph.addVertex(6);

        myGraph.addEdge(1,0);
        myGraph.addEdge(1,2);
        myGraph.addEdge(1,3);
        myGraph.addEdge(2,0);
        myGraph.addEdge(2,4);
        myGraph.addEdge(4,3);
        myGraph.addEdge(4,5);
        myGraph.addEdge(5,6);

        myGraph.getAdjacentList().forEach((k,v) -> System.out.println(k + ": " + v));
    }
}
