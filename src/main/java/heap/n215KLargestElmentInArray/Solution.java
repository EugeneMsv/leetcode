package heap.n215KLargestElmentInArray;

public class Solution {

  public int findKthLargest(int[] nums, int k) {
    MaxHeap heap = new MaxHeap(nums.length);
    for (int num : nums) {
      heap.insert(num);
    }
    for (int i = 1; i < k; i++) {
      int max = heap.extractMax();
    }
    return heap.extractMax();
  }

  public static class MaxHeap {

    private final int[] heap;
    private int size = 0;

    public MaxHeap(int capacity) {
      this.heap = new int[capacity + 1];
      this.heap[0] = Integer.MAX_VALUE;
    }

    private int parentPos(int childPos) {
      return childPos / 2;
    }

    private int leftChildPos(int parentPos) {
      return parentPos * 2;
    }

    private int rightChildPos(int parentPos) {
      return parentPos * 2 + 1;
    }

    private void swap(int fpos, int spos) {
      int tmp;
      tmp = heap[fpos];
      heap[fpos] = heap[spos];
      heap[spos] = tmp;
    }

    private void downHeapify(int pos) {
      int leftChildPos = leftChildPos(pos);
      int rightChildPos = rightChildPos(pos);

      //checking if a swap is needed
      if ((leftChildPos <= size && heap[pos] < heap[leftChildPos])
          || (rightChildPos <= size && heap[pos] < heap[rightChildPos])) {

        //replacing parent with maximum of left and right child
        if (heap[leftChildPos] > heap[rightChildPos]) {
          swap(pos, leftChildPos);
          downHeapify(leftChildPos);
        } else {
          swap(pos, rightChildPos);
          downHeapify(rightChildPos);
        }
      }
    }

    public void insert(int element) {
      size++;
      heap[size] = element;
      heapifyUp(size);
    }

    private void heapifyUp(int pos) {
      int temp = heap[pos];
      while (pos > 0 && temp > heap[parentPos(pos)]) {
        swap(pos, parentPos(pos));
        pos = parentPos(pos);
      }
      heap[pos] = temp;
    }

    public int extractMax() {
      int max = heap[1];
      heap[1] = heap[size];
      size--;
      downHeapify(1);
      return max;
    }

    public void print(String prefix) {
      System.out.println(prefix);
      for (int i = 1; i <= size; i++) {
        System.out.print(heap[i]);
        if (leftChildPos(i) <= size) {
          System.out.print(": L- " + heap[leftChildPos(i)]);
        }

        if (rightChildPos(i) <= size) {
          System.out.print(": R- " + heap[rightChildPos(i)]);
        }
        System.out.println();
      }

    }
  }
}
