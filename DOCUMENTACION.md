Este programa en Java implementa dos funcionalidades principales:

Desplazamiento de elementos en un arreglo:
Se toma una secuencia de caracteres (ingresada por el usuario) y se realiza un desplazamiento de elementos. 
La primera mitad del arreglo se desplaza hacia la izquierda y la segunda mitad se desplaza hacia la derecha, repitiendo este proceso T veces. Nota: El número de elementos debe ser par.

Generación y ordenamiento de estudiantes:
El programa genera un número aleatorio (par) de estudiantes (entre 2 y 50) utilizando valores aleatorios para la matrícula y el índice académico. 
El usuario proporciona un nombre base para los estudiantes. 
Luego, se ordena la lista de estudiantes utilizando el algoritmo MergeSort, en forma ascendente o descendente, según lo especificado por el usuario.

Ejemplo de Entrada:
Digite la secuencia de datos (separado por espacio):
a b c d
Indique el valor de T:
2

Ejemplo de Salida:
Resultado final del arreglo:
[c, d, a, b]

Ejemplo 2: Ordenamiento de Estudiantes

Entrada:
Indique el nombre base para los estudiantes:
Estudiante
Lista generada de estudiantes:
123 - Estudiante #1 - 3.45
456 - Estudiante #2 - 2.98
789 - Estudiante #3 - 3.76
... (otros estudiantes generados aleatoriamente)
Ordenar por índice académico de manera ascendente (true/false):
true

Salida:
Estudiantes ordenados:
456 - Estudiante #2 - 2.98
123 - Estudiante #1 - 3.45
789 - Estudiante #3 - 3.76
... (lista ordenada según el índice académico)

Análisis del Rendimiento
Desplazamiento del Arreglo
Complejidad:
El desplazamiento de cada mitad del arreglo se realiza en tiempo lineal respecto a la cantidad de elementos, es decir, O(n/2) por cada desplazamiento.
Al realizarse T veces, la complejidad total es O(T*n).

Ordenamiento de Estudiantes (MergeSort)
Complejidad:
MergeSort es un algoritmo de ordenamiento con complejidad O(n log n) en promedio y en el peor caso.
Uso de Procesos/Recursividad:
Aunque el algoritmo utiliza recursión para dividir la lista y posteriormente fusionarla, en este caso se ejecuta en un único proceso.
