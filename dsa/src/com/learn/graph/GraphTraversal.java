package com.learn.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Graph {
    private int vertices;
    private Map<Integer, List<Integer>> adjacencyList;

    public Graph(int vertices) {
        this.vertices = vertices;
        this.adjacencyList = new HashMap<>();
        for (int i = 0; i < vertices; i++) {
            adjacencyList.put(i, new ArrayList<>());
        }
    }

    public void addEdge(int u, int v) {
        adjacencyList.get(u).add(v);
        adjacencyList.get(v).add(u);
    }
}

public class GraphTraversal {
    public static int bfs(Graph graph) {
        // Implement BFS traversal and return the number of connected components
        // Your code here
        return 0;  // Placeholder, replace with actual result
    }

    public static int dfs(Graph graph) {
        // Implement DFS traversal and return the number of connected components
        // Your code here
        return 0;  // Placeholder, replace with actual result
    }

    public static void main(String[] args) {
        Graph g = new Graph(7);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(4, 5);
        g.addEdge(6, 6);

        System.out.println("Number of connected components using BFS: " + bfs(g));
        System.out.println("Number of connected components using DFS: " + dfs(g));
    }


}
