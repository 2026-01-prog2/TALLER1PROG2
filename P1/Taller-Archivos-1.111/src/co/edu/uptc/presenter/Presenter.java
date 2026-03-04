package co.edu.uptc.presenter;

import co.edu.uptc.interfaces.*;
import co.edu.uptc.util.AppException;
import java.util.List;

public class Presenter implements PresenterInterface {
    private ModelInterface model;
    private ViewInterface view;

    public Presenter(ModelInterface model, ViewInterface view) {
        this.model = model;
        this.view = view;
    }

   
public void startMenu(String initialRoute){
    view.showMenu(initialRoute);

}
    public List<String> acctionOption1(String initialRoute){
        List<String> results = model.search(initialRoute, "", false);
        return results;
        
    }
    public List<String> acctionOption2(String initialRoute,String name){
        List<String> results = model.search(initialRoute, name, true);
        return results;
        
    }
    public List<String> acctionOption3(String initialRoute){
        List<String> results = model.search(initialRoute, "", false);
        return results;
        
    }
    public Long acctionOption4(String initialRoute){
         long size = model.fileSize(initialRoute);
        return size;
        
    }
    public boolean acctionOption5(String routeToDelete){
        boolean deleted = model.delete(routeToDelete);
        return deleted;
        
    }
}