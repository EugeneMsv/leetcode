package greedy.n763PartitionLabels;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {

  public List<Integer> partitionLabels(String s) {
    Map<Character, Integer> partitions = new HashMap<>();
    int currentPartition = 0;
    char[] letters = s.toCharArray();
    for (char letter : letters) {
      if (partitions.containsKey(letter)) {
        int fromPartition = partitions.get(letter);
        for (Character key : partitions.keySet()) {
          Integer keyPartition = partitions.get(key);
          if (fromPartition < keyPartition && keyPartition <= currentPartition) {
            partitions.put(key, fromPartition);
          }
        }
        currentPartition = fromPartition;
      } else {
        currentPartition++;
        partitions.put(letter, currentPartition);
      }
    }

    currentPartition = 1;
    int partitionSize = 0;
    List<Integer> partitionIdxs = new LinkedList<>();
    for (int i = 0; i < letters.length; i++) {
      int partition = partitions.get(letters[i]);
      if (currentPartition != partition) {
        partitionIdxs.add(partitionSize);
        currentPartition = partition;
        partitionSize = 0;
      }
      partitionSize++;
    }
    partitionIdxs.add(partitionSize);

    return partitionIdxs;
  }
}
