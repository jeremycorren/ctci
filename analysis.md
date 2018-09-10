#### Time Complexity

Big-O describes how runtime of a program grows as its input size grows.
Graphically, we can represent `N` input on the _x_ axis and the correspondent runtime on the _y_ axis.

For a given program, `runtime = cost × frequency`.  

In our model, a single operations takes a _constant amount of time_.
```java
public static boolean contains(int[] a, int key) {
  for (Integer i : a) { // Loop iterates N times: O(N * 1)
    if (i == key) { // Each compare takes O(1)
      return true; 
    } 
  }
}
```
Assume each compare takes 2 ms:
| Input (_N_) 	| Runtime|
|-  			|- 		 |
| 5				| 10 ms	 |
| 10			| 20 ms	 |
Notice that with `O(N)`, runtime grows as a linear function of input size.

Generally, we look at the worst case, in which we must step over _N_ values when `key` is last item in `a`.

##### Simplifying expressions

As `N` grows arbitrarily large, less significant terms have an increasingly smaller effect on runtime.

Take the runtime `N^2 + N + 5`.  

`N^2` simply grows much faster than `N`.  5 doesn't grow at all - since it's a constant, it doesn't change with input size (a flat line on graph)! 

We can simplify `N^2 + N + 5` to `O(N^2)`.

**Note**: At some value of `N`, runtime of program that takes variable-size input exceeds runtime of a program with extremely large constant input.

_Examples_

If chunks of work happen sequentially, **add** their runtimes.
```java
public static void printTwice(int[] a) { // O(N + N) = O(2N) = O(N)
  for (Integer i : a) {// O(N)
    System.out.println(i);
  }
  for (Integer j : a) { // O(N)
    System.out.println(j); 	
  }		
}
```
While `O(2N)` and `O(N)` will give different runtimes, especially at large values, both reflect linear growth with respect to `N` so we represent as just `O(N)`.

If we had iterated over an array of size `M` and then an array of size `N`, we get `O(M + N)` - we can't simplify since we don't know relationship of `M` to `N`.
___

```java
public static void printAllPairs(int[] a) { // O(N * N) = O(N^2)
  for (Integer i : a) { // O(N)
    for (Integer j : a) { // O(N)
      System.out.println(i + "," + j);
    }
  }
}
```

If some chunk of work is done for each chunk of some other work, **multiply** the runtimes.  If we had iterated over an array of size `N` for every item in an array of size `M`, we get `O(M * N)`.
___

```java
public static void triangularSeries(int[] a) {  // O(N * (N-1)/2) = O(N^2)
  for (int i = 0; i < a.length; i++) {
    for (int j = i + 1; j < a.length; j++) {
      System.out.println(a[i] + "," + a[j]);
    }
  }
}
```
Inner loop runs 

`N-1 + N-2 + . . . + 2 + 1` 

times, since `j` starts from `i+1`.  Notice that all outer pair sums give same result: `(N-1) + 1 = N`, `(N-2) + 2 = N`. As an example, consider `[1, 2, 3, 4, 5]`: `(1 + 4) = 5` and `(2 + 3) = 5`, where `5 = N`, the size of the array.   

We also know there are `(N-1)/2` total pairs. Then, the inner loop runs `N * (N-1)/2` times, or `O(N^2-N / 2) = O(N^2)`.  

For the above example, `(5-1)/2 = 2` total pairs. Then `(5 * (2)) = 1 + 2 + 3 + 4 = 10`.