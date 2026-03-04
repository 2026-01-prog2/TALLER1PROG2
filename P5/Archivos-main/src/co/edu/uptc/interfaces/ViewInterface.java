package co.edu.uptc.interfaces;
import java.io.File;
import java.util.List;
public interface ViewInterface {
    void setPresenter(PresenterInterface presenter);
    void start();
    void showMenu();
    String readInput();
    void showFiles(List<File> files);
    void showSize(long size);
    void showMessage(String message);
}