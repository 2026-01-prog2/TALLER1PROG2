package co.edu.uptc.interfaces;

import java.util.List;

public interface PresenterInterface {

    void startMenu(String initialRoute);
     List<String> acctionOption1(String initialRoute);
     List<String> acctionOption2(String initialRoute,String name);
     List<String> acctionOption3(String initialRoute);
     Long acctionOption4(String initialRoute);
     boolean acctionOption5(String routeToDelete);
}