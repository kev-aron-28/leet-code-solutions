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