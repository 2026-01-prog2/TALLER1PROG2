package co.edu.uptc.presenter;

import java.io.File;
import java.util.List;

import co.edu.uptc.interfaces.ModelInterface;
import co.edu.uptc.interfaces.PresenterInterface;
import co.edu.uptc.interfaces.ViewInterface;

public class Presenter implements PresenterInterface {
    private ModelInterface model;
    private ViewInterface view;

    @Override
    public void setModel(ModelInterface model) {
        this.model = model;
    }

    @Override
    public void setView(ViewInterface view) {
        this.view = view;
    }

    @Override
    public File searchFile(String name){
        return model.searchFile(name);
    }

    @Override
    public String consultDirectorySize() {
        return model.showDirectoryLength();
    }

    @Override
    public List listDirectory() {
        List <File> list = model.showDirectory();
        return list;
    }

    @Override
    public void deleteFile(String pathFile) {
        model.deleteFile(null);
    }

}
