package co.edu.uptc;

import java.io.File;

import co.edu.uptc.presenter.Runner;

public class Main{
    public static void main(String[] args) {

        try {
            String path = validParameter(args);
            Runner runner = new Runner();
            runner.start(path);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("-------------------");
            System.out.println(e.getMessage());
            System.out.println("Uso:  java -jar TallerMVP c:/datos");
            System.out.println("-------------------");
        }
    }

    private static String validParameter(String[] args) throws Exception {
        if(args.length!=1) {
            throw new Exception("Parametros incorrectos aaaaa");
        }
        File directory = new File(args[0]);
        if (!directory.exists() || !directory.isDirectory()) {
            throw new Exception("La ruta proporcionada no existe o no es un directorio valido");
        }
        return args[0];
    }
}