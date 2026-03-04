package co.edu.uptc.view;
import java.io.FileNotFoundException;

public class CLIDeletion{

    public void confirmDeletion(){
        try{
            CLISearch cliSearch = new CLISearch();
            String name = cliSearch.searchFileToDelete();
            ConsoleView.getInstance().showInfo(ConsoleView.getInstance().presenter.searchFile(name));
            
            String confirmation = ConsoleView.getInstance().writeInfo("Escriba el nombre del archivo de nuevo para confirmar la eliminación:");
            
            if(name.equalsIgnoreCase(confirmation)){
                ConsoleView.getInstance().showInfo(ConsoleView.getInstance().presenter.deleteFile(name));
            } else {
                ConsoleView.getInstance().showError("Los nombres no coinciden");
            }
        }
        catch(FileNotFoundException e){
            ConsoleView.getInstance().showError(e.getMessage());
        }
    }
}