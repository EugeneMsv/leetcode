package heap.n973KClosestPointsToOrigin;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

  public int[][] kClosest(int[][] points, int k) {
    PriorityQueue<Point> heap = new PriorityQueue<>(k, Comparator.comparing(Point::getDistance));
    for (int group = 0; group < points.length; group++) {
      heap.offer(new Point(points[group][0], points[group][1]));
    }
    int[][] result = new int[k][2];
    for (int i = 0; i < k; i++) {
      Point top = heap.poll();
      result[i][0] = top.x;
      result[i][1] = top.y;
    }
    return result;
  }

  private static class Point {

    final int x;
    final int y;
    private final double distance;

    Point(int x, int y) {
      this.x = x;
      this.y = y;
      this.distance = calcDistance(x, y);
    }

    private double calcDistance(int x, int y) {
      return Math.sqrt(x * x + y * y);
    }

    double getDistance() {
      return this.distance;
    }
  }

}
