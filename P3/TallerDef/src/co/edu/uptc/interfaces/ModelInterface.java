package co.edu.uptc.interfaces;

import java.io.FileNotFoundException;

public interface ModelInterface {
    String exec() throws Exception;

    void validaAllPath(String path) throws FileNotFoundException;

    String callToSearchFile(String name) throws FileNotFoundException;

    void setPath(String path);

    String callToGetSize();

    String callToFolderInfo(String name) throws Exception;

    String searchToDelete(String name) throws FileNotFoundException;

    void confirmedDeletion(String name) throws FileNotFoundException;
}
