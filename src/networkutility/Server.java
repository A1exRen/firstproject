package networkutility;

import utility.TextStructure;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.nio.ByteBuffer;

import static utility.LogWriter.write;

public class Server {
    private static int PORT = 2123;
    private static String HOST = "localhost";
    private static String FOLDER = "D:\\Prog\\Disk\\Text";

    public static void main(String[] args) {
        try (Socket s = new Socket(HOST, PORT);
             InputStream in = s.getInputStream()) {

            // Читаем размер имени
            int nameSize;
            while ((nameSize = in.read()) != -1) {
                // Читаем само имя
                byte[] name = new byte[nameSize + 1];
                in.read(name, 0, nameSize);
                // Преобразовываем обратно в строку
                String fileName = new String(name, "utf-8").trim();

                File file = new File(FOLDER + "/" + fileName);
                if (file.exists() && file.isFile()) {
                    write(1); // Прерывание из за совпадении имени только при первом вхождении
                    break;
                }
                TextStructure.putData(fileName);

                try (FileOutputStream out = new FileOutputStream(file)) {
                    // Читаем размер файл
                    byte[] fileSizeBuf = new byte[8];
                    in.read(fileSizeBuf, 0, 8);
                    // Преобразовываем в long
                    ByteBuffer buf = ByteBuffer.allocate(Long.BYTES);
                    buf.put(fileSizeBuf);
                    buf.flip();
                    long fileSize = buf.getLong();

                    // Читаем содержимое файла блоками по килобайту
                    int read = 0;
                    byte[] data = new byte[1024];
                    while (read < fileSize) {
                        read += in.read(data);
                        // И пишем в файл
                        out.write(data);
                    }
                }
                catch(IOException exc) {
                    exc.printStackTrace();
                }
                }
            write(0);
            }
          catch(IOException exc){
                exc.printStackTrace();
                return;
            }
        }
    }
