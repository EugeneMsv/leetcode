# [Checkout my leetcode profile](https://leetcode.com/EugeneMsv/)

### Collections to know
- Stack
  ```java 
    Stack<Integer> stack = new Stack<>();
    stack.push(num); // O(1) Pushes an item onto the top of this stack.
    stack.pop(num); // O(1) Removes the object at the top of this stack and returns that object as the value of this function.
    stack.peek(num); // O(1) Looks at the object at the top of this stack without removing it from the stack.
    stack.size(); // O(1) Returns size of the stack
    ```
  - PriorityQueue aka Heap
  ```java 
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(capacity, Collections.reverseOrder())
    heap.add(num); // O(log(n)) Inserts the specified element into this priority queue.
    heap.poll(num); // O(1) Retrieves and removes the head of this queue, or returns null if this queue is empty.
    heap.peek(num); // O(1) Returns: the head of this queue, or null if this queue is empty.
    heap.size(); // O(1) Returns size of the collection.
    ```
   - Queue 
  ```java 
    Queue<Integer> queue = new LinkedList<>();
    queue.add(num); // O(1) Inserts the specified element into this queue.
    queue.poll(num); // O(1) Retrieves and removes the head of this queue, or returns null if this queue is empty.
    queue.peek(num); // O(1) Returns: the head of this queue, or null if this queue is empty.
    queue.size(); // O(1) Returns size of the collection.
    ``` 
    - Map 
  ```java 
    Map<Integer,Integer> map = new HashMap<>();
    Map<Integer,Integer> map = new HashMap<>(capacity);
    map.put(k,v); // O(1) Associates the specified value with the specified key in this map
    map.get(k); // O(1) Returns the value to which the specified key is mapped, or null if this map contains no mapping for the key.
    map.containsKey(k); // O(1) Returns true if this map contains a mapping for the specified key
    map.size(); // O(1) Returns the number of key-value mappings in this map
    ```    
  - Set 
  ```java 
    Map<Integer> set = new HashSet<>();
    Map<Integer> set = new HashSet<>(capacity);
    set.add(k); // O(1) Adds the specified element to this set if it is not already present.  Returns true if this set did not already contain the specified element
    set.remove(k); // O(1) Removes the specified element from this set if it is present. 
    set.contains(k); // O(1) Returns true if this set contains the specified element.
    set.size(); // O(1) Returns the number of elements in this set 
    ```
  
### Other functions to know
- Max `Math.max(long a, long b) // Returns the greater of two values.`
- Min `Math.max(long a, long b) // Returns the smaller of two values.`
- String.toCharArray `char[] toCharArray() // Converts this string to a new character array.`
- Objects.hash `static int hash(Object... values) // Generates a hash code for a sequence of input values.`

### Common knowledge
- 26 letters in English alphabet