#### Lists

A list is built on `Node` references, where each `Node` stores data as well as a reference to another `Node`:

```java
class Node {
	T data;
	Node next;
	Node prev;
}
```

Unlike an array, we do not allocate a fixed amount of memory at declaration. We get fast **insert** and **remove** operations at ends of the list.

Insert/Remove from front or back: `O(1)` - if we have a reference to a `Node`, inserting or removing an adjacent `Node` becomes a matter of modifying references

For example, adding to front of list:
```java
Node oldHead = head; //`head` points to front of list
head = new Node();
head.data = data;
head.next = oldHead; //Append list to new head
```

Lookup: `O(N)` - we have to step through the list to find the `k`th `Node`

To find and delete a particular item in the list, we have to iterate through to find it:
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



