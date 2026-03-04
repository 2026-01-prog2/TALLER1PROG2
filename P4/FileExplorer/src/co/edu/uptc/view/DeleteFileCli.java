package co.edu.uptc.view;

import java.io.File;
import java.util.Scanner;

public class DeleteFileCli {
    private Scanner input = new Scanner(System.in);
    private int option;
    private boolean fileExists;
    private String path;

    public void exec() {
        while (option != 1 || option != 2) {
            askFile();
            if (fileExists) {
                showConfirmMessage();
                readInt();
                validateOption();
                finalOperation();
            }
        }
    }

    private void askFile() {
        System.out.println("Ingrese el nombre del archivo a eliminar");
        String name = input.nextLine();
        File file = ConsoleView.getInstance().presenter.searchFile(name);
        if( file != null){
            fileExists = true;
            path = file.getAbsolutePath();
        }else{
            fileExists = false;
        }

    }

    private void showConfirmMessage() {
        System.out.println("Confirmar acción - Eliminar archivo");
        System.out.println("1 - Sí");
        System.out.println("2 - No");
    }

    private void readInt() {
        try {
            System.out.println("Opción: ");
            option = input.nextInt();
        } catch (NumberFormatException e) {
            System.err.println("Valor ingresado no válido. Ingrese solo números por favor");
        }
    }

    private void validateOption() {
        if (option != 1 || option != 2) {
            System.err.println("Opción no válida.");
        }
    }

    private void finalOperation(){
        if(option == 1){
            ConsoleView.getInstance().presenter.deleteFile(path);
        }else if(option == 2){
            System.out.println("Operación cancelada");
        }
    }
}
