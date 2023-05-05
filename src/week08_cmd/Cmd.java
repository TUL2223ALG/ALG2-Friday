package week08_cmd;

import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;

public class Cmd {

    private File actualDir;

    public Cmd() {
        actualDir = new File(System.getProperty("user.dir"));
    }

    public String getActualDir() {
        return actualDir.getAbsolutePath();
    }

    public String dir() {
        return this.dirGeneral(actualDir);
    }
    
    public String dir(String relativeDir) {
        File directory = new File(actualDir, relativeDir);
        return this.dirGeneral(directory);
    }
    
    private String dirGeneral(File directory) {
        this.checkValidDirectory(directory);
        FileFilter filter = new FileFilter() {
            public boolean accept(File file) {
                return !file.getName().startsWith(".");
            }
        };
        File[] sub = directory.listFiles(filter);
        StringBuilder sb = new StringBuilder();
        StringBuilder adr = new StringBuilder();
        for (File f : sub) {
            if(f.isFile()){
                sb.append(String.format("%-20s %10d %n", f.getName(), f.length()));
            }else{
                adr.append(String.format("%-20s %10d %n", f.getName(), f.length()));
            }
        }
        StringBuilder res = new StringBuilder();
        res.append(adr.append(sb));
        
        return res.toString();
        
    }
    
    public void cd(String dir){
        File directory;
        if("..".equals(dir)){
            directory = actualDir.getParentFile();
        }else{
            directory = new File(actualDir, dir);
        }
        this.checkValidDirectory(directory);
        actualDir = directory;
    }
    
    private void checkValidDirectory(File dir){
        if(!dir.exists()){
            throw new NotValidPath("directory " + dir.getAbsolutePath() + " not found");
        }
        if(dir.isFile()){
            throw new NotValidPath(dir.getName() + " is not a directory");
        }
    }
    
}
