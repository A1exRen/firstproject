package utility;

import writeandreadutility.InfoTextArray;
import writeandreadutility.ReadObject;
import writeandreadutility.Writeobject;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;


public class TextStructure implements Serializable {
    @Serial
    private static final long serialVersionUID = 6529685098267757690L;
    private int Id;
    private  String textName;
    private  String addedAt;

    public int getid(){
        return Id;
    }
     public String gettextName() {
        return textName;
     }


    public TextStructure(Integer Id, String textName, String addedAt){
        this.textName=textName;
        this.addedAt=addedAt;
        this.Id=Id;
    }
    public String toString() {
        return "{"+Id+","+textName+","+addedAt+"}";
    }



    public static void putData(String textName){
        System.out.println(textName);
        ArrayList<TextStructure> textArray = new ArrayList<TextStructure>();
        textArray = ReadObject.readingfile();//Чтения массива из файла
        textArray = InfoTextArray.setData(textArray, textName); // Добавление названия текста и даты в массив
        Writeobject.writingfile(textArray); //Запись массива в файл



    }
}

