package co.edu.uptc.main;
import co.edu.uptc.model.FileManagerGeneral;
import co.edu.uptc.presenter.Presenter;
import co.edu.uptc.view.View;
public class Main {
public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Debe ingresar la ruta inicial como parámetro.");
            return;
        }

        Presenter p = new Presenter();
        View v = new View();
        p.setView(v);
        p.setModel(new FileManagerGeneral(args[0]));
        v.setPresenter(p);
        p.start();
    }
}
