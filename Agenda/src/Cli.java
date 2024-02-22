import java.util.ArrayList;
import java.util.Scanner;

public class Cli {
    private static Scanner scanner = new Scanner(System.in);
    private static Menu taskManager = new Menu();

    public static void main(String[] args) {
        while (true) {
            printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    markTaskAsCompleted();
                    break;
                case 3:
                    markTaskAsExpired();
                    break;
                case 4:
                    removeTask();
                    break;
                case 5:
                    printTasksInProgress();
                    break;
                case 6:
                    printCompletedTasks();
                    break;
                case 7:
                    System.out.println("Saliendo...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("===== Menú =====");
        System.out.println("1. Agregar tarea");
        System.out.println("2. Marcar tarea como completada");
        System.out.println("3. Marcar tarea como vencida");
        System.out.println("4. Eliminar tarea");
        System.out.println("5. Mostrar tareas en curso");
        System.out.println("6. Mostrar tareas completadas");
        System.out.println("7. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void addTask() {
        System.out.print("Ingrese la descripción de la tarea: ");
        String description = scanner.nextLine();
        Main task = new Main(description);
        taskManager.addTask(task);
        System.out.println("Tarea agregada correctamente.");
    }

    private static void markTaskAsCompleted() {
        System.out.print("Ingrese el índice de la tarea a marcar como completada: ");
        int index = scanner.nextInt();
        taskManager.markTaskAsCompleted(index);
        System.out.println("Tarea marcada como completada correctamente.");
    }

    private static void markTaskAsExpired() {
        System.out.print("Ingrese el índice de la tarea a marcar como vencida: ");
        int index = scanner.nextInt();
        taskManager.markTaskAsExpired(index);
        System.out.println("Tarea marcada como vencida correctamente.");
    }

    private static void removeTask() {
        System.out.print("Ingrese el índice de la tarea a eliminar: ");
        int index = scanner.nextInt();
        taskManager.removeTask(index);
        System.out.println("Tarea eliminada correctamente.");
    }

    private static void printTasksInProgress() {
        System.out.println("===== Tareas en Curso =====");
        ArrayList<Main> tasks = taskManager.getTasks();
        for (int i = 0; i < tasks.size(); i++) {
            Main task = tasks.get(i);
            if (!task.isCompleted() && !task.isExpired()) {
                System.out.println((i + 1) + ". " + task.getDescription());
            }
        }
    }

    private static void printCompletedTasks() {
        System.out.println("===== Tareas Completadas =====");
        ArrayList<Main> tasks = taskManager.getTasks();
        for (int i = 0; i < tasks.size(); i++) {
            Main task = tasks.get(i);
            if (task.isCompleted()) {
                System.out.println((i + 1) + ". " + task.getDescription());
            }
        }
    }
}



