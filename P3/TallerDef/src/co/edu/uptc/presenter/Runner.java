package co.edu.uptc.presenter;

import co.edu.uptc.interfaces.ModelInterface;
import co.edu.uptc.interfaces.PresenterInterface;
import co.edu.uptc.interfaces.ViewInterface;
import co.edu.uptc.model.ModelManager;
import co.edu.uptc.view.ConsoleView;

import java.io.FileNotFoundException;

public class Runner {
    PresenterInterface presenter;
    ModelInterface model;
    ViewInterface view;

    private void makeMVP(){
        presenter = new Presenter();
        model = new ModelManager();
        view =  ConsoleView.getInstance();
        presenter.setModel(model);
        presenter.setView(view);
        view.setPresenter(presenter);
    }

    public void start(String path){
        makeMVP();
        try {
            validateParameters(path);
            setInitialPath(path);
            view.start();
        } catch (FileNotFoundException e) {
            view.showError(e.getMessage());
        }
    }


    void validateParameters(String path) throws FileNotFoundException {
        model.validaAllPath(path);
    }

    void setInitialPath(String path){
        model.setPath(path);
    }
}