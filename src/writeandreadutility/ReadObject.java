package writeandreadutility;

import utility.TextStructure;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;


public class ReadObject {


    public static ArrayList readingfile() {
           File file = new File("D:\\Prog\\Disk\\Text_information\\TextInfo.bin");
        ArrayList<TextStructure> list = new ArrayList<TextStructure>();
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            list = (ArrayList) ois.readObject();
            ois.close();



        }catch (IOException e) {
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return list;

    }
}
