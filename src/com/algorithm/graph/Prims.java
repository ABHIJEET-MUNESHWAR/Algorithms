package com.algorithm.graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    16/06/24,
 * Time:    3:43 pm
 */
public class Prims {
  class Edge {
    int v;
    int weight;

    public Edge(int v, int weight) {
      this.v = v;
      this.weight = weight;
    }
  }

  public static void main(String[] args) {
    int graph[][] = new int[][] {{0, 1, 5},
        {1, 2, 3},
        {0, 2, 1}};

    // Function call
    Prims prims = new Prims();
    System.out.println(prims.spanningTree(3, 3, graph));
  }

  private int spanningTree(int totalVertices, int totalEdges, int[][] graph) {
    boolean[] visited = new boolean[totalVertices];
    PriorityQueue<Edge> pq = new PriorityQueue<>();
    ArrayList<ArrayList<Edge>> adjacencyList = new ArrayList<>();
    for (int i = 0; i < totalVertices; i++) {
      adjacencyList.add(new ArrayList<>());
    }
    for (int i = 0; i < totalEdges; i++) {
      int u = graph[i][0];
      int v = graph[i][1];
      int w = graph[i][2];
      adjacencyList.get(u).add(new Edge(v, w));
      adjacencyList.get(v).add(new Edge(u, w));
    }
    pq.add(new Edge(0, 0));
    int totalSum = 0;
    while (!pq.isEmpty()) {
      Edge edge = pq.poll();
      int v = edge.v;
      int w = edge.weight;
      if (visited[v]) {
        continue;
      }
      totalSum += w;
      for (Edge e : adjacencyList.get(v)) {
        if (!visited[e.v]) {
          pq.add(e);
        }
      }
    }
    return totalSum;
  }
}