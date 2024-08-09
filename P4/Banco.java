package P4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Banco {
    private Map<String, Cuenta> cuentas;
    private Scanner scanner;

    public Banco() {
        cuentas = new HashMap<>();
        scanner = new Scanner(System.in);
    }

    public void crearCuenta() {
        System.out.print("Ingrese el nombre del titular: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese el saldo inicial: ");
        double saldo = scanner.nextDouble();
        scanner.nextLine(); // Consumir el salto de línea

        System.out.print("Ingrese un PIN para la cuenta: ");
        String pin = scanner.nextLine();

        Cuenta cuenta = new Cuenta(nombre, saldo, pin);
        cuentas.put(pin, cuenta);

        System.out.println("Cuenta creada exitosamente.");
    }

    public void accederCuenta() {
        System.out.print("Ingrese su PIN: ");
        String pin = scanner.nextLine();

        Cuenta cuenta = cuentas.get(pin);
        if (cuenta == null) {
            System.out.println("PIN incorrecto.");
            return;
        }

        while (true) {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Depositar");
            System.out.println("3. Retirar");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    System.out.println("Saldo actual: $" + cuenta.obtenerSaldo());
                    break;
                case 2:
                    System.out.print("Ingrese el monto a depositar: ");
                    double deposito = scanner.nextDouble();
                    scanner.nextLine(); // Consumir el salto de línea
                    cuenta.depositar(deposito);
                    System.out.println("Depósito realizado con éxito.");
                    break;
                case 3:
                    System.out.print("Ingrese el monto a retirar: ");
                    double retiro = scanner.nextDouble();
                    scanner.nextLine(); // Consumir el salto de línea
                    if (cuenta.retirar(retiro)) {
                        System.out.println("Retiro realizado con éxito.");
                    }
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        Banco banco = new Banco();

        while (true) {
            System.out.println("\n--- Banco ---");
            System.out.println("1. Crear nueva cuenta");
            System.out.println("2. Acceder a cuenta existente");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            @SuppressWarnings("resource")
            Scanner scanner = new Scanner(System.in);
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    banco.crearCuenta();
                    break;
                case 2:
                    banco.accederCuenta();
                    break;
                case 3:
                    System.out.println("Saliendo del sistema.");
                    return;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }
}