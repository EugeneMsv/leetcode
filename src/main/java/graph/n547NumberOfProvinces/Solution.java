package graph.n547NumberOfProvinces;

public class Solution {

  public int findCircleNum(int[][] connections) {
    boolean[] visitedCities = new boolean[connections.length];
    int clusters = 0;
    for (int city = 0; city < connections.length; city++) {
      if (!visitedCities[city]) {
        visitCity(connections, visitedCities, city);
        clusters++;
      }
    }
    return clusters;
  }

  void visitCity(int[][] connections, boolean[] visitedCities, int city) {
    // dfs
    if (visitedCities[city]) {
      return;
    }

    visitedCities[city] = true;
    for (int newCity = 0; newCity < connections[city].length; newCity++) {
      if (connections[city][newCity] == 1) {
        visitCity(connections, visitedCities, newCity);
      }
    }
  }
}