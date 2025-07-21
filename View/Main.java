package View;

import java.util.Date;
import java.util.List;
import java.util.Scanner;
import Controllers.EmployeController;
import Model.Employee;
import Model.Administrator;
import Model.Electrician;
import Model.Technical;

public class Main {

    private static EmployeController controller = new EmployeController();

    public static void main(String[] args) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(System.in);
            boolean running = true;
            while (running) {
                showMenu();
                String choice = scanner.nextLine();

                switch (choice) {
                    case "1":
                        addEmployee(scanner);
                        break;
                    case "2":
                        listEmployees();
                        break;
                    case "3":
                        updateEmployee(scanner);
                        break;
                    case "4":
                        deleteEmployee(scanner);
                        break;
                    case "5":
                        running = false;
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, intente de nuevo.");
                }
            }
        } catch (Exception e) {
            System.out.println("Error en el programa: " + e.getMessage());
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    private static void showMenu() {
        System.out.println("\n=== Sistema de Gestión de Empleados ===");
        System.out.println("1. Agregar Empleado");
        System.out.println("2. Listar Empleados");
        System.out.println("3. Actualizar Empleado");
        System.out.println("4. Eliminar Empleado");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void addEmployee(Scanner scanner) {
        System.out.println("\n=== Agregar Empleado ===");
        System.out.print("ID del empleado: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Nombre: ");
        String name = scanner.nextLine();
        System.out.print("Salario: ");
        double salary = Double.parseDouble(scanner.nextLine());

        try {
            System.out.println("\nTipo de empleado:");
            System.out.println("1. Administrador");
            System.out.println("2. Electricista");
            System.out.println("3. Técnico");
            System.out.print("Seleccione tipo: ");
            int type = Integer.parseInt(scanner.nextLine());

            Employee employee;
            switch (type) {
                case 1:
                    System.out.print("Nivel de acceso: ");
                    String accessLevel = scanner.nextLine();
                    employee = new Administrator(id, name, salary, new Date(), accessLevel);
                    break;
                case 2:
                    System.out.print("Especialidad: ");
                    String specialty = scanner.nextLine();
                    employee = new Electrician(id, name, salary, new Date(), specialty);
                    break;
                case 3:
                    System.out.print("Área técnica: ");
                    String technicalArea = scanner.nextLine();
                    employee = new Technical(id, name, salary, new Date(), technicalArea);
                    break;
                default:
                    System.out.println("Tipo no válido");
                    return;
            }

            controller.addEmployee(employee);
            System.out.println("Empleado agregado exitosamente!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void listEmployees() {
        System.out.println("\n=== Lista de Empleados ===");
        try {
            List<Employee> employees = controller.readEmployees();
            if (employees.isEmpty()) {
                System.out.println("No hay empleados registrados.");
                return;
            }

            for (Employee e : employees) {
                System.out.println(e);
            }
        } catch (Exception e) {
            System.out.println("Error al listar empleados: " + e.getMessage());
        }
    }

    private static void updateEmployee(Scanner scanner) {
        System.out.println("\n=== Actualizar Empleado ===");
        System.out.print("Ingrese ID del empleado a actualizar: ");
        int id = Integer.parseInt(scanner.nextLine());

        try {
            System.out.print("Nuevo nombre: ");
            String name = scanner.nextLine();
            System.out.print("Nuevo salario: ");
            double salary = Double.parseDouble(scanner.nextLine());

            Employee updatedEmployee = null;
            try {
                // Obtener el empleado existente para mantener su tipo
                Employee existingEmployee = controller.readEmployees().stream()
                        .filter(e -> e.getWorkerId().equals(id))
                        .findFirst()
                        .orElseThrow(() -> new Exception("Empleado no encontrado"));

                // Crear una nueva instancia del mismo tipo
                if (existingEmployee instanceof Administrator) {
                    updatedEmployee = new Administrator(id, name, salary, new Date(),
                            ((Administrator) existingEmployee).getAccessLevel());
                } else if (existingEmployee instanceof Electrician) {
                    updatedEmployee = new Electrician(id, name, salary, new Date(),
                            ((Electrician) existingEmployee).getElectricalCertification());
                } else if (existingEmployee instanceof Technical) {
                    updatedEmployee = new Technical(id, name, salary, new Date(),
                            ((Technical) existingEmployee).getSpecializedArea());
                } else {
                    throw new Exception("Tipo de empleado no soportado");
                }
            } catch (Exception e) {
                System.out.println("Error al obtener el empleado existente: " + e.getMessage());
                return;
            }
            controller.updateEmployeeById(updatedEmployee, id);
            System.out.println("Empleado actualizado exitosamente!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void deleteEmployee(Scanner scanner) {
        System.out.println("\n=== Eliminar Empleado ===");
        System.out.print("Ingrese ID del empleado a eliminar: ");
        int id = Integer.parseInt(scanner.nextLine());

        try {
            controller.deleteEmployeeById(id);
            System.out.println("Empleado eliminado exitosamente!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
