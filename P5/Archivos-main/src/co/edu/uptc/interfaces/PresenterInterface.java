package co.edu.uptc.interfaces;
public interface PresenterInterface {
    void setView(ViewInterface view);
    void setModel(ModelInterface model);
    void start();
    void searchFile(String name);
    void showSize(String path);
    void listDirectory(String path);
    void deleteFile(String path);
}