package co.edu.uptc.model;

import java.io.File;

public class SearchFile {

        private String regexPattern;


        public void setRegexPattern(String regexPattern) {
            this.regexPattern = regexPattern;
        }

        public String searchFileRecursive(File directory, String regexPattern) {
        setRegexPattern(regexPattern);
        File[] list = directory.listFiles();

        if (list != null) {
            return searchInList(list);
        } return null;
        }

        private String searchInList(File[] list) {
            for (File file : list) {
                String result = searchSingleFile(file);
                if (result != null) {
                    return result;
                }
            } 
            return null;
        }
        
        private String searchSingleFile(File file){
            if (file.isDirectory()) {
                return searchFileRecursive(file, regexPattern);
                } else if(file.getName().toLowerCase().matches(regexPattern)){
                    return "El archivo fue encontrado en la ubicación: " + file.toString();
                }
                return null;
        }
}
