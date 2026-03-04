package co.edu.uptc.interfaces;

import java.io.File;
import java.util.List;
import java.util.Optional;
public interface ModelInterface {
    void setCurrentPath(String path);
    List<File> searchFile(String name);
    Optional<Long> calculateSize();
    List<File> listDirectory();
    boolean deleteFile();
}