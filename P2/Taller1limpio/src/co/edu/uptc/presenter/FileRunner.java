package co.edu.uptc.presenter;

import co.edu.uptc.model.FileModel;
import co.edu.uptc.view.ManagerConsole;

public class FileRunner {
    public void run(String rootPath) throws Exception {
        FileModel model = new FileModel(rootPath);
        ManagerConsole view = ManagerConsole.getInstance();
        FilePresenter presenter = new FilePresenter();

        view.setPresenter(presenter);
        presenter.setView(view);
        presenter.setModel(model);
        presenter.start();
    }
}