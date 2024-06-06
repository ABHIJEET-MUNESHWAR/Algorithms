package com.algorithm.graph;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    06/06/24,
 * Time:    10:43 pm
 */
public class UnionFind {
  public int find(int i, int[] parent) {
    if (parent[i] == i) {
      return i;
    }
    return find(parent[i], parent);
  }

  public void union(int i, int j, int[] parent) {
    int parentOfI = find(i, parent);
    int parentOfJ = find(j, parent);
    if (parentOfI != parentOfJ) {
      parent[parentOfI] = parentOfJ;
    }
  }
}