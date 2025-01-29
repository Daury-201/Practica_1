package logico;

import java.util.*;

public class Practica_2 {

    public static void desplazarArreglo(char[] arreglo, int t) {
        int n = arreglo.length;
        int mitad = n / 2;

        for (int paso = 1; paso <= t; paso++) {
            char tempPrimeraMitad = arreglo[0];
            for (int i = 0; i < mitad - 1; i++) {
                arreglo[i] = arreglo[i + 1];
            }
            arreglo[mitad - 1] = tempPrimeraMitad;

            char tempSegundaMitad = arreglo[n - 1];
            for (int i = n - 1; i > mitad; i--) {
                arreglo[i] = arreglo[i - 1];
            }
            arreglo[mitad] = tempSegundaMitad;
        }
    }

    static class Estudiante {
        int matricula;
        String nombre;
        double indiceAcademico;

        public Estudiante(int matricula, String nombre, double indiceAcademico) {
            this.matricula = matricula;
            this.nombre = nombre;
            this.indiceAcademico = indiceAcademico;
        }

        @Override
        public String toString() {
            return matricula + " - " + nombre + " - " + indiceAcademico;
        }
    }

    public static List<Estudiante> ordenarMergeSort(List<Estudiante> lista, boolean ascendente) {
        if (lista.size() <= 1) {
            return lista;
        }

        int mitad = lista.size() / 2;
        List<Estudiante> izquierda = ordenarMergeSort(lista.subList(0, mitad), ascendente);
        List<Estudiante> derecha = ordenarMergeSort(lista.subList(mitad, lista.size()), ascendente);

        return merge(izquierda, derecha, ascendente);
    }

    private static List<Estudiante> merge(List<Estudiante> izquierda, List<Estudiante> derecha, boolean ascendente) {
        List<Estudiante> resultado = new ArrayList<>();
        int i = 0, j = 0;

        while (i < izquierda.size() && j < derecha.size()) {
            if ((ascendente && izquierda.get(i).indiceAcademico <= derecha.get(j).indiceAcademico)
                    || (!ascendente && izquierda.get(i).indiceAcademico >= derecha.get(j).indiceAcademico)) {
                resultado.add(izquierda.get(i++));
            } else {
                resultado.add(derecha.get(j++));
            }
        }

        while (i < izquierda.size()) {
            resultado.add(izquierda.get(i++));
        }

        while (j < derecha.size()) {
            resultado.add(derecha.get(j++));
        }

        return resultado;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite la secuencia de datos (separado por espacio):");
        String[] elementos = scanner.nextLine().split(" ");
        char[] arreglo = new char[elementos.length];
        for (int i = 0; i < elementos.length; i++) {
            arreglo[i] = elementos[i].charAt(0);
        }

        if (arreglo.length % 2 != 0) {
            System.out.println("El número de elementos (n) debe ser par.");
            return;
        }

        System.out.println("Indique el valor de T:");
        int t = scanner.nextInt();

        desplazarArreglo(arreglo, t);

        System.out.println("Resultado final del arreglo:");
        System.out.println(Arrays.toString(arreglo));

        System.out.println("\nIndique el nombre base para los estudiantes:");
        String nombreBase = scanner.next();

        Random random = new Random();
        int n = random.nextInt(50) + 2; 
        if (n % 2 != 0) n++;

        List<Estudiante> estudiantes = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int matricula = random.nextInt(1000) + 1;
            double indiceAcademico = 1.0 + random.nextDouble() * 3.0; 
            estudiantes.add(new Estudiante(matricula, nombreBase + " #" + i, indiceAcademico));
        }

        System.out.println("Lista generada de estudiantes:");
        for (Estudiante estudiante : estudiantes) {
            System.out.println(estudiante);
        }

        System.out.println("\nOrdenar por índice académico de manera ascendente (true/false):");
        boolean ascendente = scanner.nextBoolean();

        List<Estudiante> estudiantesOrdenados = ordenarMergeSort(estudiantes, ascendente);

        System.out.println("Estudiantes ordenados:");
        for (Estudiante estudiante : estudiantesOrdenados) {
            System.out.println(estudiante);
        }

        scanner.close();
    }

}
