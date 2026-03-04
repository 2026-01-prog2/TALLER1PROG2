package co.edu.uptc.interfaces;

import java.util.List;

public interface ModelInterface {

    List<String> search(String initialRoute, String name, boolean includeDirectories);

    long fileSize(String route);

    boolean delete(String route);

    String moveRoute(String initialRoute, String finalRoute);
}
