# Roadmap
- Array
Fundamentos
Memoria contigua
Acceso directo (indexing)
Diferencia entre array estático y dinámico
Stack vs Heap allocation
Complejidad
Acceso O(1)
Inserción/eliminación O(n)
Cache friendliness (localidad espacial)
Variantes
Arrays 1D, 2D, nD
Arrays circulares
Sparse arrays
Detalles importantes
Reasignación de memoria en arrays dinámicos
Coste oculto del resize (amortized analysis)
Arrays vs Linked Lists (trade-offs reales)

- Strings
Representación interna
Strings como arrays de chars
Null-terminated strings vs length-prefixed
UTF-8 vs UTF-16 vs ASCII
Operaciones
Concatenación
Substrings
Comparación lexicográfica
Inmutabilidad vs mutabilidad
Costes reales
Copy-on-write
Coste oculto de concatenar en loops
Encoding pitfalls


- Hash Table (HashMap / HashSet)
Fundamentos
Funciones hash
Uniformidad y colisiones
Load factor
Resolución de colisiones
Chaining
Open addressing
Linear probing
Quadratic probing
Double hashing
Rehashing
Cuándo ocurre
Coste amortizado
Estrategias de crecimiento
Complejidad
O(1) amortizado vs O(n) peor caso
Ataques de colisión
Implementación interna
Buckets
HashMap vs HashSet
Ordered hash tables

- Stack
Fundamentos
LIFO
Stack frame
Call stack
Implementación
Stack con array
Stack con linked list
Casos de uso reales
Evaluación de expresiones
Backtracking
Undo / Redo
Detalles críticos
Stack overflow
Iterativo vs recursivo

- Linked List
Tipos
Singly linked list
Doubly linked list
Circular linked list
Operaciones
Inserción
Eliminación
Búsqueda
Memoria
Overhead de punteros
Fragmentación
Trade-offs
Cache-unfriendly
Ventajas frente a arrays

- Trees (General)
Conceptos base
Nodo
Raíz
Hojas
Altura
Profundidad
Representación
Referencias
Arrays implícitos
Recorridos
DFS
BFS

- Binary Tree
Tipos
Full
Complete
Perfect
Skewed
Recorridos
Preorder
Inorder
Postorder
Level order
Implementación
Recursiva
Iterativa

- Binary Search Tree (BST)
Propiedades
Inorder ordenado
Invariante del BST
Operaciones
Inserción
Eliminación
Búsqueda
Problemas
Árbol degenerado
Balanceo manual

- Árboles Balanceados
AVL
Factor de balance
Rotaciones
Red-Black Tree
Reglas
Colores
Casos de rotación
Comparación
AVL vs Red-Black
Uso real en lenguajes (Java, C++)

- Heap
Fundamentos
Heap property
Complete binary tree
Tipos
Min-heap
Max-heap
Operaciones
Heapify
Insert
Extract
Implementación
Array-based heap

- Priority Queue
Relación con heap
Comparator
Estabilidad
Casos reales
Scheduling
Dijkstra
Event simulation

- Graph
Fundamentos
Vértices
Aristas
Grados
Tipos
Directed / Undirected
Weighted / Unweighted
Cyclic / Acyclic
Representación
Adjacency list
Adjacency matrix

- Union-Find (Disjoint Set)
Fundamentos
Parent array
Rank / Size
Optimización
Path compression
Union by rank
Complejidad
Amortized α(n)

- Trie
Fundamentos
Prefijos
Árbol de caracteres
Implementación
Arrays vs HashMaps
Trade-offs
Memoria vs velocidad

- Segment Tree / Fenwick Tree
Casos de uso
Range queries
Actualizaciones dinámicas
Implementación
Bottom-up
Top-down
Complejidad
O(log n)

Skip List
Concepto
Listas con niveles
Probabilidad
Comparación
Skip List vs Balanced Trees

