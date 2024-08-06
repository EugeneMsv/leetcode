package array.n1041RobotBoundedInCircle;

class Solution {

  public boolean isRobotBounded(String in) {
    String s = in + in;
    s += s;

    int direction = 0; // 0 = N, 1 = W, 2 = S,  3 = E

    int x = 0;
    int y = 0;

    for (char c : s.toCharArray()) {
      if (c == 'G') {
        if (direction == 0) {
          y++;
        } else if (direction == 1) {
          x--;
        } else if (direction == 2) {
          y--;
        } else {
          x++;
        }
      } else if (c == 'L') {
        direction = (direction + 1) % 4;
      } else {
        direction = (direction - 1) % 4;
        direction += direction < 0 ? 4 : 0;
      }

    }
    return x == 0 && y == 0;

  }
}
