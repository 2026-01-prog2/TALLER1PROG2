import co.edu.uptc.presenter.Runner;

public class Main{
    public static void main(String[] parameters) {

        try {
            validParameter(parameters);
            Runner runner = new Runner();
            runner.start(parameters[0]);

        } catch (Exception e) {
            System.out.println("-------------------");
            System.out.println(e.getMessage());
            System.out.println("Uso:  java -jar TallerMVPTrabajoGrupal-main.jar c:/datos");
            System.out.println("-------------------");
        }

    }


    private static void  validParameter(String[] parameters) throws Exception {
        if   (parameters.length!=1) {
            throw new Exception("Ingrese la ruta inical como parámetro");
            }
    }

}

