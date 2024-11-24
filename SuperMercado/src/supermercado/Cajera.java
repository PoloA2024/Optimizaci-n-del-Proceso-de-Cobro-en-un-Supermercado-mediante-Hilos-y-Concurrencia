package supermercado;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Cajera implements Runnable {
    private String nombre;
    private Cliente cliente;

    public Cajera(String nombre, Cliente cliente) {
        this.nombre = nombre;
        this.cliente = cliente;
    }

    @Override
    public void run() {
        long inicio = System.currentTimeMillis();

        // Obtener la fecha y hora actual
        LocalDateTime fechaHoraActual = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String fechaHoraFormateada = fechaHoraActual.format(formato);

        synchronized (System.out) {
            System.out.println("================================================================");
            System.out.println("Auto Servicio J.J");
            System.out.println("Telefono: 3450000899");
            // Mostrar la fecha y hora de facturación
            System.out.println("Fecha y hora de la facturación: " + fechaHoraFormateada);
            System.out.println("NIT: 903456784");
            System.out.println("================================================================");
            System.out.println(); // Salto de línea adicional para separar facturas
            System.out.println(); // Salto de línea adicional para separar facturas
            System.out.println("================================================================");
            System.out.println("Cajera: " + nombre);
            cliente.mostrarFactura();
            long fin = System.currentTimeMillis();
            System.out.println("Tiempo total de facturación: " + (fin - inicio) + " segundos");
            System.out.println("================================================================");
            System.out.println("Agradecemos por su compra");
            System.out.println("================================================================");
            System.out.println(); // Salto de línea adicional para separar facturas
            System.out.println(); // Salto de línea adicional para separar facturas
            System.out.println(); // Salto de línea adicional
            System.out.println(); // Salto de línea adicional para separar facturas
        }
    }
}