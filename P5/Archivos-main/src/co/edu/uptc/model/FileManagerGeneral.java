package co.edu.uptc.model;
import co.edu.uptc.interfaces.ModelInterface;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
public class FileManagerGeneral implements ModelInterface {
    private final File C;
    private File currentFile;

    public FileManagerGeneral(String rootPath) {
        this.C = new File(rootPath);
        //if (!C.exists()) C.mkdirs();
    }

    @Override
    public void setCurrentPath(String path) {
        File file = new File(C, path);
        validateInsideRoot(file);
        currentFile = file;
    }

    private void validateInsideRoot(File file) {
        try {
            String rootPath = C.getCanonicalPath();
            String filePath = file.getCanonicalPath();
            if (!filePath.startsWith(rootPath))
                throw new IllegalArgumentException("Ruta fuera del directorio inicial.");
        } catch (Exception e) {
            throw new IllegalArgumentException("Ruta inválida.");
        }
    }

    @Override
    public List<File> searchFile(String name) {
        if (name == null || name.trim().isEmpty()) throw new IllegalArgumentException("Debe ingresar un nombre válido.");
        List<File> result = new ArrayList<>();
        searchRecursive(C, name.trim().toLowerCase(), result);
        return result;
    }

    private void searchRecursive(File dir, String name, List<File> result) {
        if (!isValid(dir)) return;
        for (File file : dir.listFiles()) {
            if (file.getName().toLowerCase().contains(name))
                result.add(file);
            if (file.isDirectory())
                searchRecursive(file, name, result);
        }
    }

    private boolean isValid(File dir) {
        return dir != null && dir.exists() && dir.listFiles() != null;
    }

    @Override
    public Optional<Long> calculateSize() {
        validateExists();
        return Optional.of(calculateRecursive(currentFile));
    }

    private long calculateRecursive(File file) {
        if (file.isFile()) return file.length();
        long total = 0; File[] files = file.listFiles();
        if (files != null) for (File f : files) total += calculateRecursive(f);
        return total;
    }

    @Override public List<File> listDirectory() {
        validateExists();
        if (!currentFile.isDirectory()) throw new IllegalArgumentException("La ruta no es un directorio.");
        List<File> result = new ArrayList<>();
        File[] files = currentFile.listFiles();
        if (files != null) for (File f : files) result.add(f);
        return result;
    }

    @Override public boolean deleteFile() {
        validateExists();
        if (!currentFile.isFile())
            throw new IllegalArgumentException("La ruta no es un archivo.");
        return currentFile.delete();
    }

    private void validateExists() {
        if (currentFile == null || !currentFile.exists())
            throw new IllegalArgumentException("La ruta no existe.");
    }
}

