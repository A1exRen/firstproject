package secfunct;

import java.awt.*;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TextWriter {
    private String path_to_file;
    private boolean append = false;
    private int Id;



    public TextWriter (String path, boolean value) {
        path_to_file = path;
        append = value; //мы укажем, будем ли мы добавлять текст к файлу, либо перезаписывать весь файл(true (добавить в файл), либо false (не добавлять)).

    }
    public void fileWriter (String text) throws IOException { //узнать про IOException!!!!!
        FileWriter write_to_file = new FileWriter(path_to_file, append); // FileWriter записывает только байты.
        PrintWriter print = new PrintWriter(write_to_file); //передать простой текст FileWriter с помощью класса PrintWriter
        text ="#"+ Id +": " + text +" "+(java.time.LocalDate.now()+" "+java.time.LocalTime.now());
        print.printf("%s" + "%n", text);
        print.close();
    }
}
