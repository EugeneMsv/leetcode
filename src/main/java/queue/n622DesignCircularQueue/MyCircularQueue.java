package queue.n622DesignCircularQueue;

class MyCircularQueue {

  private Node head;
  private Node tail;
  int size = 0;
  int capacity = 0;

  public MyCircularQueue(int k) {
    capacity = k;
  }

  public boolean enQueue(int value) {
    if (isFull()) {
      return false;
    }

    Node newNode = new Node(value);
    if (!isEmpty()) {
      tail.prev = newNode;
      newNode.next = tail;
      tail = newNode;
    } else {
      head = newNode;
      tail = newNode;
    }
    size++;
    return true;
  }

  public boolean deQueue() {
    if (isEmpty()) {
      return false;
    }

    Node result = head;
    head = result.prev;
    if (head != null) {
      head.next = null;
    } else {
      tail = null;
    }
    size--;
    return true;
  }

  public int Front() {
    return head == null ? -1 : head.value;
  }

  public int Rear() {
    return tail == null ? -1 : tail.value;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public boolean isFull() {
    return size == capacity;
  }
}

class Node {

  int value;
  Node prev;
  Node next;

  Node(int value) {
    this.value = value;
  }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such: MyCircularQueue obj = new
 * MyCircularQueue(k); boolean param_1 = obj.enQueue(value); boolean param_2 = obj.deQueue(); int
 * param_3 = obj.Front(); int param_4 = obj.Rear(); boolean param_5 = obj.isEmpty(); boolean param_6
 * = obj.isFull();
 */