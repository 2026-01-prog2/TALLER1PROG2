package co.edu.uptc.model;

import co.edu.uptc.interfaces.ModelInterface;

import java.io.File;

public class ModelManagerFile implements ModelInterface {

    private File initialRoute;


    public ModelManagerFile(String initialRoute) {
        this.initialRoute = new File(initialRoute);
    }
    @Override
    public String exec() throws Exception {
        return "";
    }
   @Override
    public String search(String name){
        return search(this.initialRoute, name);
    }

    public String search(File file, String name){
        File[] list = file.listFiles();
        StringBuilder searchFile = new StringBuilder();
        if (list != null) {
            for (File f : list) {
                if (f.getName().toLowerCase().contains(name.toLowerCase())) {
                    searchFile.append("Encontrado: ").append(f.getAbsolutePath()).append(" (").append(f.length()).append("bytes)\n");
                }
                if (f.isDirectory()) {
                    searchFile.append(search(f, name));
                }
            }
        }
        return searchFile.toString();
    }

    public File getInitialRoute() {
        return initialRoute;
    }

    public long getfolderSize(File folder) {
        long size = 0;
        File[] files = folder.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isFile()) {
                    size += f.length();
                }else {
                    size += getfolderSize(f);
                }
            }
        }
        return size;
    }

    public String listDirectory(){

        StringBuilder txt = new StringBuilder();
        File [] list = initialRoute.listFiles();

        if (list != null && list.length > 0) {
            txt.append("Contenido en: ").append(initialRoute.getPath());

            for(File f : list){
                String tipe = f.isDirectory() ? "[DIR]" : "[FILE]" ;

                txt.append("\n").append(tipe).append(" ").append(f.getName()).append(" - ").append(f.length()).append( " bytes\n");
            }
        } else{
            txt.append("La ruta esta vacia o no es un directorio valido");
        }
        return txt.toString();
    }

    public String deleteFile(String fileName){
        File fileToDelete = new File(initialRoute, fileName);

        if (!fileToDelete.exists()) {
            return "El archivo: " + fileName + " no existe en la ruta inicial.";
        }
        if (fileToDelete.isDirectory()) {
            return "Error: " + fileName + " es un directorio";
        }
        if (fileToDelete.delete()) {
            return "El archivo: " + fileName + " ha sido borrado permanentemente";
        }else{
            return "No se pudo borrar el archivo";
        }
    }
}
