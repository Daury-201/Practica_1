package logico;

import java.util.PriorityQueue;

public class PrintQueue {
    // Cola de prioridad para almacenar los trabajos de impresión
    private PriorityQueue<PrintJob> colaTrabajos;

    // Constructor que inicializa la cola de prioridad
    public PrintQueue() {
        this.colaTrabajos = new PriorityQueue<>();
    }

    // Metodo para agregar un nuevo trabajo a la cola de impresion
    public void agregarTrabajo(PrintJob trabajo) {
        colaTrabajos.offer(trabajo);
    }

    // Metodo para procesar y eliminar el siguiente trabajo en la cola
    public PrintJob procesarSiguienteTrabajo() {
        return colaTrabajos.poll();
    }

    // Metodo para verificar si la cola de impresión está vacía
    public boolean estaVacia() {
        return colaTrabajos.isEmpty();
    }
}
