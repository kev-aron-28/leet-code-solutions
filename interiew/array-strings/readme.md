# Array and strings

## What an array really is?
A contiguous block of memory where each element has the same size

| Operation         | Cost                 | Why                     |
| ----------------- | -------------------- | ----------------------- |
| Access by index   | **O(1)**             | Direct memory address   |
| Update by index   | **O(1)**             | Same reason             |
| Search (unsorted) | **O(n)**             | Must scan               |
| Insert at end     | **O(1)** (amortized) | Space already allocated |
| Insert at middle  | **O(n)**             | Shift elements          |
| Delete            | **O(n)**             | Shift elements          |

## Strings Are Arrays (But With Rules)
An array of characters

| Operation            | Time |
| -------------------- | ---- |
| Access `s.charAt(i)` | O(1) |
| Length `s.length()`  | O(1) |
| Concatenation        | O(n) |
| Substring            | O(n) |
| Comparison           | O(n) |

Continuous = sliding window territory

Everything else (two pointers, sliding window, hash maps) exists to:
**Avoid nested loops and extra memory**

# typical patterns

## Two pointers same direction

When to use: 
- Array or string
- You want to scan once
- Often in-place
- sually sorted, but not always

One pointer reads, the other writes or validates.

Typical problems:
Remove Duplicates from Sorted Array
Remove Element
Is Subsequence
Merge Two Sorted Arrays
Move Zeroes

Expected complexity
1. Time: O(n)
2. Space: O(1)

## Two pointers - opposite ends
When to use: 
- Sorted array
- Comparing pairs
- Palindrome-style logic

One pointer starts left, one right, move inward.

Typical problems: 
Valid Palindrome
Two Sum (sorted input)
Container With Most Water
Reverse String
Squares of a Sorted Array

## Sliding Window — Fixed Size

When to use
- Subarray / substring
- Exact window size k

Add the new element, remove the old one.

Typical problems: 
Maximum Average Subarray
Maximum Sum Subarray of Size K
Diet Plan Performance

Expected complexity
Time: O(n)
Space: O(1)

## Sliding window variable size

When to use
Longest / shortest substring
Constraints like “at most”, “no more than”

Expand until invalid, shrink until valid

Typical problems: 
Longest Substring Without Repeating Characters
Minimum Window Substring
Longest Repeating Character Replacement
Fruit Into Baskets

## Hash Map / Frequency Counter

When to use:
Counting
Fast lookup
Tracking seen elements

Trade space for time

Typical problems:
Two Sum
Valid Anagram
Group Anagrams
First Unique Character
Contains Duplicate

## Prefix Sum

When to use:
Range sum queries
Subarray sum problems

Precompute sums so ranges are fast.

Typical problems:
Range Sum Query
Subarray Sum Equals K
Continuous Subarray Sum

## Sorting + Scan

When to use
- Order simplifies logic
- Pair / triplet problems

Sorting reduces the problem to linear scanning.

Typical problems:
3Sum
Merge Intervals
Meeting Rooms
Longest Consecutive Sequence

Expected complexity
Time: O(n log n)
Space: depends on sort

## In place modification
When to use: 
Space constraints
Modify input allowed

Overwrite unused positions.
Typical problems:
Remove Element
Move Zeroes
Rotate Array
Remove Duplicates

