package graph.n399EvaluateDivision;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {

  public double[] calcEquation(List<List<String>> equations, double[] values,
      List<List<String>> queries) {
    Map<String, List<Parameter>> graph = new HashMap<>();

    for (int i = 0; i < equations.size(); i++) {
      List<String> equation = equations.get(i);
      double k = values[i];
      String topVar = equation.get(0);
      String downVar = equation.get(1);

      graph.computeIfAbsent(topVar, key -> new LinkedList<>())
          .add(new Parameter(downVar, k));

      graph.computeIfAbsent(downVar, key -> new LinkedList<>())
          .add(new Parameter(topVar, 1 / k));
    }

    Set<String> visited = new HashSet<>();
    double[] result = new double[queries.size()];
    for (int i = 0; i < queries.size(); i++) {
      List<String> query = queries.get(i);
      result[i] = dfsQuery(graph, query.get(0), 1.0, query.get(1), visited);
      visited.clear();
    }

    return result;
  }

  private double dfsQuery(Map<String, List<Parameter>> graph, String curVar, double k,
      String targetVar, Set<String> visitedVars) {
    if (curVar.equals(targetVar) && graph.containsKey(targetVar)) {
      return k;
    }

    if (visitedVars.contains(curVar)) {
      return -1.0;
    }

    visitedVars.add(curVar);

    for (Parameter param : graph.getOrDefault(curVar, List.of())) {

      double result = dfsQuery(graph, param.variable, k * param.k, targetVar, visitedVars);
      if (result > 0) {
        return result;
      }
    }
    return -1.0;
  }

  class Parameter {

    String variable;
    double k;

    Parameter(String variable, double k) {
      this.variable = variable;
      this.k = k;
    }
  }
}
