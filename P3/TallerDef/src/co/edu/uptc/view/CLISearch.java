package co.edu.uptc.view;

import java.io.Console;
import java.io.FileNotFoundException;

public class CLISearch {
    private String name;
    
    public void showFileData(){
        try{
            name = ConsoleView.getInstance().writeInfo("Digite el nombre del archivo que desea buscar:");
            String data = ConsoleView.getInstance().presenter.searchFile(name);
            ConsoleView.getInstance().showInfo(data);
        }
        catch(FileNotFoundException e){
            ConsoleView.getInstance().showError(e.getMessage());
        }
    }
    public void showDirectoryData(){
        try{
            name = ConsoleView.getInstance().writeInfo("Digite el nombre del directorio cuya información desea mostrar");
            ConsoleView.getInstance().showInfo(ConsoleView.getInstance().presenter.directoryInfo(name));
        }
        catch (Exception e) {
            ConsoleView.getInstance().showError(e.getMessage());
        }
    }
    public String searchFileToDelete(){
        try {
            name = ConsoleView.getInstance().writeInfo("Digite el nombre del archivo que desea eliminar: ");
            String results;
            results = ConsoleView.getInstance().presenter.searchToDelete(name);
            ConsoleView.getInstance().showInfo("Rutas de los resultados: " + results);
        } catch (FileNotFoundException e) {
            ConsoleView.getInstance().showError(e.getMessage());
        }

        return name;
        
    }
}