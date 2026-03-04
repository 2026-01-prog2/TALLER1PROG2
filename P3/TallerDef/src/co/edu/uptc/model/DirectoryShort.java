package co.edu.uptc.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

public class DirectoryShort {
    private FilenameFilter filter;  
    private List<File> results;
    private long size = 0;

    public DirectoryShort(){
        results = new ArrayList<>();
    }

    public String convertSize(long size){
        String convertedSize = "";
        if(size > 1024){
            convertedSize = size/1024 + "KB";
        } else if(size > (1024*1024)){
            convertedSize = size/(1024*1024) + "MB";
        } else if(size > (1024*1024*1024)){
            convertedSize = size/(1024*1024*1024) + "GB";
        }
        return convertedSize;
    }

    public String convertSize(File file){
        return this.convertSize(file.length());
    }

    public String pathAndSize(String name, File folder) throws FileNotFoundException {
        results = searchFileByName(name, folder);
        String out = "";
        for (File file : results) {
        out += "Archivo encontrado, ubicación: " + file.getAbsolutePath() + "\nTamaño: " + convertSize(file) + "\n";
        }
        
        return out;
    }

    public List<File> searchFileByName(String name, File folder) throws FileNotFoundException{ //factorizar
        if(name.contains("*") || name.contains("?")){
            if(name.contains("*")){
                asteriskFilter(name);
            }
            else if(name.contains("?")){
                qMarkFilter(name);
            }
            searchWithFilter(name, folder);
        }        
        else{
            recursiveSearching(folder, name);            
        }
        if(results.size() == 0){
            throw new FileNotFoundException("Archivo no encontrado");
        }
        return results;
    }    

    public void asteriskFilter(String name){
        filter = new FilenameFilter() {
            public boolean accept(File dir, String title) {
                return title.endsWith(name.substring(1, name.length()));
            }
        };
    }

    public void recursiveSearching(File folder, String name){
        File[] content = folder.listFiles();
        if(content != null){
            for (File file : content) {
                if (file.isFile() && file.getName().equalsIgnoreCase(name)) {
                    results.add(file);
                } else if (file.isDirectory()) {
                    recursiveSearching(file, name);
                }
            }
        }
    }

    public void qMarkFilter(String path){
        String regex = path.replace("." , "\\.").replace("?", ".");
        filter = new FilenameFilter() {
            public boolean accept(File dir, String title){
                return title.matches(regex);
            }
        };
    }

    public List<File> searchWithFilter(String name, File folder){
        File[] content = folder.listFiles();
        if(content != null){
            for(File file : content){
                if(file.isDirectory()){
                    searchWithFilter(name, file);
                }else if(!results.contains(file)){ 
                    File[] filteredContent = folder.listFiles(filter);
                    for(File filteredFile : filteredContent){
                        results.add(filteredFile);
                    }
                }
            }
        }
        return results;
    }

    public String directorySize(File folder){
        File[] content = folder.listFiles();
        if(content != null){
            for (File file : content) {
                if (file.isFile()) {
                    size += file.length();
                } else if (file.isDirectory()) {
                    directorySize(file);
                }
            }
        }
        return "Ruta absoluta: " + folder.getAbsolutePath() + "\nTamaño: " + convertSize(size); 
    }

    public String validateType(File file){
        String out;
        if(file.isDirectory()){
            out = "Directorio";
        }
        else{
            out = "Archivo";
        }
        return out;
    }

    public String getFolderInfo(String name, File folder)throws Exception{
        File directoryResult = searchDirectory(name, folder);
        return validateFolder(directoryResult);
    }

    public String validateFolder(File directoryResult) throws Exception{
        String out = "";
        if(directoryResult != null){
            File[] content = directoryResult.listFiles();
            out = folderDetails(content);
        }else{
            throw new FileNotFoundException("Directorio no encontrado");
        }
        return out;
    }

    public String folderDetails(File[] content) throws Exception{
        String out = "";
        if(content.length != 0){
                for(File file : content){
                    if(file.isDirectory()){
                        out += "Tipo: " + validateType(file) + "\nNombre: " + file.getName() + "\n" + directorySize(file) + "\n------------------------------------------\n";
                    }else{
                        out += "Tipo: " + validateType(file) + "\nNombre: " + file.getName() + "\n" + "Tamaño: " + convertSize(file) + "\n------------------------------------------\n";
                    }
                }
            }else{
            throw new Exception("Directorio vacío");
        }
        return out;
    }

    public File checkName(File file, String name){
        File out = null;
        if(file.isDirectory() && file.getName().equalsIgnoreCase(name)){
            out = file;
        }
        else if(file.isDirectory()){
            searchDirectory(name, file);
        }
        return out;
    }

    public File searchDirectory(String name, File folder){
        File[] content = folder.listFiles();
        File out = null;
        int i = 0;
        if(content != null){
            while(i < content.length && out == null){
                out = checkName(content[i], name);
                i++;
            }
        }
        return out;
    }

    public String deleteFile(String name, File folder)throws FileNotFoundException{
        String out = "";
        if(name.equals(searchFileByName(name, folder).get(0).getName())){
            searchFileByName(name, folder).get(0).delete();
            out = "archivo borrado existosamente";
        }
        else{
            throw new FileNotFoundException("Archivo no encontrado");
        }
        return out;  
    }
}

