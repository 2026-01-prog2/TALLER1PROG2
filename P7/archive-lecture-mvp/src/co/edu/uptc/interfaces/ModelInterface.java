package co.edu.uptc.interfaces;

public interface ModelInterface {
    String getFileInfo(String name) throws Exception;
    String deleteFile(String name) throws Exception;
    void setPath(String path) throws Exception;
    String getPath() throws Exception;

}
