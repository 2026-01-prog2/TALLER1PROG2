package co.edu.uptc.view;

import java.util.Scanner;

public class MenuCli {
    private int option;
    private Scanner input = new Scanner(System.in);

    public int start(){
        do{
            showMenu();
            readInt();
            validateOption();
        }while(option<0 || option>5 );
        return option;
    }

    private void showMenu(){
        System.out.println("-----------MENÚ-------------");
        System.out.println("------------------------");
        System.out.println("1. Buscar archivo");
        System.out.println("2. Consultar tamaño del directorio");
        System.out.println("3. Listar Directorio");
        System.out.println("4. Borrar archivo");
        System.out.println("5. Salir");
    }

    private void readInt(){
        try{
            option = input.nextInt();
        }catch(NumberFormatException e){
            System.err.println("Solo ingrese números");
        }
    }

    private void validateOption(){
        if(option<1 || option>5){
            System.err.println("---------------------");
            System.err.println("Opción no válida");
            System.err.println("---------------------");
        }
    }


}
