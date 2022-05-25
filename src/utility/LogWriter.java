package utility;

import java.util.Date;

public class LogWriter {
    public static void write(Integer k) {
        Date date = new Date();
        String curtime = date.toString();
        if (k == 0)
            System.out.println(curtime + ":" + " " + "Text saved");
        if (k == 1)
            System.out.println(curtime + ":" + " " + "Text not saved, already exist");
        if (k == 2)
            System.out.println(curtime + ":" + " " + "Text name add to array");
        if (k == 3)
            System.out.println(curtime + ":" + " " + "Array was write");

    }
}

