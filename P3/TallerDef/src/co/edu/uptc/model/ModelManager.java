package co.edu.uptc.model;

import co.edu.uptc.interfaces.ModelInterface;

import java.io.File;
import java.io.FileNotFoundException;

public class ModelManager implements ModelInterface {
    private File initialDirectory;
    @Override
    public String exec() throws Exception {
        return "";
    }

    @Override
    public void validaAllPath(String path) throws FileNotFoundException {
        ValidateFile validateFile = new ValidateFile(path);
        validateFile.validateType();
        validateFile.validateFile();
    }

    @Override
    public String callToSearchFile(String name) throws FileNotFoundException {
        DirectoryShort directory = new DirectoryShort();
        return directory.pathAndSize(name, initialDirectory); 
    }

    @Override
    public String callToGetSize(){
        DirectoryShort directory = new DirectoryShort();
        return directory.directorySize(initialDirectory);
    }
    
    @Override
    public void setPath(String path){
        initialDirectory = new File(path);
    }

    @Override
    public String callToFolderInfo(String name)throws Exception{
        DirectoryShort directory = new DirectoryShort();
        return directory.getFolderInfo(name, initialDirectory);
    }

    @Override
    public String searchToDelete(String name) throws FileNotFoundException{
        DirectoryShort directory = new DirectoryShort();
        return directory.searchFileByName(name, initialDirectory) + "";
    }

    @Override
    public void confirmedDeletion(String name) throws FileNotFoundException{
        DirectoryShort directory = new DirectoryShort();
        directory.deleteFile(name, initialDirectory);
    }
}