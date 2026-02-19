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
Es qué tan abajo está un nodo desde la raíz.
        1
       / \
      2   3
     /
    4
¿Cuántos pasos bajé desde arriba hasta llegar aquí?
Nodo 1 → profundidad 1
Nodo 2 → profundidad 2
Nodo 4 → profundidad 3


# Altura (Height)
Es qué tan alto es el árbol desde ese nodo hacia abajo.



# LEAF o hoja
ES un nodo que o tiene hijos left == null y right == null

# TIpos de arbol binario

## Full Binary Tree (Árbol Binario Lleno)
No puede tener solo un hijo. O tiene los dos o ninguno

      1
     / \
    2   3
   / \
  4   5

## Complete binary tree
- Todos los niveles están llenos
- Excepto posiblemente el último
- Y el último se llena de izquierda a derecha

        1
       / \
      2   3
     / \  /
    4  5 6

Esto no es:
        1
       / \
      2   3
       \ 
        5

Porque hay un hueco a la izquierda

## Perfect binary tree
Todos los niveles están completamente llenos
Todas las hojas están al mismo nivel

Número de nodos = 2^h - 1

## Balanced Binary Tree
| altura izquierda - altura derecha | <= 1

No necesita estar completamente lleno.

## Binary Search Tree (BST)
left < root < right

| Tipo       | Regla clave                  |
| ---------- | ---------------------------- |
| Full       | 0 o 2 hijos                  |
| Complete   | Lleno de izquierda a derecha |
| Perfect    | Todos los niveles llenos     |
| Balanced   | Alturas difieren máximo 1    |
| Degenerate | Como linked list             |
| Skewed     | Todo hacia un lado           |
| BST        | left < root < right          |
