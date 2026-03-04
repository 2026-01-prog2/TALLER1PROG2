package co.edu.uptc.presenter;

import co.edu.uptc.interfaces.ModelInterface;
import co.edu.uptc.interfaces.PresenterInterface;
import co.edu.uptc.interfaces.ViewInterface;
import co.edu.uptc.model.ArchiveActions;
import co.edu.uptc.view.ConsoleView;

public class Runner {
    PresenterInterface presenter;
    ModelInterface model;
    ViewInterface view;


    private void makeMVP(){
        presenter = new MainPresenter();
        model = new ArchiveActions();
        view = ConsoleView.getInstance();
        presenter.setModel(model);
        presenter.setView(view);
        view.setPresenter(presenter);
    }

    public void start(String[] args){
        makeMVP();
        view.start(args);
    }
}