package math.n12IntegerToRoman;

import java.util.LinkedHashMap;
import java.util.Map;

public class Solution {

  private static final Map<Integer, String> map = new LinkedHashMap<>(13, 1.1F);

  static {
    map.put(1000, "M");
    map.put(900, "CM");
    map.put(500, "D");
    map.put(400, "CD");
    map.put(100, "C");
    map.put(90, "XC");
    map.put(50, "L");
    map.put(40, "XL");
    map.put(10, "X");
    map.put(9, "IX");
    map.put(5, "V");
    map.put(4, "IV");
    map.put(1, "I");
  }

  public String intToRoman(int n) {

    StringBuilder s = new StringBuilder();
    for (Map.Entry<Integer, String> entry : map.entrySet()) {
      if (n == 0) {
        return s.toString();
      }
      for (int i = 0; i < n / entry.getKey(); i++) {
        s.append(entry.getValue());
      }
      n = n % entry.getKey();
    }

    return s.toString();
  }
}