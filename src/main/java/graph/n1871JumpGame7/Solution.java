package graph.n1871JumpGame7;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeSet;

class Solution {

  public boolean canReach(String s, int minJump, int maxJump) {
    int n = s.length();

    // Early exit if the last character is not '0'
    if (s.charAt(n - 1) != '0') {
      return false;
    }

    TreeSet<Integer> zeros = new TreeSet<>();

    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '0') {
        zeros.add(i);
      }
    }

    // Use a queue for BFS and a visited array to keep track of visited indices
    Queue<Integer> queue = new LinkedList<>();

    // Start from index 0
    queue.offer(0);

    while (!queue.isEmpty()) {
      int current = queue.poll();

      // Explore all possible jumps from the current index
      Iterator<Integer> it = zeros.subSet(current + minJump, true, current + maxJump, true)
          .iterator();
      while (it.hasNext()) {
        Integer next = it.next();
        if (next == n - 1) {
          return true; // Reached the last index
        }
        queue.offer(next);
        it.remove();
      }

    }

    // If we exhaust the queue without reaching the last index, return false
    return false;
  }
}