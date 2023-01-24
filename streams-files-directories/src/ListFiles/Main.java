package ListFiles;

import java.io.*;
import java.nio.file.Path;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        String basePath = "D:\\Java-Advanced-2023\\streams-files-directories\\04. Java-Advanced-Files-and-Streams-Lab-Resources";
        String outputPath = basePath + "\\output.txt";


        PrintWriter writer = new PrintWriter(new FileWriter(outputPath));
        File file = new File("D:\\Java-Advanced-2023\\streams-files-directories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");
        File[] files = file.listFiles();
        for(int i = 0; i < files.length; i++) {
            if(!files[i].isDirectory()) {
                writer.printf("%s: [%d]%n", files[i].getName(), files[i].length());
            }
        }

        writer.close();

    }
}
