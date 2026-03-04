package co.edu.uptc.view;
import java.util.Scanner;
public class MenuCLI {
    Scanner scanner;
    MenuActions actions;
    private ConsoleView consoleView;

    public MenuCLI(ConsoleView consoleView){
        this.scanner = new Scanner(System.in);
        this.actions = new MenuActions();
        this.consoleView = consoleView;
    }

    protected void showMenu(){
        System.out.println("BUSCADOR DE ARCHIVOS" + '\n'+"--------------------------------");
        System.out.println("Escriba 'salir' para salir del programa, o presione enter para seguir: ");
    }

    protected void newArchive(){
        System.out.println("Ingrese el nombre del archivo o carpeta a buscar: ");
        actions.readInfo(scanner.nextLine(), consoleView.presenter.getPath());
    }
}
