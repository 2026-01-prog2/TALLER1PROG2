package co.edu.uptc.interfaces;

public interface ViewInterface {
    void setPresenter(PresenterInterface presenter);
    void start();
    void showError(String message);
    void showMessage(String message);
    String readInput();
    int readOption();
}