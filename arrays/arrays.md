#### Arrays

A sequence of values stored sequentially in memory. Good for **lookup** and **append** operations, but slow **insert** and **delete**.

#### Static Arrays

Declared with fixed size.

Lookup: `O(1)` - when accessing an address, processor caches nearby addresses. Since arrays are stored contiguously in memory, we can compute the `i`th item's address in constant time using byte arithmetic - as a result, iteration is also very fast

Append: `O(1)` - lookup and set value in constant time

Insert: `O(N)` - requires us to copy at most `N` elements and insert them after new item

Delete: `O(N)` - we have to maintain uninterrupted sequence of items in memory for constant time access, so deleting any item other than the last requires us to copy at most N elements and insert to close gap 

#### Dynamic Arrays

We can improve arrays to support dynamic resizing.

Append, worst case: `O(N)` - when array capacity is full, we create a new array of `2N` size.  Then we iterate over new array, copying all `N` elements to it. Finally we set the new array to our old array reference.
___

Since resizing is rare compared to normal appends, we analyze the average cost of appending over many operations. To do this, we compute:

`cost of operations / frequency of operations`

Cost of `N` append operations: since each append is `O(1)`, cost of appends in themselves is `O(N)`. Now, for the cost of doubling the array size for each attempted append on full capacity:

`1 + 2 + 4 + . . . + N/2 + N` or `N + N/2 + . . . + 4 + 2 + 1`

To find the sum of this sequence: consider a square with area `N` - now, by combining squares of size `N/2`, `N/4`, etc, we end up with another square with area slightly less than `N`, hence a sum of `~2N`. Then `2N` doubling + `N` for the appends gives `3N`.  We can simplify to `O(N)`, meaning the total cost of `N` appends grows at a linear rate.

Append, average case - divide cost by frequency:

`O(N) / N = O(1)` 
___

Consider the delete case. If we half size of array when `N = 1/2` of capacity, we will need to double again on next append.  Instead, we half size of array when `N = 1/4` of capacity, so that there is room for several more appends.

#### Strings

Strings are implemented as fixed-size arrays of `char` primitives. Consider performance when growing strings, where `a` is an array of strings:

```java
public static void buildSentence(String str, String[] a) { // O(N^2)
  for (String s : a) { // O(N)
    str += s; // O(N)
  }				
}
```
Above, for each string concatenation, we have to create a new string object and copy over the old `char` values plus the appended string `s` - leading to expensive linear cost for each iteration, and thus quadratic performance for the whole loop. 
___

We can optimize by declaring and reusing a string builder outside of the loop, since like a dynamic array, a string builder dynamically resizes its underlying `char` array to give average costant time append.
```java
public static void buildSentence(String str, String[] a) { // O(N)
  StringBuilder sb = new StringBuilder(str);
  for (String s : a) { // O(N)
    sb.append(s); // O(1) amortized
  }
}
```

#### Maps

Maps are built on arrays, using _hash functions_ to associate keys to array indices for fast lookup. A hash function for a map of `N` key-value pairs should transform a key into an array index in range `[0, N-1]`. Note that keys in array are _unordered_.

For a map of `N` key-value pairs, hash function should:
1. Hash keys uniformly across array indices in `[0, N-1]`
2. Always hash a given key to the same index
3. Hash an altered key to totally new index
4. Be efficient to compute; if expensive, cache initial computation

As an example, a simple hash function would compute `k % N` (remainder when `k / N`), where map size `N` is a prime number. One way to convert a string key to a number `k`: sum the numeric values of each `char` in the string.

Lookup, average case: `O(1)` - hashing key to array index is constant time, and getting value at that index is constant time.