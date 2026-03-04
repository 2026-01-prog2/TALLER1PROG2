package co.edu.uptc.model;

import java.io.File;

    public class DeleteFile {

        private String nameToSearch;
        
        public void setNameToSearch(String nameToSearch) {
            this.nameToSearch = nameToSearch;
        }
        

        public boolean deleteFileRecursive(File directory, String nameToSearch) {
            setNameToSearch(nameToSearch);
            File[] list = directory.listFiles();

            if (list != null) {
                return findInList(list);
            }
            return false;
        }

        public boolean findInList(File[] list){
            for (File file : list) {
                    if (findFile(file)) return true;
                } 
                return false;
        }

        private boolean findFile(File file) {
            if (file.isDirectory()) {
                return deleteFileRecursive(file, nameToSearch);
            }
            return checkAndDelete(file);
        }

        private boolean checkAndDelete(File file) {
            if (file.getName().equalsIgnoreCase(nameToSearch)) {
                return file.delete();
            }
            return false;
        }
}
