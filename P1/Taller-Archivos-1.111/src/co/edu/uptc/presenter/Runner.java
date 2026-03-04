package co.edu.uptc.presenter;

import co.edu.uptc.interfaces.ModelInterface;
import co.edu.uptc.interfaces.PresenterInterface;
import co.edu.uptc.interfaces.ViewInterface;
import co.edu.uptc.model.Model;
import co.edu.uptc.view.ConsoleView;

public class Runner {

    private PresenterInterface presenter;
    private ModelInterface model;
    private ViewInterface view;

    public Runner() {
        this.model = new Model();
        this.view = new ConsoleView();
        this.presenter = new Presenter(model, view);
        this.view.setPresenter(presenter);
    }

    public void start(String initialRoute) {
        presenter.startMenu(initialRoute);
    }
}