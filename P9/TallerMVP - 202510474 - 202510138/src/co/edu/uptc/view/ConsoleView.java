package co.edu.uptc.view;

import co.edu.uptc.interfaces.PresenterInterface;
import co.edu.uptc.interfaces.ViewInterface;

import java.util.*;


public class ConsoleView implements ViewInterface {
    
    PresenterInterface presenter;

    private Map<Integer,Runnable> menuActions = new HashMap<>();
    private static ConsoleView instance = null;

    private ConsoleView() {
        fillActions();
    }

    public static ConsoleView getInstance() {
        if (instance == null){
            instance = new ConsoleView();
            }
        return instance;
    }


    @Override
    public void setPresenter(PresenterInterface presenter) {
        this.presenter = presenter;
    }

    @Override
    public void start() {
        MenuCli menuCli = new MenuCli();
        while (true) {
            int option = menuCli.start();
            if (menuActions.containsKey(option)) {
                menuActions.get(option).run();
            }

        }
    }

    private void fillActions(){
        menuActions.put(1, ()->listDirectory());
        menuActions.put(2,()->searchFile());
        menuActions.put(3,()->calculateSize());
        menuActions.put(4, ()->deleteFile());
        menuActions.put(5,()->System.exit(0));
    }

    private void deleteFile() {
        SearchCli searchCli = new SearchCli();
        String name = searchCli.askFileToDelete();
        presenter.deleteFile(name);
    }

    private void searchFile() {
        SearchCli searchCli = new SearchCli();
        String name = searchCli.showData();
        presenter.searchFile(name);
    }

    private void listDirectory() {

        presenter.listDirectory();
    }

    private void calculateSize() {
        SearchCli searchCli = new SearchCli();
        String path = searchCli.showRequest();
        presenter.calculateSize(path);
    }

    public void showList(List<String> totalList){
        for(String element : totalList){
            System.out.println(element);
        }
    }
    public void showError(String message) {
        System.err.println("*******************************************");
        System.err.println(message);
        System.err.println("*******************************************");
    }


    public void showMessage(String message) {
        System.out.println(message);
    }

}