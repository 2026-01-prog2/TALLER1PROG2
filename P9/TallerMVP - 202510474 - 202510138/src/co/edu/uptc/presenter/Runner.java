package co.edu.uptc.presenter;

import co.edu.uptc.interfaces.ModelInterface;
import co.edu.uptc.interfaces.PresenterInterface;
import co.edu.uptc.interfaces.ViewInterface;

import co.edu.uptc.model.ManagerFileImp;
import co.edu.uptc.view.ConsoleView;

import java.io.FileNotFoundException;

public class Runner {
    PresenterInterface presenter;
    ModelInterface model;
    ViewInterface view;

    private void makeMVP(){
        presenter = new MainPresenter();
        model = new ManagerFileImp();
        view =  ConsoleView.getInstance();

        presenter.setModel(model);
        presenter.setView(view);
        view.setPresenter(presenter);
    }

    public void start(String path){
        makeMVP();
        try {
            ValidateParameters(path);
            presenter.start(path);
            view.start();
        } catch (FileNotFoundException e) {
           view.showError(e.getMessage());
        }
    }


    void ValidateParameters(String path) throws FileNotFoundException {
            model.validateAllPathDirectory(path);
    }
}
