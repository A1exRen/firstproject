package writeandreadutility;

import utility.TextStructure;

import java.io.*;
import java.util.ArrayList;

import static utility.LogWriter.write;

public class Writeobject {
    public static void writingfile(ArrayList ar) {

        File file = new File("D:\\Prog\\Disk\\Text_information\\TextInfo.bin");
        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(ar);
            oos.close();
            write(3);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}