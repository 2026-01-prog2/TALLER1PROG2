package co.edu.uptc.interfaces;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public interface ModelInterface {
    List<File> search(String pattern) throws Exception;
    long calculateDirectorySize(File directory);
    File[] listDirectory(File directory);
    boolean deleteFile(File file);
    File getRoot();
}