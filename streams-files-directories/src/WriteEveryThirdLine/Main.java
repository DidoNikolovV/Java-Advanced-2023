package WriteEveryThirdLine;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        String basePath = "D:\\Java-Advanced-2023\\streams-files-directories\\04. Java-Advanced-Files-and-Streams-Lab-Resources";
        String inputPath = basePath + "\\input.txt";
        String outputPath = basePath + "\\05.WriteEveryThirdLineOutput.txt";

        BufferedReader reader = new BufferedReader(new FileReader(inputPath));
        PrintWriter writer = new PrintWriter(new FileWriter(outputPath));

        int counter = 1;
        String line = reader.readLine();
        while(line != null) {
            if(counter % 3 == 0) {
                writer.println(line);
            }
            counter++;
            line = reader.readLine();
        }

        reader.close();
        writer.close();
    }
}
