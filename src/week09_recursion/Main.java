package week09_recursion;

import java.io.File;
import java.io.FilenameFilter;

public class Main {

    public static void main(String[] args) {

        File dir = new File(System.getProperty("user.dir"), "src");
        System.out.println(recursiveDir(dir, 0));

    }

    public static long fact(long n) {
        if (n <= 1) { //base case
            return 1;
        }
        return n * fact(n - 1);
    }

    public static String recursiveDir(File dir, int level) {
        String dirContents = "";
        File[] fileArray = dir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return !name.startsWith(".");
            }
        });
        for (File f : fileArray) {
            dirContents = dirContents + "\n" + getSpaces(level) + f.getName();
            if (f.isDirectory()) {
                dirContents = dirContents + recursiveDir(f, (level + 1));

            }
        }
        return dirContents + "\n";

    }

    public static String getSpaces(int level) {
        String space = "-";
        for (int i = 0; i <= level; i++) {
            space = " " + space;
        }
        return space;
    }
}
