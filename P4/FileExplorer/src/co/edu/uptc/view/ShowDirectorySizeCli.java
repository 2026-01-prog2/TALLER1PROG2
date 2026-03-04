package co.edu.uptc.view;

public class ShowDirectorySizeCli {
    public void exec(){
        System.out.println(ConsoleView.getInstance().presenter.consultDirectorySize());
    }
}
