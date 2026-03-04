package co.edu.uptc.interfaces;

import java.io.File;

public interface ModelInterface {
    String exec() throws Exception;

    public String search(String nombreArchivo);
    public File getInitialRoute();
    public long getfolderSize(File rutaInicial);
    public String listDirectory();
    public String deleteFile(String fileName);
}
