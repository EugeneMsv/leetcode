# [Checkout my leetcode profile](https://leetcode.com/EugeneMsv/)

### Collections to know

- Stack
  ```java 
    Stack<Integer> stack = new Stack<>();
    stack.push(num); // O(1) Pushes an item onto the top of this stack.
    stack.pop(num); // O(1) Removes the object at the top of this stack and returns that object as the value of this function. Exception if empty
    stack.peek(num); // O(1) Looks at the object at the top of this stack without removing it from the stack. Exception if empty.
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
  map.remove(k); // O(1) If this map contains a mapping from key k to value v such that Objects.equals(key, k), that mapping is removed. 
  ```
- NavigableMap
  ```java
  NavigableMap<Integer,Integer> map = new TreeMap<>();
  Map.Entry<K,V> ceilingEntry(K key); // Returns a key-value mapping associated with the least key greater than or equal to the given key, or null if there is no such key.
  Map.Entry<K,V> floorEntry(K key); // Returns a key-value mapping associated with the greatest key less than or equal to the given key, or null if there is no such key.
  NavigableMap<K,V> headMap(K toKey, boolean inclusive); // Returns a view of the portion of this map whose keys are less than (or equal to, if inclusive is true) toKey. The returned map is backed by this map, so changes in the returned map are reflected in this map, and vice-versa.
  NavigableMap<K,V> tailMap(K fromKey, boolean inclusive); // Returns a view of the portion of this map whose keys are greater than (or equal to, if inclusive is true) fromKey. The returned map is backed by this map, so changes in the returned map are reflected in this map, and vice-versa
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
- List
  ```java 
  int[] nums = list.toArray(int[]::new); // Converts list to array
  list.set(idx, newValue); Replaces the element at the specified position in this list with the specified elemen
  ```

### Other functions to know

#### Numbers
- Max `Math.max(long a, long b) // Returns the greater of two values.`
- Min `Math.max(long a, long b) // Returns the smaller of two values.`
- Integer.parseInt `static int parseInt(String s) // Parses the string argument as a signed decimal integer. The characters in the string must all be decimal digits`
- Integer.compare `Integer.compare(a,b) // Compares two int values numerically.`
- new Random().nextInt(exclusiveBound) `Returns a pseudorandom, uniformly distributed int value between 0 (inclusive) and the specified value (exclusive)`

#### Characters
- Character.isDigit `static boolean isDigit(char ch) // Determines if the specified character is a digit.`
- Character.isAlphabetic `static boolean isAlphabetic(int codePoint)  // Determines if the specified character (Unicode code point) is alphabetic.`
- Character.forDigit(rest,10) `Determines the character representation for a specific digit in the specified radix`
- String.toCharArray `char[] toCharArray() // Converts this string to a new character array.`
- Character.getNumericValue() `int getNumericValue(char ch) // Returns the int value that the specified Unicode character represents`
#### Collections
- Arrays.asList `static <T> List<T> asList(T... a)  // Returns a fixed-size list backed by the specified array.`
- Collections.sort `void sort(List<T> list, Comparator<? super T> c)  // Sorts the specified list according to the order induced by the specified comparator.`
- Comparator.comparing `Comparator.comparing(Car::position)  // Accepts a function that extracts a Comparable sort key from a type T, and returns a Comparator<T> that compares by that sort key.`
- comparator.reversed `Comparator.comparing(Car::position).reversed() // Returns a comparator that imposes the reverse ordering of this comparator.`
- Arrays.copyOfRange `Arrays.copyOfRange(originalArray,fromInclusive, toExclusive) // Copies the
  specified range of the specified array into a new array.`
- Arrays.stream(nums).boxed().collect(Collectors.toList())) `Modifiable list from numbers array`
- Objects.hash `static int hash(Object... values) // Generates a hash code for a sequence of input values.`

### Common knowledge

- 26 letters in English alphabet
- Bitwise operations:
  - Bitwise AND: `a & b`
  - Bitwise OR: `a | b` 
  - Bitwise XOR: `a ^ b`
  - Bitwise NOT: `~a` 
  - Bitwise Left Shift: `a << 2` 
  - Bitwise Right Shift: `a >> 2`
  - Bitwise Unsigned Right Shift: `a >>> 2`