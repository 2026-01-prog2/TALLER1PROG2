package co.edu.uptc.view;

import java.io.File;
import java.util.List;

public class ListDirectoryCli {
    public void exec(){
        List <File> list = ConsoleView.getInstance().presenter.listDirectory();
        System.out.println("---------------------------------");
        for(File f:list){
            System.out.println(f.getAbsolutePath()+"\n");
        }
    }
}
