# ¿Qué es Inorder?

Left → Root → Right

        4
      /   \
     2     6
    / \   / \
   1   3 5   7

El recorrido inorder produce: 
[1, 2, 3, 4, 5, 6, 7]

En un BST, inorder te da el arreglo ordenado.

Tiempo: O(n)
Espacio: O(h) (altura del árbol, por stack recursivo)

# ¿Qué es Preorder?
Root → Left → Right
Primero procesas el nodo, después exploras.

        4
      /   \
     2     6
    / \   / \
   1   3 5   7

[4, 2, 1, 3, 6, 5, 7]

# ¿Qué es Postorder?

        4
      /   \
     2     6
    / \   / \
   1   3 5   7

[1, 3, 2, 5, 7, 6, 4]

El root se procesa AL FINAL.

Es usado en: 
- Diameter of Binary Tree
- Balanced Binary Tree
- Maximum Path Sum
- DP on trees

# ¿Qué significa realmente “Level Order”?

Significa recorrer el árbol por capas horizontales.

        1          ← Nivel 0
      /   \
     2     3       ← Nivel 1
    / \     \
   4   5     6     ← Nivel 2

A diferencia de DFS (profundidad), aquí queremos: Explorar todos los nodos de una profundidad antes de bajar.
Eso es BFS (Breadth First Search).
Y BFS usa una cola (Queue).

# Que es Depth?
En un árbol binario, depth puede significar dos cosas dependiendo del contexto:

1. Cuántos niveles hay desde la raíz hasta ese nodo.
2. Maximum Depth del árbol

Depth de un nodo: 
Número de aristas (edges) desde la raíz hasta ese nodo.

        A
       / \
      B   C
     /
    D

Si contamos aristas:

depth(A) = 0

depth(B) = 1

depth(D) = 2

Se mide desde arriba hacia abajo.