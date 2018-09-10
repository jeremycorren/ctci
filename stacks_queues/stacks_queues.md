_Abstract data types_, or ADTs, describe a policy based on user expectations for the behaviors of operations on data. We use _data structures_ like arrays or lists to implement a given ADT.

#### Stacks

A stack conforms to the _last-in first-out_ or LIFO policy: items are pushed on top of one another, and then popped off starting with those most recently added, as in the case of an email inbox.

_List implementation_: a list is a logical choice since we have guaranteed constant-time access to front of the list.
Push: `O(1)` - add a new `Node` to the front of the list

Pop: `O(1)` - remove `Node` from front of the list

_Dynamic array implementation_: we use a `size` var to track the top of the stack in the backing array
Push: amortized `O(1)` - add item at next empty array space and increment size. Worst case `O(N)` when backing array is full, must copy items to array of `2N` size

Pop: `O(1)` - get data at last filled array space, decrement size.

#### Queues

A queue conforms to the _first-in first-out_ or FIFO policy: items are enqueued to the back and dequeued from the front, in the order they came in, as in the case of a line to buy movie tickets.

_List implementation_
Enqueue: `O(1)` - add a new `Node` to the back of the list

Dequeue: `O(1)` - remove `Node` at front of the list

_Dynamic array implementation_: use `front` and `back` vars to track ends of the queue
Enqueue: amortized `O(1)` - add item at next empty array space, increment `back`

Dequeue: amortized `O(1)` - get data at `front` and increment `front` to dequeue