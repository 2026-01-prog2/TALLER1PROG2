package co.edu.uptc.model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ListDirectory {

    List <String> listDirectory = new ArrayList<String>();

    public List<String> listDirectoryRecursive(File directory) {
        File[] list = directory.listFiles();
        if (list != null) {
            browseAll(list);
        }
        return listDirectory;
    }

    private void browseAll(File[] list) {
        if (list == null) {
            return;
        }
        for (File file : list) {
            listDirectory.add(file.getAbsolutePath());
            if (file.isDirectory()) {
                browseAll(file.listFiles());
            }
        }
    }
}