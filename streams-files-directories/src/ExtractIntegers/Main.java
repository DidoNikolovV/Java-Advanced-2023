package ExtractIntegers;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String basePath = "D:\\Java-Advanced-2023\\streams-files-directories\\04. Java-Advanced-Files-and-Streams-Lab-Resources";
        String inputPath = basePath + "\\input.txt";
        String outputPath = basePath + "\\04.ExtractIntegersOutput.txt";

        Scanner reader = new Scanner(new FileInputStream(inputPath));
        PrintStream writer = new PrintStream(new FileOutputStream(outputPath));

        while(reader.hasNext()) {
            if(reader.hasNextInt()) {
                writer.println(reader.nextInt());
            }

            reader.next();
        }

    }
}
