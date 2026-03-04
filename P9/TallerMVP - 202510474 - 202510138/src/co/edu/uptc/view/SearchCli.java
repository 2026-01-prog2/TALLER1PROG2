package co.edu.uptc.view;

import java.util.Scanner;

public class SearchCli {
    Scanner scan = new Scanner(System.in);
    String name = "";

    public String showData(){
        System.out.println("Por favor digite el nombre del archivo a buscar: ");
        askName();
        return name;
    }

    public String showRequest(){
        System.out.println("Por favor digite la ruta de la carpeta o archivo a buscar: ");
        askName();
        return name;
    }

    public String askFileToDelete(){
        System.out.println("Por favor digite en nombre del archivo a eliminar (DEBE SER EL NOMBRE EXACTO CON SU EXTENSIÓN): ");
        askName();
        return name;
    }

    private void askName() {
        name = scan.nextLine();
    }
}
