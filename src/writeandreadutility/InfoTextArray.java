package writeandreadutility;

import utility.TextStructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import static utility.LogWriter.write;

public class InfoTextArray {


    public static ArrayList<TextStructure> setData(ArrayList<TextStructure> ar, String t) {

            Date date = new Date();
            String curtime= date.toString();//������������ ������� ����� �������� ���� �� ���� ������ �������� ������
            Integer k = ar.size()+1;//������������ Id ������ �������� ������
            TextStructure obj = new TextStructure(k,t,curtime);
            ar.add(obj);
            write(2);
            System.out.println(ar);
            return ar;

        }
}
