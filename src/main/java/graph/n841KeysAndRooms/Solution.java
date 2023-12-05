package graph.n841KeysAndRooms;

import java.util.List;
import java.util.Stack;

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

  public boolean canVisitAllRoomsIterative(List<List<Integer>> rooms) {
    boolean[] seen = new boolean[rooms.size()];
    seen[0] = true;
    Stack<Integer> stack = new Stack();
    stack.push(0);

    //At the beginning, we have a todo list "stack" of keys to use.
    //'seen' represents at some point we have entered this room.
    while (!stack.isEmpty()) { // While we have keys...
      int node = stack.pop(); // Get the next key 'node'
      for (int nei : rooms.get(node)) // For every key in room # 'node'...
      {
        if (!seen[nei]) { // ...that hasn't been used yet
          seen[nei] = true; // mark that we've entered the room
          stack.push(nei); // add the key to the todo list
        }
      }
    }

    for (boolean v : seen)  // if any room hasn't been visited, return false
    {
      if (!v) {
        return false;
      }
    }
    return true;
  }
}
