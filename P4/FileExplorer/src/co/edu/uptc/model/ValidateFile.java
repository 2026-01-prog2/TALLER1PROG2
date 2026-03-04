package co.edu.uptc.model;

import java.io.File;
import java.io.FileNotFoundException;

public class ValidateFile {
    private int typeFile;
    private String path;

    private File file;

    public ValidateFile(String path, int typeFile){
        this.typeFile = typeFile;
        this.path = path;
        file = new File(path);
    }

    void validateArguments(){
        if(typeFile != 0 && typeFile != 1){
            throw new IllegalArgumentException("El tipo de archivo debe ser 1 o 0");
        }
    }

    void validatePath () throws FileNotFoundException{
        if(!file.exists()){
            throw new FileNotFoundException("RUTA INVÁLIDA - La ruta ingresada no existe");
        }
    }

    void validateDirectory() throws FileNotFoundException{
        if(!file.isDirectory()){
            throw new FileNotFoundException("RUTA INVÁLIDA - Se esperaba una carpeta");
        }
    }

    void validateFile() throws FileNotFoundException{
        if(!file.isDirectory()){
            throw new FileNotFoundException("RUTA INVÁLIDA - Se esperaba una archivo");
        }
    }
}
