package SortLines;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String basePath = "D:\\Java-Advanced-2023\\streams-files-directories\\04. Java-Advanced-Files-and-Streams-Lab-Resources";
        String inputPath = basePath + "\\input.txt";
        String outputPath = basePath + "\\06.SortLinesOutput.txt";

        Path path = Path.of(inputPath);
        PrintStream writer = new PrintStream(new FileOutputStream(outputPath));

        try {
            List<String> sortedLines = Files.readAllLines(path);
            Collections.sort(sortedLines);
            for(String line : sortedLines) {
                writer.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
