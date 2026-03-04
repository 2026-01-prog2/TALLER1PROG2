package co.edu.uptc.view;

import java.util.Scanner;

public class Menu {
     Scanner keyboard = new Scanner(System.in);
    private int option = 0;


    private void showMenu(){
        System.out.println("\n--- MENÚ ---");
        System.out.println("1. Mostrar elementos");
        System.out.println("2. Buscar");
        System.out.println("3. Ingresar en carpeta");
        System.out.println("4. Tamaño total carpeta");
        System.out.println("5. Eliminar archivo");
        System.out.println("6. Salir");
    }
    
    public int start(){
         do {
            showMenu();
            System.out.println("Opcion: ");
            readInt();
        }
        while (!(option > 0 && option < 7));
        return option;
    }

    private void readInt() {
            try {
             option = Integer.parseInt(keyboard.nextLine());
             if (option < 1 || option > 6) {
            showError("Opcion no disponible");
            }
           } catch (NumberFormatException e) {
        showError("Solo numeros");
            option=0;
            } 
    }

    public void showError(String message){
        System.err.println("---------------");
        System.err.println(message);
        System.err.println("---------------");
    }
}
