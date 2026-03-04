package co.edu.uptc.view;

import java.io.File;
import java.util.Scanner;

public class SearchFileCli {
    private Scanner input = new Scanner(System.in);

    public void exec(){
        System.out.println("Ingrese el nombre del archivo que desea buscar: ");
        String name = input.nextLine();
        File file = ConsoleView.getInstance().presenter.searchFile(name);
        if(file!=null){
            System.out.println("Archivo encontrado!!: "+file.getName());
        }else{
            System.out.println("Archivo no encontrado");
        }
    }
}
