package hashing.n49GroupAnagrams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {

  public List<List<String>> groupAnagrams(String[] strs) {
    Map<Map<Character, Integer>, List<String>> grouped = new HashMap<>();

    for (int i = 0; i < strs.length; i++) {
      String str = strs[i];
      Map<Character, Integer> key = buildKey(str);
      List<String> group = grouped.get(key);
      if (group == null) {
        group = new LinkedList<>();
        grouped.put(key, group);
      }
      group.add(str);
    }
    if (grouped.isEmpty()) {
      return Collections.emptyList();
    }

    List<List<String>> result = new ArrayList<>(grouped.size());
    for (List<String> group : grouped.values()) {
      result.add(group);
    }
    return result;
  }

  private Map<Character, Integer> buildKey(String str) {
    char[] chars = str.toCharArray();
    Map<Character, Integer> key = new HashMap<>();
    for (int j = 0; j < chars.length; j++) {
      Integer count = key.get(chars[j]);
      key.put(chars[j], count == null ? 1 : count + 1);
    }
    return key;
  }
}