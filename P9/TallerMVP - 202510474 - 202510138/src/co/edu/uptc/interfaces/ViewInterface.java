package co.edu.uptc.interfaces;

import java.util.List;

public interface ViewInterface {
    void setPresenter(PresenterInterface presenter);
    void start();
    void showError(String message);
    void showList(List<String> totalList);
    void showMessage(String message);
}
