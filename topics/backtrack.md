# backtracking

Backtracking es una técnica de recursión para resolver problemas de combinaciones, permutaciones o 
caminos posibles, donde quieres explorar todas las opciones posibles 
y retroceder cuando una opción no funciona.

Conceptos claves

Solución parcial (path)
Es lo que ya has construido hasta ahora.

Decisión/elección
Lo que agregas a la solución parcial.

Backtrack / deshacer
Cuando terminas de explorar una rama, vuelves atrás para probar otras posibilidades.

Caso base
La condición que indica que has llegado a una solución completa o que ya no se puede seguir

# patron general

function backtrack(caminoActual, opciones) {
    if (caminoActual es solución) {
        guardar caminoActual
        return
    }

    for (opción in opciones) {
        elegir opción
        backtrack(nuevaSolucionParcial, nuevasOpciones)
        deshacer elección (backtrack)
    }
}

# Problemas mas comunes

1. Combinaciones
Problema: Elegir k elementos de un conjunto sin importar el orden
function combine(n: number, k: number): number[][] {
  const res: number[][] = [];

  function backtrack(start: number, path: number[]) {
    if (path.length === k) {
      res.push([...path]);
      return;
    }
    for (let i = start; i <= n; i++) {
      path.push(i);
      backtrack(i + 1, path);
      path.pop();
    }
  }

  backtrack(1, []);
  return res;
}

console.log(combine(4, 2));
