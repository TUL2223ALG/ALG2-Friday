package week08_cmd;

import java.io.File;
import java.util.Scanner;

public class CmdApp {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
//        System.out.println(System.getProperty("user.dir"));
//        System.out.println(System.getProperty("file.separator"));
//        String s = "C:" + System.getProperty("file.separator") + "Users"; // "C:\Users"
//        
//        String path = System.getProperty("user.dir");
//        File actualDir = new File(path);
//        File[] sub = actualDir.listFiles();
//        for (File f : sub) {
//            System.out.println(String.format("%15s %10d", f.getName(), f.length()));
//        }

        Cmd cmd = new Cmd();
        String command;
        String[] parts;
        boolean work = true;
        while (work) {

            System.out.print(cmd.getActualDir() + ">");
            command = sc.nextLine(); //dir Desktop
            parts = command.split(" "); //pole o 2 prvcich 
            try {
                switch (parts[0]) {
                    case "dir":
                        if (parts.length > 1){
                            System.out.println(cmd.dir(parts[1]));
                        }else{
                            System.out.println(cmd.dir());
                        }
                        break;
                    case "cd":
                        cmd.cd(parts[1]);
                        break;
                    case "exit":
                        work = false;
                        break;
                    default:
                        System.out.println("'" + parts[0] + "' is not recognized "
                                + "as an internal or external command,operable program or batch file.");
                }
            }catch(NotValidPath e){
                System.out.println(e.getMessage());
            }
        }
    }

}
