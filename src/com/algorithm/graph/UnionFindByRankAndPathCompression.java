package com.algorithm.graph;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    06/06/24,
 * Time:    11:31 pm
 */
public class UnionFindByRankAndPathCompression {

  public int findByPathCompression(int i, int[] parent) {
    if (parent[i] == i) {
      return i;
    }
    return parent[i] = findByPathCompression(parent[i], parent);
  }

  public void unionByRank(int i, int j, int[] parent, int[] rank) {
    int parentOfI = findByPathCompression(i, parent);
    int parentOfJ = findByPathCompression(j, parent);
    if (parentOfI == parentOfJ) {
      return;
    }
    if (rank[parentOfI] > rank[parentOfJ]) {
      parent[parentOfJ] = parentOfI;
    } else if (rank[parentOfI] < rank[parentOfJ]) {
      parent[parentOfI] = parentOfJ;
    } else {
      parent[parentOfI] = parentOfI;
      rank[parentOfI]++;
    }
  }
}