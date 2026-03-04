package co.edu.uptc.interfaces;

public interface ViewInterface {
    void setPresenter(PresenterInterface presenter);
    void showError(String message);
    String showArchiveInformation(String path);
    void start(String[] args);
}
