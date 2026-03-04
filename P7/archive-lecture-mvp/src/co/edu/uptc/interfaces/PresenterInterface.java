package co.edu.uptc.interfaces;


public interface PresenterInterface {
    public void setView(ViewInterface view);
    public void setModel(ModelInterface model);
    public void setPath(String path);
    public String getPath();
    public String showFileInfo(String directory);
    public String deleteFile(String file);

}
