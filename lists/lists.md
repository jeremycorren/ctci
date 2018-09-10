#### Lists

A _list_ is a sequence of values consisting of `Node` references, where each `Node` stores data as well as a reference to another `Node`:

```java
class Node {
  T data;
  Node next;
  Node prev;
}
```

Unlike an array, we do not allocate a fixed amount of memory at declaration. We get fast **insert** and **remove** operations at ends of the list, but slow **lookup**.

Insert/Remove from front or back: `O(1)` - if we have a reference to a `Node`, inserting or removing an adjacent `Node` becomes a matter of modifying references

For example, adding to front of list:
```java
Node oldHead = head; //`head` points to front of list
head = new Node();
head.data = data;
head.next = oldHead; //Append list to new head
```

Note - a couple of drawbacks to list implementations in spite of perceived advantages:
1. We have to carry around an extra object reference for each `Node`, i.e. `O(N)` space complexity.
2. While most list-end ops are `O(1)`, the constant factor for allocating memory can be expensive.

Lookup: `O(N)` - we have to step through the list to find the `k`th `Node`: since `Node` addresses are not contiguously stored, processor cannot take advantage of caching, and so must follow each `next` or `prev` reference to its corresponding address. Thus **iterating through lists is slower than iterating over arrays**

To find and delete a particular item in the list, we iterate through to find it:
```java
int i = 0;
for (Node n = head; n != null; n = n.next) {
  if (i == k) {
    n.prev.next = n.next;
    n.next.prev = n.prev;
    return n.data;
  }
}
```
Once we find the `Node` to delete, we redirect the `Node`s around it to link one another, effectively dropping `n` from the list.


