package co.edu.uptc.model;

import java.io.File;

public class ModelUtil {
    protected String checkPath(String recievedPath) {
        String path = "";
        File newPath = new File(recievedPath);
            if (newPath.exists()) path = newPath.getAbsolutePath();
        return path;
    }
    protected long calculateDirectorySize(File directory) {
        long size = 0;
        for (File file : directory.listFiles()) {
            if (file.isFile()) size += file.length();
            else if (file.isDirectory()) size += calculateDirectorySize(file);
        }
        return size;
    }
}
