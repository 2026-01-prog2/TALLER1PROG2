package co.edu.uptc.model;

import co.edu.uptc.interfaces.ModelInterface;
import java.io.File;
import java.io.FileNotFoundException;
public class ArchiveActions implements ModelInterface {

    ModelUtil util = new ModelUtil();
    private String path;

    @Override

    public String getFileInfo(String fullPath) throws Exception {
        String info = util.checkPath(fullPath);
        File newPath = new File(info);
        try {
            if (newPath.exists()){
                if (newPath.isDirectory()) info = printDirInfo(newPath);
                else if (newPath.isFile()) info = "Nombre: " + newPath.getName() + "\n" +"Ruta: " + newPath.getAbsolutePath() + "\n" +"Tamaño: " + newPath.length() + " Bytes" + "\n" +"Tamaño Directorio padre: " + util.calculateDirectorySize(newPath.getParentFile()) + " KB";
            }else throw new FileNotFoundException("Archivo o carpeta no encontrado");
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return info;
    }

    @Override
    public String deleteFile(String name) throws Exception{
        String status = "";
        try {
            File file = new File(name);
            if (file.exists()){
                file.delete();
                status = "Archivo o carpeta eliminado exitosamente";
            }else throw new Exception("Archivo o carpeta no encontrado");
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return status;
    }

    private String printDirInfo(File dir) throws Exception{
          StringBuilder metadata = new StringBuilder("Contenido de la carpeta: " + dir.getName() +'\n');
                    for (File file : dir.listFiles()) {
                        metadata.append("   ").append(file.getName()+" ");
                        if(file.isDirectory()) metadata.append(util.calculateDirectorySize(file) +" KB"+"\n").append(getFileInfo(file.getAbsolutePath()));
                        else metadata.append(file.length() +" Bytes"+"\n");
                        }
        return metadata.toString();
    }
    
    public void setPath(String path) throws Exception{
        if (path.isEmpty()) throw new Exception("La ruta no puede estar vacía");
        else this.path = path;
    }

    public String getPath(){
        return path;
    }


}
