package co.edu.uptc.view;

import co.edu.uptc.interfaces.PresenterInterface;
import co.edu.uptc.interfaces.ViewInterface;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConsoleView implements ViewInterface {
    Scanner keyboard = new Scanner(System.in);
    PresenterInterface presenter;
    private Map<Integer,Runnable> menuActions = new HashMap<>();
    private static ConsoleView instance = null;

    private ConsoleView() {
    }

    public static ConsoleView getInstance() {
        if (instance == null)
            instance = new ConsoleView();
        return instance;
    }

    @Override
    public void setPresenter(PresenterInterface presenter) {
        this.presenter = presenter;
    }

    @Override
    public void start() {
        CLIMenu ClientMenu = new CLIMenu();
        while (true) {
            fillActions();
            int option = ClientMenu.start();
            if (menuActions.containsKey(option)) {
                menuActions.get(option).run();
            }

        }
    }

    private void fillActions(){
       menuActions.put(1, ()->actionOption1());
        menuActions.put(2,()->actionOption2());
        menuActions.put(3,()->actionOption3());
        menuActions.put(4,()->actionOption4());
        menuActions.put(5,()->System.exit(0));
    }

    private void actionOption1() {
        showInfo("Usted seleccionó buscar un archivo");
        CLISearch cliSearch = new CLISearch();
        cliSearch.showFileData();
    }

    private void actionOption2() {
        showInfo("Usted seleccionó listar el contenido de un directorio");
        CLIDirectory cliDirectory = new CLIDirectory();
        cliDirectory.showDirectorySize();
    }

    private void actionOption3() {
        showInfo("Usted seleccionó listar la información de un directorio: ");
        CLISearch cliSearch = new CLISearch();
        cliSearch.showDirectoryData();
    }

    private void actionOption4(){
        showInfo("Usted seleccionó eliminar un archivo: ");
        CLIDeletion cliDeletion = new CLIDeletion();
        cliDeletion.confirmDeletion();
    }

    public void showError(String message) {
        System.err.println("-------------------------------------------");
        System.err.println(message);
        System.err.println("-------------------------------------------");
    }

    public void showInfo(String message){
        System.out.println(message);
    }
    public String writeInfo(String message){
        System.out.println(message);
        return keyboard.nextLine();
    }

}