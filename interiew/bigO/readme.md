# Big O

## Big O
In academia, big O is described as an upper bound on the time. An algorithm thtat prints all the values in an array coud be described as O(N), but also as
O(N2), O(N3). The algorithm is at least as fast as each of these; therefor they are upper bounds on the runtime. This is similar to an
less than or equal relationship.

## Big omega (Ω)
Omega is equivalent concept but for lower bound. AFter all it wont be faster than those runtimes.

## Big theta (Θ)
Means Both O and Ω, Θ gives a tight bound on runtime

## Amortized time
This allows us to describe that this worst case happends every once in a while but once this happens, it wont happen again for so long that the cost is 
amortized

## Patterns

### Single loop linear growth Time: O(n)
```
for (int i = 0; i < n; i++) {
    doSomething();
}
```
Seen in:
- Array traversal
- String scan
-Counting / summing

### Nested Loops (Quadratic Growth) Time: O(n²)
Loop inside loop over same n

```
for (int i = 0; i < n; i++) { 
    for (int j = 0; j < n; j++) {
        doSomething();
    }
}
```
Seen in:
Brute-force comparisons
Matrix traversal
Naive substring search

### Nested Loop with Shrinking Range O(n²) 
inner loop depends on outer loop
```
for (int i = 0; i < n; i++) {
    for (int j = i; j < n; j++) {
        doSomething();
    }
}
```

### Logarithmic Loop (Divide by Constant) O(log n)
input size shrinks each iteration
```
int i = n;
while (i > 1) {
    i /= 2;
} 
```

###  Logarithmic Growth Loop (Multiply by Constant) O(log n)

```
int i = 1;
while (i < n) {
    i *= 2;
}
```

### Linear Loop + Binary Search O(n log n)
```
for (int i = 0; i < n; i++) {
    binarySearch(arr);
}
```

### Linear recursion Time: O(n), Space: O(n) (call stack)
One call per input value.
```
void func(int n) {
    if (n == 0) return;
    func(n - 1);
}
```


## Branching recursion Time: O(2ⁿ)
ecursive call tree doubles each level
```
void func(int n) {
    if (n <= 1) return;
    func(n - 1);
    func(n - 1);
}
```