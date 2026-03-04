package co.edu.uptc.presenter;

import co.edu.uptc.interfaces.ModelInterface;
import co.edu.uptc.interfaces.PresenterInterface;
import co.edu.uptc.interfaces.ViewInterface;

import co.edu.uptc.model.ModelManagerFile;
import co.edu.uptc.view.ConsoleView;

public class Runner {
    PresenterInterface presenter;
    ModelInterface model;
    ViewInterface view;


    private void makeMVP(String pathDirectory){
        presenter = new MainPresenter();
        model = new ModelManagerFile(pathDirectory);
        view = new ConsoleView();

        presenter.setModel(model);
        presenter.setView(view);
        view.setPresenter(presenter);
    }

    public void start(String pathDirectory){
        makeMVP(pathDirectory);
        view.start();
    }
}
