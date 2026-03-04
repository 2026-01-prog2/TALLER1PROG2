package co.edu.uptc.interfaces;

public interface PresenterInterface {
    void setView(ViewInterface view);
    void setModel(ModelInterface model);
    void searchFile(String pattern);
    void showTotalSize();
    void listDirectory(String relativePath);
    void deleteFile(String relativePath);
    void start();
}