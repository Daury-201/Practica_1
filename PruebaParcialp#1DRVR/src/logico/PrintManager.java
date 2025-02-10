package logico;

//Libreria para obtener la hora actual
import java.time.LocalDateTime;
//Libreria para capturar los datos del usuario por teclado
import java.util.Scanner;

public class PrintManager {
    public static void main(String[] args) {
        // Crea una instancia del servicio de impresion
        PrintService servicioImpresion = new PrintService();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            // Solicita al usuario que ingrese su nombre o escriba 'salir' para finalizar
            System.out.println("Ingrese el nombre de usuario (o 'salir' para finalizar): ");
            String usuario = scanner.nextLine();
            if (usuario.equalsIgnoreCase("salir")) {
                break; // Sale del bucle si el usuario escribe 'salir'
            }

            // Solicita la prioridad del trabajo de impresion
            System.out.println("Ingrese la prioridad del trabajo (L - Baja, M - Media, H - Alta) o presione Enter para la prioridad por defecto (M): ");
            String prioridad = scanner.nextLine().toUpperCase();
            
            // Si el usuario no ingresa nada o ingresa un valor invalido, se asigna la prioridad por defecto (M)
            if (prioridad.isEmpty() || (!prioridad.equals("L") && !prioridad.equals("M") && !prioridad.equals("H"))) {
                prioridad = "M";
            }

            // Envía el trabajo de impresion con el usuario, la hora actual y la prioridad asignada
            servicioImpresion.enviarTrabajo(usuario, LocalDateTime.now(), prioridad);
        }
        
        System.out.println("Procesando trabajos en la cola...");
        
        // Procesa los trabajos en la cola hasta que este vacia
        while (!servicioImpresion.estaVacia()) {
            servicioImpresion.procesarTrabajo();
        }
        
        // Cierra el scanner 
        scanner.close();
    }
}

