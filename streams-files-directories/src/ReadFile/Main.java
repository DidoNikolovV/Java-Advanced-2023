package ReadFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) {
        String filePath = "D:\\Java-Advanced-2023\\streams-files-directories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        try (InputStream inputStream = new FileInputStream(filePath)) {
            int readByte = inputStream.read();

            while(readByte >= 0) {
                System.out.printf("%s ", Integer.toBinaryString(readByte));

                readByte = inputStream.read();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

//        InputStream inputStream = new FileInputStream(filePath);
//
//        int firstByte = inputStream.read();
//
//        System.out.println(firstByte);
//
//        inputStream.close();

    }
}
