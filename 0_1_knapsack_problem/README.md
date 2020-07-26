# 0-1 Knapsack Problem

- 0-1 Knapsack Problem with implementation through various algorithms
- Algorithms include branch and bound, backtracking, and brute force

# Testing files

- The user inputs:
- 1) total items bag can potentially take
- 2) various weights/profits of each item
- 3) the maximum weight the bag can hold


# Output

- Displays maximium profit and nodes visited
- Along with this, whether the best set was used for the implemented algorithm

# __________________________________________________________________________

# Branch and Bound (best performance)

- Uses best-first search of state space tree (checks if node is promising BEFORE visiting)
- Determines best bound through a priority queue; provides optimal solution


# Backtracking (second best performance)

- Uses depth-first search of state space tree (checks if node is promising AFTER visiting)
- If the node is not promising, it backtracks for a more promising solution
- This results in visited nodes that may not be promising from larger item inputs (ie. 8_items output)

# Brute Force (worst performance)

- Significantly slower algorithm; greatest number of nodes visited between the 3 algorithms
- ie. 5_items and 6_items output
