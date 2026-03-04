package co.edu.uptc.view;

import co.edu.uptc.interfaces.PresenterInterface;
import co.edu.uptc.interfaces.ViewInterface;

import java.util.Scanner;



public class ConsoleView implements ViewInterface {
    private PresenterInterface presenter;
    private Scanner sc  = new Scanner(System.in);

    @Override
    public void setPresenter(PresenterInterface presenter) {
        this.presenter = presenter;
    }

    @Override
    public void start() {
        short option = 0;
        do {
            option = showMenu();
            evaluateOption(option);
        } while (option !=5);
    }

    private short showMenu()throws NumberFormatException{
        try {
            System.out.print(menu());
            return Short.parseShort(sc.nextLine());
        } catch (NumberFormatException e) {
            showInformation("¡Error! Por favor ingrese solo números del 1 al 5.");
            return 0;
        }
    }

    private String menu(){
        StringBuilder menu = new StringBuilder();
        menu.append("\n-----MENU-----" );
        menu.append("\n1. Ingrese el nombre del archivo que desea buscar" );
        menu.append("\n2. Mostrar el tamaño total de la carpeta" );
        menu.append("\n3. Ingrese el nombre de la carpeta que desea enlistar" );
        menu.append("\n4. Ingrese el nombre del archivo que desea borrar" );
        menu.append("\n5. Salir" );
        menu.append("\nSeleccione una opcion: ");
        return menu.toString();
    }

    private void evaluateOption(short option){
        switch (option) {
            case 1:
                searchFile();
                break;
                
            case 2:
                folderSize();
                break;

            case 3:
                listDirectory();
                break;

            case 4:
                deleteFilePermanent();
                break;

            case 5:
                showInformation("Saliendo del programa...");
                break;
            default:
                showInformation("Por favor ingrese un numero entre 1 y 5");
                break;
        }
    }

    private void showInformation (String mensaje) {
        System.out.println(mensaje);
    }

    private void searchFile(){
        showInformation("Digite el nombre del archivo que desea analizar: ");
        String fileName = sc.nextLine();
        String result = presenter.search(fileName);
        if (result.equals("")) {
            showInformation("El archivo llamado " + fileName + ", no se ha encontrado");
        }else{
            showInformation(result);
        }
    }

    private void folderSize(){
        String result = "La carpeta inicial tiene un tamaño de: (" + presenter.getfolderSize(presenter.getInitialRoute()) + " bytes)";
        showInformation(result);
    }

    private void listDirectory(){
        String result = "La carpeta inicial enlistada: " + presenter.listDirectory();
        showInformation(result);
    }

    private void deleteFilePermanent(){
        showInformation("Digite el nombre del archivo que desea eliminar: ");
        String fileName = sc.nextLine();

        showInformation("¿Esta seguro que quiere eliminar el archivo: " + fileName + "? (S/N)");
        String answer = sc.nextLine();

        if (answer.equalsIgnoreCase("S")) {
            presenter.deleteFile(fileName);
            showInformation("El archivo: " + fileName + " ha sido borrado con exitó");
        }else if(answer.equalsIgnoreCase("N")){
            showInformation("No se elimino el archivo" + fileName + " correctamente");
        }else{
            showInformation("Digite una letra valida, (S/N)");
        }
    }
}
