# Graph

What is a graph?
A graph is: G = (V, E)

v: vertices (nodes)
e: edges (connections)

# Types
| Type         | Meaning             |
| ------------ | ------------------- |
| Undirected   | A — B               |
| Directed     | A → B               |
| Weighted     | edges have cost     |
| Unweighted   | all edges = 1       |
| Cyclic       | has loops           |
| Acyclic      | no loops            |
| Connected    | all nodes reachable |
| Disconnected | multiple components |

# Representation

A. Adjacency list

``` java
Map<Integer, List<Integer>> graph;
```

B. Adjacency matrix

```
matrix[i][j]=1 if edge exists
```

C. Edge list

```
List<int[]> edges> edges;
```

# Traversals (BFS vs DFS)

1. DFS
Go as deep as possible before backtracking
- Uses recursion/stack
- Exploring structure
- Detecting cycles
- backtracking

2. BFS
Explore layer by layer
Key property:
First time you reach a node = shortest path(unweighted)

# Complexity
| Algorithm  | Time       |
| ---------- | ---------- |
| BFS        | O(V + E)   |
| DFS        | O(V + E)   |
| Dijkstra   | O(E log V) |
| Union-Find | ~O(1)      |
