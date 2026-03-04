package co.edu.uptc.interfaces;

public interface PresenterInterface {

    public void setView(ViewInterface view);
    public void setModel(ModelInterface model);
    public void setInitialPath(String initialPath);

    public void listDirectory();
    public void searchFile(String name);
    public void calculateSize(String path);
    public void deleteFile(String name);
    public void start(String initialPath);
}
