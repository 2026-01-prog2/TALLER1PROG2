package co.edu.uptc.presenter;

import java.io.File;
import java.io.FileNotFoundException;

import co.edu.uptc.interfaces.ModelInterface;
import co.edu.uptc.interfaces.PresenterInterface;
import co.edu.uptc.interfaces.ViewInterface;
import co.edu.uptc.model.FileManager;
import co.edu.uptc.view.ConsoleView;

public class Runner {

    PresenterInterface presenter;
    ModelInterface model;
    ViewInterface view;

    public void makeMVP(String path) {
        presenter = new Presenter();
        model = new FileManager();
        view = ConsoleView.getInstance();

        model.setDirectory(path);

        presenter.setModel(model);
        presenter.setView(view);
        view.setPresenter(presenter);
    }

    public void start(String path) {
        try {
            makeMVP(path);
            validatePath(path);
            view.start();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    public void validatePath(String path) throws FileNotFoundException {
        File file = new File(path);
        System.out.println(file);
        model.validatePathDirectory(path);
    }
}
