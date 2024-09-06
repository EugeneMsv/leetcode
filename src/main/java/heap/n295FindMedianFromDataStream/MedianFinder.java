package heap.n295FindMedianFromDataStream;

import java.util.PriorityQueue;

class MedianFinder {

  PriorityQueue<Integer> left;
  PriorityQueue<Integer> right;

  public MedianFinder() {
    left = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
    right = new PriorityQueue<>((a, b) -> Integer.compare(a, b));
  }

  public void addNum(int num) {

    if (left.isEmpty() || left.peek() >= num) {
      left.offer(num);
    } else {
      right.offer(num);
    }

    while (!right.isEmpty() && left.size() < right.size() + 1) {
      left.offer(right.poll());
    }

    while (!left.isEmpty() && right.size() + 1 < left.size()) {
      right.offer(left.poll());
    }
  }

  public double findMedian() {
    int size = left.size() + right.size();
    // System.out.println("size =%s, left=%s, right=%s".formatted(size, pqToString(left), pqToString(right)));

    if (size % 2 == 1) {
      return (double) left.peek();
    } else {
      return (double) (left.peek() + right.peek()) / 2;
    }
  }

  private String pqToString(PriorityQueue<Integer> pq) {
    PriorityQueue<Integer> pq1 = new PriorityQueue<>(pq);
    StringBuilder sb = new StringBuilder();
    while (!pq1.isEmpty()) {
      sb.append(pq1.poll()).append(",");
    }
    return sb.toString();
  }

  // if(size %2 ==0){
  //         median = (double)(l.get(0)+ l.get(1))/2;

  //     }else{
  //         if(size >=3 && !q.isEmpty()){
  //             q.poll();
  //         }
  //         median = (double) q.peek();
  //     }
}

/**
 * Your MedianFinder object will be instantiated and called as such: MedianFinder obj = new
 * MedianFinder(); obj.addNum(num); double param_2 = obj.findMedian();
 */
