package graph.n841KeysAndRooms;

import java.util.List;

public class Solution {

  public boolean canVisitAllRooms(List<List<Integer>> rooms) {
    int[] roomStatuses = new int[rooms.size()];
    dfs(rooms, 0, roomStatuses);
    for (int roomStatus : roomStatuses) {
      if (roomStatus != 2) {
        return false;
      }
    }
    return true;
  }

  void dfs(List<List<Integer>> graph, int currentNode, int[] nodeStatuses) {
    if (nodeStatuses[currentNode] > 0) {
      return;
    }
    nodeStatuses[currentNode] = 1;
    for (Integer linkedNode : graph.get(currentNode)) {
      dfs(graph, linkedNode, nodeStatuses);
    }
    nodeStatuses[currentNode] = 2;
  }
}
