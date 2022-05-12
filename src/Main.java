import scanner.Scanforuser;
import secfunct.Console;
import secfunct.TextWriter;
import utility.TextStructure;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

import static secfunct.AnalyzerFunct.*; //???????? ??? ?????? ?? ????? AnalyzerFunct
import static utility.FileUnit.*;


public class Main {
    public static void main(String[] args) throws IOException {



       /* Scanner in = new Scanner(System.in);
        System.out.print("Input a text: ");
        String text = in.nextLine();
        System.out.print("Add path: ");
        String new_path = in.nextLine();
        System.out.print("Add to file: ");
        Boolean value = in.nextBoolean();
        TextWriter line = new TextWriter ( new_path, value );
        line.fileWriter(text);*/



       Scanner scanner = new Scanner(System.in);
        Scanforuser scannerForTest = new Scanforuser(scanner);
        Console consoleCommands = new Console(scannerForTest);
        consoleCommands.scanningProcess();

     /*   Scanner in = new Scanner(System.in);

        System.out.print("Input ID: ");
        System.out.print("Input a text: ");
        String text = in.nextLine();*/
     /*   Scanner in = new Scanner(System.in);
        String path = "D:\\Prog\\Arrive";
        String dpath = "D:\\Prog\\Disk";
        Integer count = CountFile(path);
        if (count > 0) {
            System.out.println("Count of new files: "+ count);
            File p= new File(path);
            readFiles(p);
        } else {
            System.out.print("Not new files");
        }
        String nametext = in.nextLine();
        String ptext= "D:\\Prog\\Arrive\\"+nametext;
        String dtext= "D:\\Prog\\Disk\\"+nametext;
        System.out.println(ptext);
        File pt = new File(ptext);
        File dt = new File(dtext);
        copyFileUsingFileChannels(pt,dt);*/


    }
}
