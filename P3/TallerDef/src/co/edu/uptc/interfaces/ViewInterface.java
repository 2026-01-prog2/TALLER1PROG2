package co.edu.uptc.interfaces;

public interface ViewInterface {

    void start();

    void setPresenter(PresenterInterface presenter);

    void showError(String message);
    
}
