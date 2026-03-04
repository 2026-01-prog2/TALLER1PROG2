package co.edu.uptc.presenter;

import co.edu.uptc.interfaces.ModelInterface;
import co.edu.uptc.interfaces.PresenterInterface;
import co.edu.uptc.interfaces.ViewInterface;

import java.io.File;
import java.util.List;

public class FilePresenter implements PresenterInterface {
    private ModelInterface model;
    private ViewInterface view;

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
    public void searchFile(String pattern) {
        if (!isValidPattern(pattern)) {
            view.showMessage("El patrón no puede estar vacío.");
            return;
        }
        executeSearch(pattern);
    }

    private boolean isValidPattern(String pattern) {
        if (pattern == null) {
            return false;
        }
        if (pattern.trim().isEmpty()) {
            return false;
        }
        return true;
    }

    private void executeSearch(String pattern) {
        try {
            List<File> results = model.search(pattern);
            processResults(results);
        } catch (Exception e) {
            view.showError("Error en búsqueda: " + e.getMessage());
        }
    }

    private void processResults(List<File> results) {
        if (results == null || results.isEmpty()) {
            view.showMessage("No se encontraron archivos.");
            return;
        }
        for (int i = 0; i < results.size(); i++) {
            showFileDetails(results.get(i));
        }
    }

    private void showFileDetails(File file) {
        view.showMessage("Ubicación: " + file.getAbsolutePath());
        if (file.isFile()) {
            view.showMessage("Tamaño: " + file.length() + " bytes");
        } else {
            long size = model.calculateDirectorySize(file);
            view.showMessage("Tamaño (directorio): " + size + " bytes");
        }
        view.showMessage("---------------------------");
    }

    @Override
    public void showTotalSize() {
        long size = model.calculateDirectorySize(model.getRoot());
        view.showMessage("Tamaño total: " + size + " bytes");
    }

    @Override
    public void listDirectory(String relativePath) {
        File directory = buildDirectory(relativePath);
        if (directory == null) {
            view.showMessage("Acceso fuera del directorio raíz no permitido.");
            return;
        }
        File[] files = model.listDirectory(directory);

        if (files == null) {
            view.showMessage("Directorio inválido.");
            return;
        }
        showDirectoryContent(files);
    }
    private File buildDirectory(String relativePath) {
        if (relativePath == null || relativePath.trim().isEmpty()) {
            return null;
        }
        File directory = new File(model.getRoot(), relativePath);
        return isInsideRoot(directory) ? directory : null;
    }

    private boolean isInsideRoot(File file) {
        try {
            String rootPath = model.getRoot().getCanonicalPath();
            String filePath = file.getCanonicalPath();
            return filePath.startsWith(rootPath);
        } catch (java.io.IOException e) {
            return false;
        }
    }

    private void showDirectoryContent(File[] files) {
        if (files.length == 0) {
            view.showMessage("Directorio vacío.");
            return;
        }
        for (File file : files) {
            showFileInfo(file);
        }
    }

    private void showFileInfo(File file) {
        if (file.isDirectory()) {
            view.showMessage("[DIR] " + file.getName());
        } else {
            view.showMessage("[FILE] " + file.getName());
        }
    }

    @Override
    public void deleteFile(String relativePath) {
        File file = buildFile(relativePath);
        if (file == null) {
            view.showMessage("Acceso fuera del directorio raíz no permitido.");
            return;
        }
        boolean deleted = model.deleteFile(file);
        if (deleted) {
            view.showMessage("Archivo eliminado correctamente.");
        } else {
            view.showMessage("No se pudo eliminar el archivo.");
        }
    }

    private File buildFile(String relativePath) {
        if (relativePath == null || relativePath.trim().isEmpty()) {
            return null;
        }
        File file = new File(model.getRoot(), relativePath);
        return isInsideRoot(file) ? file : null;
    }
}