#### Optimization

The _bottleneck_ in an algorithm slows down overall runtime, either through

1. expensive one-time work, like pre-processing a collection by sorting
2. an expensive operation that is repeated, like a linear search on every iteration

Take two-sum as an example: find all pairs in an array that sum to `k`.
```
for each a[i]
  find a[j] such that a[i] + a[j] == k
```

Solution: for each `a[i]`, perform a linear search through the array for the right `a[j]`:
```java
for (int i = 0; i < a.length; i++) //O(N)
  for (int j = i + 1; j < a.length; j++) //O(N)
    if (a[i] + a[j] == k)
```
Bottleneck: the search for `a[j]` is `O(N)`, so total runtime is `O(N^2)` - untenable for large inputs.

Solution: we can optimize by using Binary Search for each `a[j]`, where `a[i] + a[j] == k` or `a[j] == k - a[i]`:
```java
for (int i = 0; i < a.length; i++) //O(N)
  if (Arrays.binarySearch(a, k - a[i]) >= 0) //O(N log N)
```

Bottleneck: still Binary Search is too expensive.

Solution: we can make a **time-space tradeoff**, using a hash map to get faster search:
```java
Set<Integer> set = new HashSet<>();
for (int i = 0; i < a.length; i++) //O(N)
  set.add(a[i]);
for (int i = 0; i < a.length; i++) //O(N)
  if (set.contains(k - a[i])) //O(1)

```