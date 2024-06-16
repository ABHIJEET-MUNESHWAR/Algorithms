package com.algorithm.graph;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    16/06/24,
 * Time:    10:14 am
 */
public class FloydWarshall {
  public void floydWarshall(int[][] graph) {
    int n = graph.length;
    for (int via = 0; via < n; via++) {
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          graph[i][j] = Math.min(graph[i][j], graph[i][via] + graph[via][j]);
        }
      }
    }
  }
}