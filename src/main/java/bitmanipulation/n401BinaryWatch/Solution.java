package bitmanipulation.n401BinaryWatch;

import java.util.LinkedList;
import java.util.List;

public class Solution {

  public List<String> readBinaryWatch(int turnedOn) {
    List<String> result = new LinkedList<>();

    backtrack(result, 0, 0, 0, turnedOn);
    return result;
  }

  private int getBit(int value, int position) {
    return (value >> position) & 1;
  }

  private int setBitToOne(int value, int position) {
    return (1 << position) | value;
  }

  private int setBitToZero(int value, int position) {
    return ~(1 << position) & value;
  }

  private void backtrack(List<String> result, int hours, int minutes, int start, int turnedOn) {
    if (turnedOn == 0) {
      if (hours > 11 || minutes > 59) {
        return;
      }
      result.add(hours + ":" + ((minutes < 10) ? "0" + minutes : minutes));
      return;
    }

    if (start < 4) {
      //Hours
      for (int position = start; position < 4; position++) {
        int newHours = setBitToOne(hours, position);
        backtrack(result, newHours, minutes, position + 1, turnedOn - 1);
      }
      // Minutes
      for (int position = 0; position < 6; position++) {
        int newMinutes = setBitToOne(minutes, position);
        backtrack(result, hours, newMinutes, 4 + position + 1, turnedOn - 1);
      }
    } else {
      for (int position = start - 4; position < 6; position++) {
        int newMinutes = setBitToOne(minutes, position);
        backtrack(result, hours, newMinutes, 4 + position + 1, turnedOn - 1);
      }
    }

  }
}
