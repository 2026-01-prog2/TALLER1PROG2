package co.edu.uptc.presenter;

import java.io.FileNotFoundException;

import co.edu.uptc.interfaces.ModelInterface;
import co.edu.uptc.interfaces.PresenterInterface;
import co.edu.uptc.interfaces.ViewInterface;
import co.edu.uptc.view.ConsoleView;

public class Presenter implements PresenterInterface {
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
    public String searchFile(String name) throws FileNotFoundException{
        return model.callToSearchFile(name);
    }

    @Override
    public String directorySize(){
        return model.callToGetSize();
    }

    @Override 
    public String directoryInfo(String name) throws Exception{
        return model.callToFolderInfo(name);
    }

    @Override
    public String searchToDelete(String name) throws FileNotFoundException{
        return model.searchToDelete(name);
    }

    @Override 
    public String deleteFile(String name) throws FileNotFoundException{
        model.confirmedDeletion(name);
        return "\n-----------------------------------\narchivo borrado exitosamente\n-----------------------------------";
    }


}