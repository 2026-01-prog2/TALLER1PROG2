package co.edu.uptc.model;

import java.io.File;

    public class CalculateSize {

        public long calculateSizeRecursive(File file) {
            if (!exists(file)) return -1;
            if (isFile(file)) return getFileSize(file);
            return calculateDirectory(file);
        }

        private boolean exists (File file) {
            return file.exists();
        }

        private boolean isFile (File file) {
            return file.isFile();
        }

        private long getFileSize (File file) {
            return file.length();
        }

        private long calculateDirectory (File directory) {
            File[] list = getFiles(directory);
            return sumList(list);
        }

        private File[] getFiles (File directory) {
            return directory.listFiles();
        }

        private long sumList (File[] list) {
            if (list == null) return 0;

            long total = 0;
            for (File file : list) {
                total += file.length();
            }
            return total;
        }
}
