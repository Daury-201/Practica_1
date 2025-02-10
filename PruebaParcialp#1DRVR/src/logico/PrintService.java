package logico;

// Libreria para obtener la hora actual
import java.time.LocalDateTime;

public class PrintService {
    // Cola de impresion que gestionara los trabajos en orden de prioridad
    private PrintQueue colaImpresion;

    // Constructor que inicializa la cola de impresion
    public PrintService() {
        this.colaImpresion = new PrintQueue();
    }

    // Metodo para agregar un nuevo trabajo de impresión a la cola
    public void enviarTrabajo(String usuario, LocalDateTime horaEnvio, String prioridad) {
        PrintJob nuevoTrabajo = new PrintJob(usuario, horaEnvio, prioridad);
        colaImpresion.agregarTrabajo(nuevoTrabajo); // Agrega el trabajo a la cola
        System.out.println("Trabajo agregado: " + nuevoTrabajo);
    }

    // Metodo para procesar el siguiente trabajo en la cola de impresion
    public void procesarTrabajo() {
        PrintJob trabajo = colaImpresion.procesarSiguienteTrabajo(); // Obtiene y elimina el siguiente trabajo
        if (trabajo != null) {
            System.out.println("Procesando: " + trabajo);
        } else {
            System.out.println("No hay trabajos en la cola.");
        }
    }

    // Método para verificar si la cola de impresión está vacia
    public boolean estaVacia() {  
        return colaImpresion.estaVacia();
    }
}

