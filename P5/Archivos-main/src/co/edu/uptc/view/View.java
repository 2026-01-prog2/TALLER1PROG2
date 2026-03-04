package co.edu.uptc.view;
import co.edu.uptc.interfaces.PresenterInterface;
import co.edu.uptc.interfaces.ViewInterface;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class View implements ViewInterface {

    private PresenterInterface presenter;
    private final Scanner scanner = new Scanner(System.in);
    private final Map<String, Runnable> actions = new HashMap<>();

    @Override 
    public void setPresenter(PresenterInterface presenter) {
        this.presenter = presenter; initializeActions();
    }

    private void initializeActions() {
        actions.put("1", () -> actionOption1());
        actions.put("2", () -> actionOption2());
        actions.put("3", () -> actionOption3());
        actions.put("4", () -> actionOption4());
        actions.put("5", () -> System.exit(0));
    }

    @Override 
    public void start() {
        while (true) {
            showMenu();
            Runnable action = actions.get(readInput());
            if (action != null) action.run();
            else showMessage("Opción inválida.");
        }
    }

    private String request(String msg) {
        System.out.print(msg); return readInput();
    }

    @Override 
    public void showMenu() {
        showMessage("Selecione una opcion\n1.Buscar \n2.Tamaño \n3.Listar \n4.Eliminar \n5.Salir");
    }

    @Override 
    public String readInput() {
        return scanner.nextLine();
    }

    @Override 
    public void showFiles(List<File> files) {
        for (File file : files) System.out.println(file.getAbsolutePath());
    }

    private void actionOption1() {
        showMessage("Nombre archivo:");
        presenter.searchFile(readInput());
    }

    private void actionOption2() {
        showMessage("Ubicación (sin ruta inicial)");
        presenter.showSize(readInput());
    }

    private void actionOption3() {
        showMessage("Ubicación (Sin la ruta inicial):");
        presenter.listDirectory(readInput());
    }

    private void actionOption4() {
        showMessage("Ruta archivo (Sin la raiz y con la extensión):");
        presenter.deleteFile(readInput());
    }

    @Override 
    public void showSize(long size) {
        System.out.println("Tamaño: " + size + " bytes");
    }

    @Override 
    public void showMessage(String message) {
        System.out.println(message);
    }
}