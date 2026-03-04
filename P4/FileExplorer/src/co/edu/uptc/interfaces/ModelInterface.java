package co.edu.uptc.interfaces;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public interface ModelInterface {
    void setDirectory(String path);
    void setPresenter(PresenterInterface presenter);
    void validatePathDirectory(String path)throws FileNotFoundException;
    void validatePathFile(String path)throws FileNotFoundException;
    String showDirectoryLength();
    void deleteFile(String pattern);
    List showDirectory();
    File searchFile(String pattern);
}
