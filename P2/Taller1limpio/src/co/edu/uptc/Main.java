package co.edu.uptc;

import co.edu.uptc.presenter.FileRunner;

public class Main {
    public static void main(String[] args) {
        try {
            validParameter(args);
            new FileRunner().run(args[0]);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            System.err.println("Uso: java -jar app <ruta_directorio>");
        }
    }

    private static void validParameter(String[] args) throws Exception {
        if (args.length != 1)
            throw new Exception("Debe proporcionar exactamente una ruta de directorio.");
    }
}