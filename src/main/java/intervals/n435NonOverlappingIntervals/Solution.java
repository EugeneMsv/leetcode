package intervals.n435NonOverlappingIntervals;

public class Solution {

  public int eraseOverlapIntervals(int[][] intervals) {
    quickSortByStart(intervals, 0, intervals.length - 1);
    int lastIdx = 0;
    int removals = 0;
    for (int idx = 1; idx < intervals.length; idx++) {
      int[] lastInterval = intervals[lastIdx];
      int[] interval = intervals[idx];
      if (lastInterval[1] > interval[0]) {
        removals++;
        if (interval[1] < lastInterval[1]) {
          lastIdx = idx;
        }
      } else {
        lastIdx = idx;
      }
    }

    return removals;
  }

  private void quickSortByStart(int[][] intervals, int begin, int end) {
    if (begin >= end) {
      return;

    }
    if (end - begin == 1) {
      if (intervals[end][0] < intervals[begin][0]) {
        int[] temp = intervals[end];
        intervals[end] = intervals[begin];
        intervals[begin] = temp;
      }
      return;
    }
    int pivot = end;
    int pivotValue = intervals[pivot][0];

    int left = begin;
    int right = end - 1;
    while (left <= right) {
      if (intervals[left][0] <= pivotValue) {
        left++;
      } else {
        int[] temp = intervals[right];
        intervals[right] = intervals[left];
        intervals[left] = temp;
        right--;
      }
    }
    int[] temp = intervals[pivot];
    intervals[pivot] = intervals[left];
    intervals[left] = temp;

    quickSortByStart(intervals, begin, left - 1);
    quickSortByStart(intervals, left, end);
  }
}