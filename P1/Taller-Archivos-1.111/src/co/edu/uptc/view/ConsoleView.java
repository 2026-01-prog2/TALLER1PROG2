package co.edu.uptc.view;

import co.edu.uptc.interfaces.PresenterInterface;
import co.edu.uptc.interfaces.ViewInterface;

import java.util.Scanner;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConsoleView implements ViewInterface {
    Scanner keyboard = new Scanner(System.in);
    private String initialRouteW="";
    PresenterInterface presenter;
     private Map<Integer,Runnable> menuActions = new HashMap<>();
     public ConsoleView() {
        fillActions();
        
    }
    public void setPresenter(PresenterInterface presenter) {
    this.presenter = presenter;
}
   public void showMenu(String initialRoute){
    initialRouteW=initialRoute;
        Menu menuCli = new Menu();
        while (true) {
            int option = menuCli.start();
            if (menuActions.containsKey(option)) {
                menuActions.get(option).run();
            }
            
        }
    }
    private void fillActions(){
        menuActions.put(1, ()->acctionOption1());
         menuActions.put(2,()->acctionOption2());
        menuActions.put(3,()->acctionOption3());
        menuActions.put(4,()->acctionOption4());
        menuActions.put(5,()->acctionOption5());
        menuActions.put(6,()->System.exit(0)); 
    }
    private void acctionOption1() {
        showMessage("Elementos en la ruta actual:");
        showResults(presenter.acctionOption1(initialRouteW));
    }
     private void acctionOption2() {
    String name =read("Digite el nombre del archivo o carpeta");
        showResults(presenter.acctionOption2(initialRouteW,name));
    }
     private void acctionOption3() {
        
        showMessage("Elementos en la ruta actual:");
        showResults(presenter.acctionOption3(initialRouteW));
    }
     private void acctionOption4() {
        showMessage("Tamaño total: " + presenter.acctionOption4(initialRouteW) + " bytes");
    }
     private void acctionOption5() {
        String routeToDelete = read("Ruta completa a borrar");
        if (presenter.acctionOption5(routeToDelete)) {
                            showMessage("¡Borrado!");
                        } else {
                            showMessage("No se pudo borrar.");
                        }
    }
     @Override
    public String read(String message) {
        System.out.print(message + ": ");
        return keyboard.nextLine();
    }

    @Override
    public String read() {
        return keyboard.nextLine();
    }

    @Override
    public int readInt(String message) {
        System.out.print(message + ": ");
        return Integer.parseInt(keyboard.nextLine());
           
    } 

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }
    private void showResults(List<String> results) {

        if (results.isEmpty()) {
            showMessage("No se encontraron archivos.");
        } else {
            for (String result : results) {
                showMessage(result);
            }
        }
    }

    /* provate void fillActions(){
     menuActions.put}
    
    private Map<integer, Runnable> menuActions = new HasMap<>() */
}