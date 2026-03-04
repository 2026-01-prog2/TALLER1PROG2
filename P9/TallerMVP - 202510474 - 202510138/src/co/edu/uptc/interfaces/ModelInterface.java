package co.edu.uptc.interfaces;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public interface ModelInterface {
    String exec() throws Exception;
    void validateAllPathDirectory(String path) throws FileNotFoundException;
    void validateAllPathFile(String path) throws FileNotFoundException;
    void startInitialPath(String path) throws FileNotFoundException;
    File getDirectory();
    void setDirectory(File directoryToSearch);

    List<String> listDirectory ();
    String searchFile(String nameToSearch);
    long calculateSize (String path);
    boolean deleteFile(String nameToSearch);
}
