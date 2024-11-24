package supermercado;

import java.util.List;
import java.util.Random;

public class Cliente {
    private String nombre;
    private List<Producto> productos;

    public Cliente(String nombre, List<Producto> productos) {
        this.nombre = nombre;
        this.productos = productos;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public double calcularTotalSinIVA() {
        return productos.stream()
                .mapToDouble(Producto::calcularSubtotal)
                .sum();
    }

    public double calcularIVA() {
        return calcularTotalSinIVA() * 0.19;
    }

    public double calcularTotalConIVA() {
        return calcularTotalSinIVA() + calcularIVA();
    }

    public void mostrarFactura() {
        // Generar un número de factura aleatorio
        String numeroFactura = generarNumeroFactura();

        System.out.println("Factura N.º: " + numeroFactura);
        System.out.println("Cliente: " + nombre);
        System.out.println("----------------------------------------------------------------");
        productos.forEach(producto -> System.out.println(
                "Producto: " + producto.getNombre() +
                        ", Precio: " + producto.getPrecio() +
                        ", Cantidad: " + producto.getCantidad() +
                        ", Subtotal: " + producto.calcularSubtotal()
        ));
        System.out.println("----------------------------------------------------------------");
        System.out.println("Total sin IVA: $" + calcularTotalSinIVA());
        System.out.println("IVA (19%): $" + calcularIVA());
        System.out.println("Total con IVA: $" + calcularTotalConIVA());
        System.out.println("----------------------------------------------------------------");
    }

    private String generarNumeroFactura() {
        Random random = new Random();
        // Generar un número de 6 dígitos (por ejemplo, entre 100000 y 999999)
        int numero = 100000 + random.nextInt(900000);
        return String.valueOf(numero);
    }
}