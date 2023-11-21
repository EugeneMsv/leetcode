package sorting.n75SortColors;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {

  public void sortColors(int[] nums) {
    quickSort(nums);

  }

  private void bubbleSort(int[] nums){

    for(int i = 0; i < nums.length; i++){
      for(int j = 0; j< nums.length -i-1; j++){
        if(nums[j] > nums[j+1]){
          int temp = nums[j+1];
          nums[j+1] = nums[j];
          nums[j] =  temp;
        }
      }
    }
  }

  private void mergeSort(int[] nums) {
    List<Integer> clone = Arrays.stream(nums).boxed().toList();

    List<Integer> sorted = subMergeSort(clone);

    for (int i = 0; i < sorted.size(); i++) {
      nums[i] = sorted.get(i);
    }
  }

  private List<Integer> subMergeSort(List<Integer> list) {
    if (list.size() == 1) {
      return list;
    }
    if (list.size() == 2) {
      return List.of(Math.min(list.get(0), list.get(1)), Math.max(list.get(0), list.get(1)));
    }

    int pivot = list.size() / 2;
    List<Integer> left = subMergeSort(list.subList(0, pivot));
    List<Integer> right = subMergeSort(list.subList(pivot, list.size()));

    List<Integer> merged = new LinkedList<>();
    int leftIdx = 0;
    int rightIdx = 0;

    while (leftIdx < left.size() && rightIdx < right.size()) {
      if (left.get(leftIdx) <= right.get(rightIdx)) {
        merged.add(left.get(leftIdx));
        leftIdx++;
      } else {
        merged.add(right.get(rightIdx));
        rightIdx++;
      }
    }
    if (leftIdx < left.size()) {
      merged.addAll(left.subList(leftIdx, left.size()));
    }
    if (rightIdx < right.size()) {
      merged.addAll(right.subList(rightIdx, right.size()));
    }
    return merged;
  }

  private void quickSort(int[] nums) {
    subQuickSort(nums, 0, nums.length - 1);
  }

  private void subQuickSort(int[] nums, int from, int to) {
    if (to == from) {
      return;
    }
    if (to - from == 1) {
      int temp = Math.min(nums[from], nums[to]);
      nums[to] = Math.max(nums[from], nums[to]);
      nums[from] = temp;

      return;
    }

    int pivotIdx = partition(nums, from, to);

    subQuickSort(nums, from, pivotIdx);
    subQuickSort(nums, pivotIdx + 1, to);
  }

  private int partition(int[] nums, int from, int to) {

    int pivot = nums[to];
    int firstHigh = from;
    int i = from;

    while (i < to) {
      if (nums[i] <= pivot) {
        int temp = nums[firstHigh];
        nums[firstHigh] = nums[i];
        nums[i] = temp;
        firstHigh++;
      }
      i++;
      System.out.println();

    }
    int temp = nums[firstHigh];
    nums[firstHigh] = pivot;
    nums[to] = temp;
    if (firstHigh == to) {
      return firstHigh - 1;
    }
    return firstHigh;
  }
}
