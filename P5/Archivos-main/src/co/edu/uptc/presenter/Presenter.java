package co.edu.uptc.presenter;

import co.edu.uptc.interfaces.ModelInterface;
import co.edu.uptc.interfaces.PresenterInterface;
import co.edu.uptc.interfaces.ViewInterface;

public class Presenter implements PresenterInterface {

    private ViewInterface view;
    private ModelInterface model;

    @Override
    public void setView(ViewInterface view) {
        this.view = view;
    }

    @Override
    public void setModel(ModelInterface model) {
        this.model = model;
    }

    @Override
    public void start() {
        view.start();
    }

    @Override
    public void searchFile(String name) {
        try {
            var result = model.searchFile(name);

            if (result.isEmpty())
                view.showMessage("No se encontraron archivos con ese nombre.");
            else
                view.showFiles(result);

        } catch (Exception e) {
            view.showMessage(e.getMessage());
        }
    }

    @Override
    public void showSize(String path) {
        try {
            model.setCurrentPath(path);
            long size = model.calculateSize().orElseThrow();
            view.showSize(size);

        } catch (Exception e) {
            view.showMessage(e.getMessage());
        }
    }

    @Override
    public void listDirectory(String path) {
        try {
            model.setCurrentPath(path);
            var result = model.listDirectory();

            if (result.isEmpty())
                view.showMessage("El directorio está vacío.");
            else
                view.showFiles(result);

        } catch (Exception e) {
            view.showMessage(e.getMessage());
        }
    }

    @Override
    public void deleteFile(String path) {
        try {
            model.setCurrentPath(path);
            boolean deleted = model.deleteFile();

            if (deleted)
                view.showMessage("Archivo eliminado correctamente.");
            else
                view.showMessage("No se pudo eliminar el archivo.");

        } catch (Exception e) {
            view.showMessage(e.getMessage());
        }
    }
}