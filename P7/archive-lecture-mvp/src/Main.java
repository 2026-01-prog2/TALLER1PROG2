import co.edu.uptc.presenter.Runner;

public class Main {
    public static void main(String[] args) throws Exception {
        try {
            args = new String[]{ };
            validParameter(args);
            Runner runner = new Runner();
            runner.start(args);
        } catch (Exception e) {
            System.out.println("-------------------");
            System.out.println(e.getMessage());
            System.out.println("Uso:  java -jar src.jar c:/datos");
            System.out.println("-------------------");
        }
    }


    private static void  validParameter(String[] parameters) throws Exception {
        if (parameters.length!=1)  throw new Exception("Parametros incorrectos");
    }


}
