package co.edu.uptc.view;

import java.util.Scanner;

public class MenuCli {
    Scanner scan = new Scanner(System.in);
    ConsoleView consoleView = ConsoleView.getInstance();
    private int option = 0;

    private void showMenu() {
            System.out.println("========================================");
            System.out.println("             Bienvenido/a");
            System.out.println("========================================");
            System.out.println("Selecciona una opción: ");
            System.out.println("1. Listar directorio");
            System.out.println("2. Buscar archivo");
            System.out.println("3. Tamaño de la carpeta o archivo");
            System.out.println("4. Borrar archivo");
            System.out.println("5. Salir");
    }

    public int start() {
        do {
            showMenu();
            System.out.print("Digite la opción: ");
            readInt();
            validateOption();
        }
        while (!(option > 0 && option < 6));

        return option;
    }

    private void validateOption() {
        if (option < 1 || option > 5) {
            consoleView.showError("Opcion no disponible");
        }
    }


    private void readInt() {
        try {
            option = Integer.parseInt(scan.nextLine());
        } catch (NumberFormatException e) {
            consoleView.showError("Por favor digite solo numeros");
        }
    }

}