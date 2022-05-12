package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Files;


public class FileUnit {
    static int filecount = 0;


    public static int CountFile(String dirPath) {
        File f = new File(dirPath);
        File[] files = f.listFiles();
        if (files != null)
            for (int i = 0; i < files.length; i++) {
                filecount++;
                File file = files[i];

                if (file.isDirectory()) {
                    CountFile(file.getAbsolutePath());
                }

            }
        return filecount;

    }

    public static void readFiles(File baseDirectory) {
        if (baseDirectory.isDirectory()) {
            for (File file : baseDirectory.listFiles()) {
                if (file.isFile()) {
                    System.out.println(file.getName() + " файл");
                } else {
                    System.out.println(file.getName() + " каталог");
                    readFiles(file);
                }
            }
        }
    }

    public static void copyFileUsingFileChannels(File source, File dest) throws IOException {
        FileChannel inputChannel = null;
        FileChannel outputChannel = null;
        try {
            inputChannel = new FileInputStream(source).getChannel();
            outputChannel = new FileOutputStream(dest).getChannel();
            outputChannel.transferFrom(inputChannel, 0, inputChannel.size());
        } finally {
            inputChannel.close();
            outputChannel.close();

        }
    }
}