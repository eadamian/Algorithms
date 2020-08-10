# Sorting Algorithms
- Algorithms include insertion sort, merge sort, and 3 forms of quicksort
- Quicksort 1: Regular quicksort using partition
- Quicksort 2: Quicksort using partition; calls insertion sort when array or subarray of size n <= 16; makes sorting algorithm more efficient, as insertion sort is fast when the problem size is small (insertion sort has low overhead)
- Quicksort 3: Randomized quicksort; modified to perform well on every input by selecting a random input, rather than the first input. Since Random() function takes time for each call, we only invoke it for elements of size n <= 16

# Input/Output

Input:
- javac Main.java
- java Main

- NOTE: This tests the first hardcoded array; second hardcoded array commented out in Main.java

Output:
- A sorted array for each sorting algorithm (5 total)
- A runtime for each sorting algorithm (5 total); 2^16 iterations ran for accurate results (compared to that of 1 iteration per sorting algorithm)
