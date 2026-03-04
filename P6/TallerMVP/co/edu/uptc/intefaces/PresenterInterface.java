package co.edu.uptc.interfaces;

import java.io.File;

public interface PresenterInterface {

    public void setView(ViewInterface view);
    public void setModel(ModelInterface model);

    public String search(String nombreArchivo);
    public File getInitialRoute();
    public long getfolderSize(File rutaInicial);
    public String listDirectory();
    public String deleteFile(String fileName);
}
