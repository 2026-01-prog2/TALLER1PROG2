package co.edu.uptc.model;

import java.io.File;
import java.io.FileNotFoundException;

public class ValidateFile {
    private final File file;
    private final String path;
    private final int typeFile;

    public ValidateFile(String path, int typeFile) {
        this.path = path;
        this.file = new File(path);
        this.typeFile = typeFile;
    }

    public void validateType() {
        if (typeFile != 0 && typeFile != 1)
            throw new IllegalArgumentException("Tipo debe ser 0 (archivo) o 1 (carpeta)");
    }

    public void validatePath() throws FileNotFoundException {
        if (!file.exists())
            throw new FileNotFoundException("La ruta no existe: " + path);
    }

    public void validateDirectory() throws FileNotFoundException {
        if (typeFile == 1 && !file.isDirectory())
            throw new FileNotFoundException("Se esperaba una carpeta");
    }

    public void validateFile() throws FileNotFoundException {
        if (typeFile == 0 && !file.isFile())
            throw new FileNotFoundException("Se esperaba un archivo");
    }

    public void validateAllDirectory() throws FileNotFoundException {
        validateType();
        validatePath();
        validateDirectory();
    }

    public void validateAllFile() throws FileNotFoundException {
        validateType();
        validatePath();
        validateFile();
    }
}