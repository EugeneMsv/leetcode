package graph.n210CourseSchedul2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution {

  public int[] findOrder(int numCourses, int[][] prereq) {

    Map<Integer, Set<Integer>> courses = new HashMap<>(numCourses, 1.1F);
    Map<Integer, Set<Integer>> dependentCourses = new HashMap<>(numCourses, 1.1F);

    for (int i = 0; i < numCourses; i++) {
      courses.put(i, new HashSet<>());
      dependentCourses.put(i, new HashSet<>());
    }

    for (int i = 0; i < prereq.length; i++) {
      courses.get(prereq[i][0]).add(prereq[i][1]);
      dependentCourses.get(prereq[i][1]).add(prereq[i][0]);
    }

    Queue<Integer> nextCourses = new LinkedList<>();

    for (Map.Entry<Integer, Set<Integer>> entry : courses.entrySet()) {
      if (entry.getValue().isEmpty()) {
        nextCourses.offer(entry.getKey());
      }
    }
    List<Integer> orderedCourses = new LinkedList<>();

    while (!nextCourses.isEmpty()) {

      Integer course = nextCourses.poll();
      orderedCourses.add(course);
      courses.remove(course);
      Set<Integer> dependents = dependentCourses.get(course);

      for (Integer dependent : dependents) {
        Set<Integer> neighbours = courses.get(dependent);
        neighbours.remove(course);
        if (neighbours.isEmpty()) {
          nextCourses.offer(dependent);
        }
      }
      dependentCourses.remove(course);

    }
    if (!courses.isEmpty()) {
      return new int[]{};
    }

    return orderedCourses.stream().mapToInt(i -> i).toArray();

  }
}