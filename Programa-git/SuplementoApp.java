import java.util.ArrayList;
import java.util.Scanner;

class Suplemento {
    int id;
    String nombre;
    String tipo;
    double precio;

    public Suplemento(int id, String nombre, String tipo, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.precio = precio;
    }
}

public class Main {
    static ArrayList<Suplemento> suplementos = new ArrayList<>();
    static int idActual = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- GESTIÓN DE SUPLEMENTOS DE GIMNASIO ---");
            System.out.println("1. Insertar suplemento");
            System.out.println("2. Consultar suplementos");
            System.out.println("3. Actualizar suplemento");
            System.out.println("4. Eliminar suplemento");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    insertarSuplemento(scanner);
                    break;
                case 2:
                    consultarSuplementos();
                    break;
                case 3:
                    actualizarSuplemento(scanner);
                    break;
                case 4:
                    eliminarSuplemento(scanner);
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    static void insertarSuplemento(Scanner scanner) {
        System.out.print("Nombre del suplemento: ");
        String nombre = scanner.nextLine();
        System.out.print("Tipo del suplemento: ");
        String tipo = scanner.nextLine();
        System.out.print("Precio del suplemento: ");
        double precio = scanner.nextDouble();
        scanner.nextLine();

        Suplemento nuevo = new Suplemento(idActual++, nombre, tipo, precio);
        suplementos.add(nuevo);
        System.out.println("Suplemento añadido con éxito.");
    }

    static void consultarSuplementos() {
        if (suplementos.isEmpty()) {
            System.out.println("No hay suplementos registrados.");
            return;
        }

        System.out.println("\n--- Lista de suplementos ---");
        for (Suplemento s : suplementos) {
            System.out.println("ID: " + s.id + ", Nombre: " + s.nombre + ", Tipo: " + s.tipo + ", Precio: $" + s.precio);
        }
    }

    static void actualizarSuplemento(Scanner scanner) {
        System.out.print("Ingrese el ID del suplemento a actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Suplemento s : suplementos) {
            if (s.id == id) {
                System.out.print("Nuevo nombre: ");
                s.nombre = scanner.nextLine();
                System.out.print("Nuevo tipo: ");
                s.tipo = scanner.nextLine();
                System.out.print("Nuevo precio: ");
                s.precio = scanner.nextDouble();
                scanner.nextLine();
                System.out.println("Suplemento actualizado.");
                return;
            }
        }

        System.out.println("Suplemento no encontrado.");
    }

    static void eliminarSuplemento(Scanner scanner) {
        System.out.print("Ingrese el ID del suplemento a eliminar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        suplementos.removeIf(s -> s.id == id);
        System.out.println("Suplemento eliminado si existía.");
    }
}