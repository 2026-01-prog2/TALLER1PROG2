package co.edu.uptc.presenter;

import co.edu.uptc.interfaces.ModelInterface;
import co.edu.uptc.interfaces.PresenterInterface;
import co.edu.uptc.interfaces.ViewInterface;

import java.util.List;

public class MainPresenter implements PresenterInterface {
    private ViewInterface view;
    private ModelInterface model;
    private String initialPath;

    @Override
    public void setInitialPath(String initialPath) {
        this.initialPath = initialPath;
    }

    @Override
    public void setView(ViewInterface view) {
        this.view = view;
    }

    @Override
    public void setModel(ModelInterface model) {
        this.model = model;
    }

     public String getInitialPath() {
        return initialPath;
    }

    @Override
    public void start(String initialPath) {
        setInitialPath(initialPath);
        view.showMessage("Trabajando en la ubicación: " + getInitialPath());
        initModel(initialPath);
    }

    private void initModel(String path) {
        try {
            model.startInitialPath(path);
        } catch (Exception e) {
            view.showError("Ha ocurrido un error con la ruta inicial: " + e.getMessage());
        }
    }

    @Override
    public void listDirectory() {
        view.showMessage("Listando directorio: " + getInitialPath());
        List<String> answer = model.listDirectory();
        view.showList(answer);
    }

    @Override
    public void searchFile(String nombre) {
        view.showMessage("Buscando archivo: " + nombre);
        String answer = model.searchFile(nombre);
        view.showMessage(answer);
    }

    @Override
    public void calculateSize(String path) {
        long size = model.calculateSize(path);

        if (size == -1) {
            view.showError("La ruta no existe.");
        } else {
            view.showMessage("El tamaño es: " + size + " bytes");
        }
    }

    @Override
    public void deleteFile(String name) {
        view.showMessage("Borrando archivo: " + name);
        boolean answer = model.deleteFile(name);
        if (answer) {
            view.showMessage("El archivo " + name + " fue encontrado y eliminado de manera exitosa");
        } else {
            view.showError("Error en la busqueda / No existe");
        }
    }
}

