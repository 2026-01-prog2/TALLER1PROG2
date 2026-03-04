package co.edu.uptc.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import co.edu.uptc.interfaces.ModelInterface;
import co.edu.uptc.interfaces.PresenterInterface;
import co.edu.uptc.util.Util;

public class FileManager implements ModelInterface {

    private PresenterInterface presenter;
    private File directory;

    @Override
    public void setPresenter(PresenterInterface presenter) {
        this.presenter = presenter;
    }

    public void setDirectory(String path) {
        this.directory = new File(path);
    }

    @Override
    public void validatePathDirectory(String path) throws FileNotFoundException {
        ValidateFile validateFile = new ValidateFile(path, 1);
        validateFile.validateArguments();
        validateFile.validateDirectory();
    }

    @Override
    public void validatePathFile(String path) throws FileNotFoundException {
        ValidateFile validateFile = new ValidateFile(path, 0);
        validateFile.validateArguments();
        validateFile.validateFile();
    }

    @Override
    public File searchFile(String pattern) {
        Util.regex(pattern);
        String result = searchInFolder(directory, pattern);
        if (result == null)
            return null;
        return new File(result);
    }

    private String searchInFolder(File file, String pattern) {
        File[] filesList = file.listFiles();
        if (filesList == null)
            return null;

        for (File f : filesList) {

            if (f.isDirectory()) {
                String result = searchInFolder(f, pattern);
                if (result != null) {
                    return result;
                }
            }

            if (f.isFile() && f.getName().matches(pattern)) {
                return f.getPath();
            }
        }

        return null;
    }

    @Override
    public List showDirectory() {
        List<File> result = new ArrayList();
        File[] list = directory.listFiles();
        for (File f : list) {
            result.add(f);
        }
        return result;
    }

    @Override
    public void deleteFile(String pattern) {
        String path = searchInFolder(directory, pattern);
        if (path != null) {
            File f = new File(path);
            f.delete();
        }
    }

    @Override
    public String showDirectoryLength() {
        return "El tamaño del directorio <" + directory.getName() + "> es: \n" + directory.length() + " Bytes";
    }

}
