package co.edu.uptc.model;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Directory{
    private long size = 0;
    
    public String convertSize(File file){
        String convertedSize = "";
        if(file.length() > 1024){
            convertedSize = file.length()/1024 + "KB";
        } else if(file.length() > (1024*1024)){
            convertedSize = file.length()/(1024*1024) + "MB";
        } else if(file.length() > (1024*1024*1024)){
            convertedSize = file.length()/(1024*1024*1024) + "GB";
        }
        return convertedSize;
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

    public String pathAndSize(String name, File folder){
        List<File> results = searchFileByName(name, folder);
        String out = "";
        System.out.println("Tamano   "+results.size());
        for (File file : results) {
            if(file.exists()){
                String size = convertSize(file);
            out += "Archivo encontrado, ubicación: " + file.getAbsolutePath() + "\nTamaño: " + size + "\n";
            }else{
                out = "Archivo no encontrado";
            }  
        }
        return out;
    }

    public List<File> searchFileByName(String name, File folder){
        List<File> results = new ArrayList<>();
        switch (filter(name)) {
            case '?' -> thoseFiles(name, folder, results);
            case '*' -> theseFiles(name, folder, results);
            default -> recursiveSearching(folder, name, results);
        }
        return results;
    }

    public void recursiveSearching(File folder, String name, List<File> results){
        File[] content = folder.listFiles();
        if(content != null){
            for (File file : content) {
                if (file.isFile() && file.getName().equalsIgnoreCase(name)) {
                    results.add(file);
                } else if (file.isDirectory()) {
                    recursiveSearching(file, name, results);
                }
            }
        }
    }

    public char filter(String path){
        char letra = ' ';
        int i = 0;
        
        while(i < path.length() && !(letra == '*' || letra == '?')){
            System.out.println("Antes de entrar al charAt: " + letra);
            letra = path.charAt(i);
            System.out.println("Despues de entrar al charAt: " + letra);
            i++;
        }
            
        return letra;
    }

    public List<File> theseFiles (String path, File folder, List<File> results){ 
        File[] content = folder.listFiles();
        int nameSize = 0;
        int variable = 0; 
        char letter = ' ';
        String out = "";
        for(File file : content){
            if(file.isFile()){
                nameSize = file.getName().length(); 
                variable = nameSize - path.length();
                for(int i = variable + 1; i < nameSize; i++){
                    letter = file.getName().charAt(i);
                    out += letter;
                }
                out = "*" + out;
                if(out.equals(path)){
                    results.add(file);        
                }
                out = "";
            }
            else if(file.isDirectory()){
                theseFiles(path, file, results);
            }
        }  
        return results;
    }

    public List<File> thoseFiles(String name, File folder, List<File> results){
        File[] content = folder.listFiles();
        int pathSize = name.length();
        char letter = ' ';
        int i = 0;
        String out = "";
        while(i < pathSize && letter != '?'){
            System.out.println(i);
            System.out.println(letter);
            letter = name.charAt(i);
            i++;
        }
        for(File file : content){
            if(file.isFile()){
                for(int j = 0; j < file.getName().length(); j++){
                if((j+1) != i){
                    letter = file.getName().charAt(j);
                }
                else{
                    letter = '?';
                }
                out += letter;
            }
            if(out.equals(name)){
                results.add(file);
            }
            out = "";
            }else if(file.isDirectory()){
                thoseFiles(name, folder, results);
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
        return "name absoluta: " + folder.getAbsolutePath() + "\nTamaño: " + convertSize(size);
    }

    /*public List<File> showFiles(String name, File folder){
        
        File[] content = folder.listFiles();
        for(File archivo : content){
            if(folder.isDirectory() && folder.getName().equals(name)){

            }
        }


    }*/

    public void deleteFile(String name, File folder){
        searchFileByName(name, folder).get(0).delete();
    }
}
