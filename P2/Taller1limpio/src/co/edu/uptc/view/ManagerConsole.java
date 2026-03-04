package co.edu.uptc.view;

import co.edu.uptc.interfaces.ViewInterface;
import co.edu.uptc.interfaces.PresenterInterface;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ManagerConsole implements ViewInterface {

    private static ManagerConsole instance;

    private PresenterInterface presenter;
    private final Scanner scanner = new Scanner(System.in);
    private final Map<Integer, Runnable> menuActions = new HashMap<>();

    private ManagerConsole() {
        initializeActions();
    }

    public static ManagerConsole getInstance() {
        if (instance == null) {
            instance = new ManagerConsole();
        }
        return instance;
    }

    @Override
    public void setPresenter(PresenterInterface presenter) {
        this.presenter = presenter;
    }

    @Override
    public void start() {
        while (true) {
            showMenu();
            int option = readOption();

            Runnable action = menuActions.get(option);

            if (action != null) {
                action.run();
            } else {
                showError("Opción no válida.");
            }
        }
    }

    private void showMenu() {
        System.out.println("\n--- MENU ---");
        System.out.println("1. Buscar archivo");
        System.out.println("2. Mostrar tamaño total");
        System.out.println("3. Listar directorio (");
        System.out.println("4. Eliminar archivo");
        System.out.println("5. Salir");
        System.out.print("Opción: ");
    }

    private void initializeActions() {

        menuActions.put(1, () -> {
            showMessage("Patrón de búsqueda o nombre del archivo:");
            presenter.searchFile(readInput());
        });

        menuActions.put(2, () ->
                presenter.showTotalSize()
        );

        menuActions.put(3, () -> {
            showMessage("Ruta relativa del directorio:");
            presenter.listDirectory(readInput());
        });

        menuActions.put(4, () -> {
            showMessage("Ruta relativa del archivo a eliminar:");
            presenter.deleteFile(readInput());
        });

        menuActions.put(5, () -> {
            showMessage("Saliendo del programa...");
            System.exit(0);
        });
    }

    @Override
    public void showError(String message) {
        System.err.println("*** ERROR: " + message + " ***");
    }

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }

    @Override
    public String readInput() {
        return scanner.nextLine();
    }

    @Override
    public int readOption() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}