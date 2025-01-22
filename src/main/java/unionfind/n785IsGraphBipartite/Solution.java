package unionfind.n785IsGraphBipartite;

class Solution {

  public boolean isBipartite(int[][] graph) {
    int n = graph.length;
    UnionFind uf = new UnionFind(n);

    for (int node = 0; node < n; node++) {
      int nodeParent = uf.find(node);
      for (int i = 0; i < graph[node].length; i++) {
        int neighbour = graph[node][i];
        int neighbourParent = uf.find(neighbour);
        if (nodeParent == neighbourParent) {
          return false;
        }
        if (i > 0) {
          uf.union(graph[node][i - 1], neighbour);
        }

      }
    }

    return true;

  }

  static class UnionFind {

    int[] parent;

    UnionFind(int n) {
      parent = new int[n];
      for (int i = 0; i < n; i++) {
        parent[i] = i;
      }
    }

    int find(int node) {

      if (node != parent[node]) {
        return find(parent[node]);
      }
      return node;
    }

    void union(int left, int right) {
      int lParent = find(left);
      int rParent = find(right);

      if (lParent != rParent) {
        parent[rParent] = lParent;
      }
    }
  }

}