package co.edu.uptc.view;

public class CLIDirectory {

    public void showDirectorySize(){
        ConsoleView.getInstance().showInfo(ConsoleView.getInstance().presenter.directorySize());
    }
    
}
