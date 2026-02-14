


## Sliding window + hashmap
Longest Substring Without Repeating Characters - 
Maximum Average Subarray -
Maximum Sum Subarray of Size K -
Diet Plan Performance -
Permutation in String -
Fruit Into Baskets - 
 
Longest Repeating Character Replacement -
Substrings of Size K with K Distinct Characters -
Count Number of Nice Subarrays - 
Minimum Window Substring - 
Longest Substring with At Most K Distinct Characters - 
Replace the Substring for Balanced String  -
Substring with Concatenation of All Words - 
Sliding Window Maximum (mezcla con deque) - 

# Frequency count / anagrams
Valid Anagram -
Ransom Note - 
First Unique Character in a String - 
Reorganize String - 
Minimum Deletions to Make Character Frequencies Unique - 
Palindrome Permutation II

# Prefix sum + hashmap
Subarray Sum Equals K - 
Continuous Subarray Sum -
Maximum Size Subarray Sum Equals K - 
Contiguous Array - 
Binary Subarrays With Sum - 

# Hashset ()
Contains Duplicate
Happy Number
Intersection of Two Arrays
Longest Consecutive Sequence
Find the Duplicate Number
Single Number
Longest Consecutive Sequence II
Repeated DNA Sequences
Detect Cycles in Graph (HashSet + DFS)

# TWO SUM / COMPLEMENTO
3Sum
4Sum
Two Sum II (sorted)
Subarray Sum Equals K (otra vez, pero clave)
Max Number of K-Sum Pairs
Count Pairs With Given Sum

HASHMAP + GREEDY / HEAP 
Top K Frequent Elements
Kth Most Frequent Element

Task Scheduler
Reorganize String
Hand of Straights
Split Array into Consecutive Subsequences



# Prefix sum

Prefix sum = precompute cumulative information so you don’t recompute it again and again

“Let me store the sum up to every index once.”

So later, every query becomes O(1).

```
nums = [2, 4, 1, 7, 3]
prefix[0] = 0
prefix[1] = 2
prefix[2] = 6
prefix[3] = 7
prefix[4] = 14
prefix[5] = 17
```

prefix[i] = sum of elements before index i

## Basic template

```
int n = nums.length;
int[] prefix = new int[n + 1];

prefix[0] = 0;
for (int i = 0; i < n; i++) {
    prefix[i + 1] = prefix[i] + nums[i];
}
```

Use when:
- You need range sums
- You’ll answer multiple queries
- Or you want to remove an inner loop

## Prefix sum + HashMap

- Count subarrays with sum = K

How many continuous chunks of the array add up to K?

### Que es prefix 
             0  1  2
Dado nums = [1, 2, 3], definimos
prefix[0] = 0
prefix[1] = 1
prefix[2] = 3
prefix[3] = 6

prefix[1] → suma de los números antes del índice 1 → [1]
prefix[2] → suma de [1,2]
prefix[3] → suma de [1,2,3]

prefix[i] = suma desde 0 hasta i-1

### Qué significa un subarray l .. r
Si yo digo:
l = 1
r = 2

El subarray es:
nums[1] + nums[2] = 2 + 3 = 5


prefix[r + 1] = suma de nums[0] hasta nums[r]
prefix[l]     = suma de nums[0] hasta nums[l-1]

Ejemplo concreto (l=1, r=2):
prefix[3] = 1 + 2 + 3 = 6
prefix[1] = 1

Si hago: prefix[3] - prefix[1] = 6 - 1 = 5
¿Y cuánto era el subarray 1..2?

La resta elimina todo lo de antes de l
Lo que queda es EXACTAMENTE el subarray l..r

Entonces esta ecuación SOLO dice esto
prefix[r + 1] - prefix[l] = k

"La suma del subarray que empieza en l y termina en r vale k"


### El problema REAL: no sabemos l
Cuando recorremos el arreglo, sabemos r (porque vamos avanzando).
pero no sabemos l = ?

prefix[l] = prefix[r + 1] - k

Cuando estoy en una posición y mi suma acumulada es:
currentSum = prefix[r + 1]

¿Existe algún punto anterior donde la suma acumulada sea
currentSum - k?

Si existe, entonces: lo que hay entre ese punto y aquí = k

Un subarray es la diferencia entre dos sumas prefijas.