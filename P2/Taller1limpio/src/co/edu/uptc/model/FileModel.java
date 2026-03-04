package co.edu.uptc.model;

import co.edu.uptc.interfaces.ModelInterface;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class FileModel implements ModelInterface {
    private final File root;

    public FileModel(String rootPath) throws FileNotFoundException {
        performValidation(rootPath);
        this.root = new File(rootPath);
    }

    private void performValidation(String path) throws FileNotFoundException {
        new ValidateFile(path, 1).validateAllDirectory();
    }

    @Override
    public List<File> search(String pattern) throws Exception {
        if (pattern == null || pattern.trim().isEmpty()) {
            throw new Exception("El patrón no puede estar vacío.");
        }
        List<File> results = new ArrayList<>();
        searchRecursive(root, pattern.trim(), results);
        return results;
    }

    private void searchRecursive(File directory, String pattern, List<File> results) {
        File[] files = directory.listFiles();
        if (files == null) {
            return;
        }
        for (int i = 0; i < files.length; i++) {
            File currentFile = files[i];
            if (matchesPattern(currentFile.getName(), pattern)) {
                results.add(currentFile);
            }
            if (currentFile.isDirectory()) {
                searchRecursive(currentFile, pattern, results);
            }
        }
    }

    private boolean matchesPattern(String fileName, String pattern) {
        if (pattern.equals("*")) {
            return true;
        }
        if (pattern.startsWith("*") && pattern.endsWith("*")) {
            String text = pattern.substring(1, pattern.length() - 1);
            return fileName.contains(text);
        }
        if (pattern.startsWith("*")) {
            String text = pattern.substring(1);
            return fileName.endsWith(text);
        }
        if (pattern.endsWith("*")) {
            String text = pattern.substring(0, pattern.length() - 1);
            return fileName.startsWith(text);
        }
        return fileName.equals(pattern);
    }

    @Override
    public long calculateDirectorySize(File directory) {
        long totalSize = 0;
        File[] files = directory.listFiles();
        if (files == null) {
            return totalSize;
        }
        for (int i = 0; i < files.length; i++) {
            File file = files[i];

            if (file.isFile()) {
                totalSize = totalSize + file.length();
            } else {
                totalSize = totalSize + calculateDirectorySize(file);
            }
        }
        return totalSize;
    }

    @Override
    public File[] listDirectory(File directory) {
        try {
            new ValidateFile(directory.getPath(), 1).validateAllDirectory();
            return directory.listFiles();
        } catch (FileNotFoundException e) {
            return null;
        }
    }

    @Override
    public boolean deleteFile(File file) {
        try {
            new ValidateFile(file.getPath(), 0).validateAllFile();
            return file.delete();
        } catch (FileNotFoundException e) {
            return false;
        }
    }

    @Override
    public File getRoot() {
        return root;
    }
}