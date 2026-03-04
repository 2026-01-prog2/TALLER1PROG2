package co.edu.uptc.model;

import java.io.File;
import java.io.FileNotFoundException;

public class ValidateFile {
    private String path;
    private File file;
    private int typeFile;

    public ValidateFile(String path) {
        file = new File(path);
        this.path = path;
        setTypeFile();
    }

    public void setTypeFile() {
        typeFile = 0;
        if(file.isDirectory()){
            typeFile = 1;
        }
    }


    public void validateType() {
        if (!file.isFile() && !file.isDirectory()) {
            throw new IllegalArgumentException("El tipo de archivo debe ser archivo o carpeta.");
        }
    }

    public void validatePath() throws FileNotFoundException {
        if (!file.exists()) {
            throw new FileNotFoundException("La ruta especificada no existe: " + path);
        }
    }

    //TODO MODIFICAR METODOS PA QUE NO NECESITEN UN NUMERO

    public void validateFile() throws FileNotFoundException {
        if (!file.isDirectory() && typeFile == 1) {
            throw new FileNotFoundException("Se esperaba una carpeta, pero la ruta apunta a un archivo.");
        }
        else if(!file.isFile() && typeFile == 0) {
            throw new FileNotFoundException("Se esperaba un archivo, pero la ruta apunta a una carpeta.");
            
        }
    }

    public void validateAll() throws FileNotFoundException {
        validateType();
        validatePath();
        validateFile();
    }

}
