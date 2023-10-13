package array.n659EncodeDecodeStrings;

import java.util.LinkedList;
import java.util.List;

public class Solution {

  /*
   * @param strs: a list of strings
   * @return: encodes a list of strings to a single string.
   */
  public String encode(List<String> strs) {

    StringBuilder sb = new StringBuilder();
    for (String str : strs) {
      sb.append(str.length())
          .append("$")
          .append(str);
    }
    // System.out.println(sb);
    return sb.toString();
  }

  /*
   * @param str: A string
   * @return: decodes a single string to a list of strings
   */
  public List<String> decode(String str) {

    List<String> strs = new LinkedList<>();
    boolean lengthMode = true;
    boolean stringMode = false;
    StringBuilder stringBuilder = null;
    StringBuilder lengthBuilder = null;
    int strLength = -1;
    for (char c : str.toCharArray()) {
      if (lengthMode) {
        if (c == '$') {
          strLength = Integer.parseInt(lengthBuilder.toString());
          lengthMode = false;
          stringMode = true;
          lengthBuilder = null;
          stringBuilder = null;
          continue;
        } else {
          if (lengthBuilder == null) {
            lengthBuilder = new StringBuilder();
          }
          lengthBuilder.append(c);
          continue;
        }
      }
      if (stringMode) {
        if (strLength > 0) {
          if (stringBuilder == null) {
            stringBuilder = new StringBuilder();
          }
          stringBuilder.append(c);
        }
        if (strLength == 1) {
          if (stringBuilder != null) {
            strs.add(stringBuilder.toString());
            stringBuilder = null;
          }
          lengthMode = true;
          stringMode = false;
        }

        strLength--;
        continue;
      }
    }

    return strs;

  }
}
