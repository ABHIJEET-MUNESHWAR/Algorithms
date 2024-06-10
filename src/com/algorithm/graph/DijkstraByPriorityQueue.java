package com.algorithm.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    10/06/24,
 * Time:    9:03 am
 */
public class DijkstraByPriorityQueue {
  public static void main(String[] args) {
    DijkstraByPriorityQueue d = new DijkstraByPriorityQueue();
  }

  class Pair {
    int distance;
    int node;

    public Pair(int distance, int node) {
      this.distance = distance;
      this.node = node;
    }
  }

  public int[] dijkstra(int v, ArrayList<ArrayList<ArrayList<Integer>>> adj, int source) {
    PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);
    int[] result = new int[v];
    Arrays.fill(result, Integer.MAX_VALUE);
    result[source] = 0;
    pq.add(new Pair(0, source));
    while (!pq.isEmpty()) {
      Pair pair = pq.poll();
      int distance = pair.distance;
      int node = pair.node;
      for (ArrayList<Integer> edge : adj.get(pair.node)) {
        int edgeWeight = edge.get(0);
        int adjacentNode = edge.get(1);
        if (result[adjacentNode] > distance + edgeWeight) {
          result[adjacentNode] = distance + edgeWeight;
          pq.add(new Pair(distance + edgeWeight, adjacentNode));
        }
      }
    }
    return result;
  }
}