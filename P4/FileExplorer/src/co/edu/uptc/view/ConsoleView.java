package co.edu.uptc.view;

import java.util.HashMap;
import java.util.Scanner;

import co.edu.uptc.interfaces.PresenterInterface;
import co.edu.uptc.interfaces.ViewInterface;

public class ConsoleView implements ViewInterface {
    PresenterInterface presenter;

    private HashMap <Integer, Runnable> MenuOptions = new HashMap();
    private static ConsoleView instance;

    @Override
    public void setPresenter(PresenterInterface presenter) {
        this.presenter = presenter;
    }

    public static ConsoleView getInstance(){
        if(instance == null)
            instance = new ConsoleView();
        return instance;
    }

    @Override
    public void start() {
        MenuCli menuCli = new MenuCli();
        setActions();
        while(true){
            int option = menuCli.start();
            if(MenuOptions.containsKey(option)){
                MenuOptions.get(option).run();
            }
        }
    }

    public void setActions(){
        MenuOptions.put(1, ()-> searchFile());
        MenuOptions.put(2, ()-> showFileDirectory());
        MenuOptions.put(3,()-> listDirectory());
        MenuOptions.put(4, ()-> deleteFile());
        MenuOptions.put(5, ()-> System.exit(0));
    }

    public void searchFile(){
        SearchFileCli object = new SearchFileCli();
        object.exec();
    }

    public void showFileDirectory(){
        ShowDirectorySizeCli object = new ShowDirectorySizeCli();
        object.exec();
    }

    public void listDirectory(){
        ListDirectoryCli object = new ListDirectoryCli();
        object.exec();
    }

    public void deleteFile(){
        DeleteFileCli object = new DeleteFileCli();
        object.exec();
    }
}