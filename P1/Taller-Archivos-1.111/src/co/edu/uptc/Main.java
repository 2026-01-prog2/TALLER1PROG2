package co.edu.uptc;

import co.edu.uptc.presenter.Runner;

public class Main {

    public static void main(String[] args) {
        try {
            if (args.length == 0) {
                System.out.println("Debe proporcionar una ruta inicial como argumento.");
                return;
            } 
            String initialRoute = args[0];
            Runner runner = new Runner();
            runner.start(initialRoute);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}