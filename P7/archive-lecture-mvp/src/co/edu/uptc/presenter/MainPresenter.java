package co.edu.uptc.presenter;
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
    public String showFileInfo(String directory) {
        String path = "";
        try {
            path = model.getFileInfo(directory);
        } catch (Exception e) {
            view.showError(e.getMessage());
        }
        return path;
    }

    @Override
    public String deleteFile(String file) {
        String status ="";
        try {
            status = model.deleteFile(file);
        } catch (Exception e) {
            view.showError(e.getMessage());
        }
        return status;
    }
    @Override
    public void setPath(String path){
        try {
            model.setPath(path);
        } catch (Exception e) {
            view.showError(e.getMessage());
        }
    }
    @Override
    public String getPath(){
        String path = "";
        try {
            path = model.getPath();
        } catch (Exception e) {
            view.showError(e.getMessage());
        }
        return path;
    }

}
