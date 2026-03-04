package co.edu.uptc;
import co.edu.uptc.presenter.Runner;

public class Main {
    public static void main(String[] args) {
        try{
            validateParameter(args);
            Runner runner = new Runner();
            runner.start(args[0]);
        }catch(Exception e){
            System.out.println("-------------------------");
            e.printStackTrace();
            System.out.println(e.getMessage());
            System.out.println("-------------------------");
        }
    }

    static void validateParameter(String [] args) throws Exception{
        if(args.length != 1){
            throw new Exception("Parámetros Inválidos");
        }
    }
}
