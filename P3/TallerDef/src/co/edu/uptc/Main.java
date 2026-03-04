package co.edu.uptc;

import co.edu.uptc.presenter.Runner;

public class Main {
    public static void main(String[] parameters) {

        try {
            validateParameter(parameters);
            Runner runner = new Runner();
            runner.start(parameters[0]);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("-------------------");
            System.out.println(e.getMessage());
            System.out.println("Uso:  java -jar TallerDef Directorio");
            System.out.println("-------------------");
        }

    }


    private static void validateParameter(String[] parameters) throws Exception {
        if(parameters.length!=1) {
            throw new Exception("Parámetros incorrectos.");
        }else {
            String pathDirectory = "Directorio";
        }
    }
}


