package co.edu.uptc.view;

import java.util.Scanner;

public class MenuActions {
    private Scanner scanner;

    public MenuActions(){
        this.scanner = new Scanner(System.in);
    }

    protected void readInfo(String name, String path){
        String info = ConsoleView.getInstance().showArchiveInformation(path+"\\"+name);
        System.out.println(info);
        if(!info.isEmpty()){
            System.out.println("Desea eliminar el archivo/carpeta? (si/no)");
            String delete = scanner.nextLine();
            deleteInput(delete);
            if (delete.equalsIgnoreCase("si")) System.out.println(ConsoleView.getInstance().deleteFile(path+"\\"+name));
        }
    }

    protected void deleteInput(String input){
        while (!input.equalsIgnoreCase("si") &&!input.equalsIgnoreCase("no")) { 
            ConsoleView.getInstance().showError("Ingrese solo 'si'/'no'");
            System.out.println("Desea eliminar el archivo/carpeta? (si/no)");
            input = scanner.nextLine();
        }
    }
}
