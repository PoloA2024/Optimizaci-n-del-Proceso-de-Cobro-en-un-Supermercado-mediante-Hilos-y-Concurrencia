package supermercado;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Thread> hilos = new ArrayList<>();
        List<Producto> inventario = cargarInventario();

        // Mapa de códigos a nombres de cajeros
        Map<String, String> cajeros = new HashMap<>();
        cajeros.put("001", "Maria Constanza");
        cajeros.put("002", "Andres Felipe Munera");
        cajeros.put("003", "Fernanda Gonzales");
        cajeros.put("004", "Monica Piedrahita");
        cajeros.put("005", "Carlos Perez");

        System.out.println("Bienvenido al SuperMercado J.J.");
        System.out.print("Ingrese el número de clientes a atender: ");
        int numClientes = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea

        for (int i = 1; i <= numClientes; i++) {
            System.out.print("\nIngrese el nombre del cliente " + i + ": ");
            String nombreCliente = scanner.nextLine();

            System.out.println("Escriba los nombres de los productos y sus cantidades. Escriba 'fin' para finalizar:");
            List<Producto> productosSeleccionados = new ArrayList<>();

            while (true) {
                System.out.print("Producto: ");
                String nombreProducto = scanner.nextLine();
                if (nombreProducto.equalsIgnoreCase("fin")) {
                    break;
                }

                Producto producto = buscarProducto(inventario, nombreProducto);
                if (producto != null) {
                    System.out.print("Cantidad: ");
                    int cantidad = scanner.nextInt();
                    scanner.nextLine(); // Consumir la nueva línea
                    producto.setCantidad(cantidad);
                    productosSeleccionados.add(new Producto(producto.getNombre(), producto.getPrecio(), cantidad));
                } else {
                    System.out.println("Producto no encontrado. Intente nuevamente.");
                }
            }

            // Solicitar el código del cajero
            String codigoCajero;
            while (true) {
                System.out.print("Ingrese el código del cajero para esta factura: ");
                codigoCajero = scanner.nextLine();
                if (cajeros.containsKey(codigoCajero)) {
                    break;
                }
                System.out.println("Código no válido. Intente nuevamente.");
            }

            String nombreCajero = cajeros.get(codigoCajero);

            Cliente cliente = new Cliente(nombreCliente, productosSeleccionados);
            Cajera cajera = new Cajera(nombreCajero, cliente); // Constructor ajustado
            Thread hilo = new Thread(cajera);
            hilos.add(hilo);
        }

        System.out.println("\n--- Iniciando el proceso de cobro ---");
        for (Thread hilo : hilos) {
            hilo.start();
        }

        for (Thread hilo : hilos) {
            try {
                hilo.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("\n--- Todos los clientes han sido atendidos. Gracias por su visita. ---");
    }

    private static Producto buscarProducto(List<Producto> inventario, String nombreProducto) {
        for (Producto producto : inventario) {
            if (producto.getNombre().equalsIgnoreCase(nombreProducto)) {
                return producto;
            }
        }
        return null;
    }

    private static List<Producto> cargarInventario() {
        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto("Arroz", 2500, 0));
        productos.add(new Producto("Frijoles", 4500, 0));
        productos.add(new Producto("Lentejas", 3000, 0));
        productos.add(new Producto("Aceite", 12000, 0));
        productos.add(new Producto("Papel higiénico", 15000, 0));
        productos.add(new Producto("Detergente", 18000, 0));
        productos.add(new Producto("Jabón de manos", 4000, 0));
        productos.add(new Producto("Carne de res", 24000, 0));
        productos.add(new Producto("Pollo", 20000, 0));
        productos.add(new Producto("Leche", 4500, 0));
        productos.add(new Producto("Queso", 12000, 0));
        productos.add(new Producto("Pan", 2500, 0));
        productos.add(new Producto("Huevos", 12000, 0));
        productos.add(new Producto("Azúcar", 3000, 0));
        productos.add(new Producto("Sal", 1200, 0));
        productos.add(new Producto("Café", 15000, 0));
        productos.add(new Producto("Chocolate en polvo", 16000, 0));
        productos.add(new Producto("Yogur", 4000, 0));
        productos.add(new Producto("Cereal", 10500, 0));
        productos.add(new Producto("Jugo de naranja", 8000, 0));
        productos.add(new Producto("Soda", 2000, 0));
        productos.add(new Producto("Cerveza", 3500, 0));
        productos.add(new Producto("Vino tinto", 45000, 0));
        productos.add(new Producto("Whisky", 150000, 0));
        productos.add(new Producto("Galletas", 4500, 0));
        productos.add(new Producto("Pastas", 3200, 0));
        productos.add(new Producto("Tomates", 3500, 0));
        productos.add(new Producto("Cebolla", 2400, 0));
        productos.add(new Producto("Papas", 3000, 0));
        productos.add(new Producto("Zanahorias", 2500, 0));
        productos.add(new Producto("Lechuga", 2000, 0));
        productos.add(new Producto("Aguacate", 5000, 0));
        productos.add(new Producto("Manzanas", 8000, 0));
        productos.add(new Producto("Plátanos", 4500, 0));
        productos.add(new Producto("Uvas", 9000, 0));
        productos.add(new Producto("Pescado", 35000, 0));
        productos.add(new Producto("Mariscos", 55000, 0));
        productos.add(new Producto("Helado", 15000, 0));
        productos.add(new Producto("Pizza congelada", 18000, 0));
        productos.add(new Producto("Hamburguesas congeladas", 20000, 0));
        productos.add(new Producto("Salsas", 7000, 0));
        productos.add(new Producto("Mayonesa", 8000, 0));
        productos.add(new Producto("Mostaza", 5000, 0));
        productos.add(new Producto("Ketchup", 5500, 0));
        productos.add(new Producto("Harina", 3200, 0));
        productos.add(new Producto("Mantequilla", 8500, 0));
        productos.add(new Producto("Aceitunas", 14000, 0));
        productos.add(new Producto("Vinagre", 3000, 0));
        productos.add(new Producto("Cremas de leche", 4500, 0));
        productos.add(new Producto("Papel aluminio", 12000, 0));
        productos.add(new Producto("Servilletas", 2500, 0));
        productos.add(new Producto("Fósforos", 1000, 0));
        productos.add(new Producto("Velas", 2000, 0));
        productos.add(new Producto("Detergente líquido", 18500, 0));
        productos.add(new Producto("Suavizante", 16000, 0));
        productos.add(new Producto("Shampoo", 9000, 0));
        productos.add(new Producto("Acondicionador", 9500, 0));
        productos.add(new Producto("Crema dental", 7000, 0));
        productos.add(new Producto("Cepillo dental", 5500, 0));
        productos.add(new Producto("Paños húmedos", 4000, 0));
        return productos;
    }
}