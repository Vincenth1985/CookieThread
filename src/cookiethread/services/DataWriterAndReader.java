package cookiethread.services;


import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class DataWriterAndReader implements Serializable {


    ObjectOutputStream objectOutputStream;
    Path path = Paths.get("CookieSummary.txt");


    public void writeData(List cookieJarContent) {
        try {
            OutputStream os = new FileOutputStream(path.toFile());
            objectOutputStream = new ObjectOutputStream(os);
            objectOutputStream.writeObject(cookieJarContent);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
