package co.edu.uptc.interfaces;

import java.io.FileNotFoundException;

public interface PresenterInterface {
    void setView(ViewInterface view);
    void setModel(ModelInterface model);
    String searchFile(String name) throws FileNotFoundException;
    String directorySize();
    String directoryInfo(String name) throws Exception;
    String deleteFile(String name) throws FileNotFoundException;
    String searchToDelete(String name) throws FileNotFoundException;
}
