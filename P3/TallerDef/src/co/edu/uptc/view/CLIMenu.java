package co.edu.uptc.view;

public class CLIMenu {
    private int option = 0;

    private void showMenu() {
        System.out.println("1. Buscar archivos\n2. Mostrar tamaño del directorio\n3. Listar información de un directorio\n4. Eliminar un archivo\n5. Salir");
    }

    public int start() {
        do {
            showMenu();
            readInt();
            validateOption();
        }
        while (!(option > 0 && option < 5));

        return option;
    }

    private void validateOption() {
        if (option < 1 || option > 4) {
            showError("Opcion no disponible");
        }
    }


    private void readInt() {
        try {
            option = Integer.parseInt(ConsoleView.getInstance().writeInfo("Opción:"));
        } catch (NumberFormatException e) {
            showError(" Solo numeros");
        }
    }


    public void showError(String message) {
        System.err.println("---------------");
        System.err.println(message);
        System.err.println("---------------");
    }

}