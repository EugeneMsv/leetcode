package intervals.n1288RemoveCoveredIntervals;

public class Solution {

  public int removeCoveredIntervals(int[][] intervals) {
    quickSort(intervals, 0, intervals.length - 1);

    int lastIdx = 0;
    int coveredCount = 0;
    for (int idx = 1; idx < intervals.length; idx++) {
      int[] lastInterval = intervals[lastIdx];
      int[] interval = intervals[idx];
      if (isCovered(interval, lastInterval) || isCovered(lastInterval, interval)) {
        coveredCount++;
      }
      if (interval[1] > lastInterval[1]) {
        lastIdx = idx;
      }
    }
    return intervals.length - coveredCount;
  }

  private boolean isCovered(int[] target, int[] interval) {
    return target[0] >= interval[0]
        && target[1] <= interval[1];
  }

  private void quickSort(int[][] intervals, int begin, int end) {
    if (begin >= end) {
      return;
    }

    int pivotIdx = end;

    int left = begin;
    int right = end - 1;
    int pivot = intervals[pivotIdx][0];
    while (left <= right) {
      if (intervals[left][0] <= pivot) {
        left++;
      } else {
        int[] temp = intervals[right];
        intervals[right] = intervals[left];
        intervals[left] = temp;
        right--;
      }
    }

    int[] temp = intervals[left];
    intervals[left] = intervals[pivotIdx];
    intervals[pivotIdx] = temp;
    pivotIdx = left;

    quickSort(intervals, begin, pivotIdx - 1);
    quickSort(intervals, pivotIdx, end);
  }
}
