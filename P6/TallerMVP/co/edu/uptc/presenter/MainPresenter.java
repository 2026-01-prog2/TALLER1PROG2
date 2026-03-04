package co.edu.uptc.presenter;

import java.io.File;

import co.edu.uptc.interfaces.ModelInterface;
import co.edu.uptc.interfaces.PresenterInterface;
import co.edu.uptc.interfaces.ViewInterface;

public class MainPresenter implements PresenterInterface {
    private ViewInterface view;
    private ModelInterface model;

    @Override
    public void setView(ViewInterface view) {
        this.view = view;
    }

    @Override
    public void setModel(ModelInterface model) {
        this.model = model;
    }

    @Override
    public String search(String fileName) {
        return model.search(fileName);
    }

    @Override
    public File getInitialRoute(){
        return model.getInitialRoute();
    }

    @Override
    public long getfolderSize(File initialRoute){
        return model.getfolderSize(model.getInitialRoute());
    }

    @Override
    public String listDirectory(){
        return model.listDirectory();
    }

    @Override
    public String deleteFile(String fileName){
        return model.deleteFile(fileName);
    }
}