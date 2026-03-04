package co.edu.uptc.view;
import co.edu.uptc.interfaces.PresenterInterface;
import co.edu.uptc.interfaces.ViewInterface;
import java.util.Scanner;

public class ConsoleView implements ViewInterface {
    PresenterInterface presenter;
    MenuCLI menu;
    Scanner scanner;
    boolean running;
    private static ConsoleView  instance = null;

    private ConsoleView(){
        this.scanner = new Scanner(System.in);
        this.running = true;
        this.menu = new MenuCLI(this);
    }

    public static ConsoleView getInstance(){
        if (instance==null)
            instance = new ConsoleView();
        return instance;
    }
    
    @Override
    public void setPresenter(PresenterInterface presenter) {
       this.presenter = presenter;
    }

    @Override
    public void showError(String message) {
        System.err.println("Error: " + message);
    }

    @Override
    public String showArchiveInformation(String path) {
        return presenter.showFileInfo(path);
    }

    public String deleteFile(String name){
        return presenter.deleteFile(name);
    }

    @Override
    public void start(String[] args) {
            presenter.setPath(args[0]);
                while (running){
                    menu.showMenu();
                    String exit = scanner.nextLine();
                    exitChecker(exit);
                }
    }

    private void exitChecker(String exit){
        try {
            if (!exit.equalsIgnoreCase("salir") && !exit.equals("")) throw new Exception("Opcion no valida");
            else if (exit.equalsIgnoreCase("salir")){
                System.out.println("Saliendo del programa...");
                running = false;
            }else menu.newArchive();            
        } catch (Exception e) {
            showError(e.getMessage());
        }
    }
    
}
