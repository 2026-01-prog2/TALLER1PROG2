package co.edu.uptc.model;

import co.edu.uptc.interfaces.ModelInterface;
import co.edu.uptc.util.AppException;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Model implements ModelInterface {

    @Override
    public List<String> search(String initialRoute, String name, boolean includeDirectories) {

        File root = new File(initialRoute);

        if (!root.exists()) {
            throw new AppException("La ruta es inválida.");
        }

        List<String> results = new ArrayList<>();
        recursiveSearch(root, name, results, includeDirectories);

        return results;
    }

    private void recursiveSearch(File file, String name, List<String> results, boolean includeDirectories) {
        File[] files = file.listFiles();
        if (files == null) return;
        for (File f : files) {
            if (f.getName().contains(name)) {
                results.add(f.getAbsolutePath() + " (" + fileSize(f.getAbsolutePath()) + " bytes)");
            }
            if (f.isDirectory() && includeDirectories) {
                recursiveSearch(f, name, results, true);
            }
        }
    }

    @Override
    public long fileSize(String route) {
        File file = new File(route);
        if (!file.exists()) {
            throw new AppException("La ruta no existe.");
        }
        return calculateSize(file);
    }

    private long calculateSize(File file) {
        if (file.isFile()) {
            return file.length();
        }
        long total = 0;
        File[] files = file.listFiles();
        if (files != null) {
            for (File f : files) {
                total += calculateSize(f);
            }
        }
        return total;
    }

    @Override
    public boolean delete(String route) {
        File file = new File(route);
        if (!file.exists()) {
            throw new AppException("El archivo o carpeta no existe.");
        }
        return recursiveDelete(file);
    }

    private boolean recursiveDelete(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    recursiveDelete(f);
                }
            }
        }
        return file.delete();
    }

    @Override
    public String moveRoute(String initialRoute, String finalRoute) {
        File newRoute = new File(initialRoute, finalRoute);
        if (!newRoute.exists() || !newRoute.isDirectory()) {
            throw new AppException("La carpeta no existe.");
        }
        return newRoute.getAbsolutePath();
    }
}