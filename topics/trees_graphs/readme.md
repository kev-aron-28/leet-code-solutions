# TREES

Hierarchical data structure used to orgnized and represent data in parent-child relationship

## Terminology

- Parent Node: A node that is an immediate predecessor of another node. Example: 35 is the parent of 3 and 6.
- Child Node: A node that is an immediate successor of another node. Example: 3 and 6 are children of 35.
- Root Node: The topmost node in a tree, which does not have a parent. Example: 15 is the root node.
- Leaf Node (External Node): Nodes that do not have any children. Example: 1, 10, 12, 5, 7, 7 are leaf nodes.
- Ancestor: Any node on the path from the root to a given node (excluding the node itself). Example: 15 and 35 are ancestors of 10.
- Descendant: A node x is a descendant of another node y if y is an ancestor of x. Example: 1, 10, and 6 are descendants of 35.
- Sibling: Nodes that share the same parent. Example: 1 and 10 are siblings, and 5 and 7 are siblings.
- Level of a Node: The number of edges in the path from the root to that node.The root node is at level 0.
- Internal Node: A node with at least one child.
- Neighbor of a Node: The parent or children of a node.
- Subtree:  A node and all its descendants form a subtree.

A tree is a non-linear data structure

# Binary trees
A Binary Tree is a type of tree data structure where each node can have a maximum of two child nodes, a left child node and a right child node.

Benefits over an arrays, linked lists and binary trees
- Arrays are fast when you want to access an element directly, like element number 700 in an array of 1000 elements for example. But inserting and deleting elements require other elements to shift in memory to make place for the new element, or to take the deleted elements place, and that is time consuming.
- Linked Lists are fast when inserting or deleting nodes, no memory shifting needed, but to access an element inside the list, the list must be traversed, and that takes time.
- Binary Trees, such as Binary Search Trees and AVL Trees, are great compared to Arrays and Linked Lists because they are BOTH fast at accessing a node, AND fast when it comes to deleting or 
inserting a node, with no shifts in memory needed.

# Types of Binary Trees
- Balanced Binary Tree has at most 1 in difference between its left and right subtree heights, for each node in the tree.
- A complete Binary Tree has all levels full of nodes, except the last level, which is can also be full, or filled from left to right. The properties of a complete Binary Tree means it is also balanced.
- A full Binary Tree is a kind of tree where each node has either 0 or 2 child nodes.
- Perfect Binary Tree has all leaf nodes on the same level, which means that all levels are full of nodes

# Binary Tree Traversal
- Breadth First Search (BFS) is when the nodes on the same level are visited before going to the next level in the tree. This means that the tree is explored in a more sideways direction.
- Depth First Search (DFS) is when the traversal moves down the tree all the way to the leaf nodes, exploring the tree branch by branch in a downwards direction.

There are three different types of DFS traversals:
- pre-order
- in-order
- post-order


# Pre order
Pre-order Traversal is done by visiting the root node first, then recursively do a pre-order traversal of the left subtree, followed by a recursive pre-order traversal of the right subtree. 
It's used for creating a copy of the tree, prefix notation of an expression tree, etc.

# IN order
In-order Traversal does a recursive In-order Traversal of the left subtree, visits the root node, and finally, does a recursive In-order Traversal of the right subtree. This traversal is mainly used for Binary Search Trees where it returns values in ascending order.

What makes this traversal "in" order, is that the node is visited in between the recursive function calls. 

# Post order
Post-order Traversal works by recursively doing a Post-order Traversal of the left subtree and the right subtree, followed by a visit to the root node. 
It is used for deleting a tree, post-fix notation of an expression tree, etc.


