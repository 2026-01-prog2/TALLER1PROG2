package co.edu.uptc.interfaces;

import java.io.File;
import java.util.List;

public interface PresenterInterface {
    void setModel(ModelInterface model);
    void setView(ViewInterface view);
    File searchFile(String name);
    String consultDirectorySize();
    List listDirectory();
    void deleteFile(String pathFile);

}
