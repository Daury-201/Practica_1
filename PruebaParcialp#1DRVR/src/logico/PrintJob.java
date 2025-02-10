package logico;

import java.time.LocalDateTime;

public class PrintJob implements Comparable<PrintJob> {
    // Atributos de un trabajo de impresi�n
    private String usuario;
    private LocalDateTime horaEnvio;
    private String prioridad;

    // Constructor que inicializa el trabajo de impresi�n con usuario, hora y prioridad
    public PrintJob(String usuario, LocalDateTime horaEnvio, String prioridad) {
        this.usuario = usuario;
        this.horaEnvio = horaEnvio;
        this.prioridad = (prioridad != null) ? prioridad : "M"; // Prioridad por defecto "M" si es nula
    }

    // Metodos para obtener los valores de los atributos
    public String getUsuario() {
        return usuario;
    }

    public LocalDateTime getHoraEnvio() {
        return horaEnvio;
    }

    public String getPrioridad() {
        return prioridad;
    }

    // Metodo para comparar trabajos de impresi�n seg�n prioridad y hora de envio
    @Override
    public int compareTo(PrintJob otro) {
        if (!this.prioridad.equals(otro.prioridad)) {
            return this.prioridad.compareTo(otro.prioridad);
        }
        return this.horaEnvio.compareTo(otro.horaEnvio);
    }

    // Representacion en texto de un trabajo de impresion
    @Override
    public String toString() {
        return "PrintJob{Usuario='" + usuario + "', Hora de Env�o=" + horaEnvio + ", Prioridad=" + prioridad + '}';
    }
}

