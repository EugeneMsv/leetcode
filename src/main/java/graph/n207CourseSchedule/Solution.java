package graph.n207CourseSchedule;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {

  public boolean canFinish(int numCourses, int[][] prerequisites) {
    if (prerequisites.length == 0) {
      return true;
    }

    Map<Integer, List<Integer>> courses = new HashMap<>(numCourses, 1.1F);

    for (int i = 0; i < prerequisites.length; i++) {
      List<Integer> neighbours = courses.get(prerequisites[i][0]);
      if (neighbours == null) {
        neighbours = new LinkedList<>();
        courses.put(prerequisites[i][0], neighbours);
      }
      neighbours.add(prerequisites[i][1]);
    }

    for (Integer currentCourse : courses.keySet()) {
      System.out.print(currentCourse + "=" + courses.get(currentCourse) + " ");
    }
    System.out.println();

    Set<Integer> completed = new HashSet<>();
    Set<Integer> currentlyVisited = new HashSet<>();

    for (Integer currentCourse : courses.keySet()) {
      if (!dfs(courses, completed, currentlyVisited, currentCourse)) {

        return false;
      }
      currentlyVisited.clear();
    }

    return true;

  }

  private boolean dfs(
      Map<Integer, List<Integer>> courses,
      Set<Integer> completed,
      Set<Integer> currentlyVisited,
      int currentCourse) {
    if (completed.contains(currentCourse)) {
      return true;
    }

    if (currentlyVisited.contains(currentCourse)) {
      return false;
    }

    List<Integer> neighbours = courses.get(currentCourse);
    if (neighbours == null) {
      completed.add(currentCourse);
      return true;
    }

    currentlyVisited.add(currentCourse);
    for (Integer neighbour : neighbours) {
      boolean result = dfs(courses, completed, currentlyVisited, neighbour);
      if (!result) {
        return false;
      }
    }
    completed.add(currentCourse);
    return true;
  }

}
