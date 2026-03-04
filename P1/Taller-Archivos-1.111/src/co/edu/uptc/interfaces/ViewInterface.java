package co.edu.uptc.interfaces;

import co.edu.uptc.presenter.Presenter;

public interface ViewInterface {

    void showMenu(String otherRoute);

    String read(String message);

    String read();

    int readInt(String message);

    void showMessage(String message);
     void setPresenter(PresenterInterface presenter);
    
}