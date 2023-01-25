package AllCapitals;

import java.io.*;
import java.nio.Buffer;

public class Main {
    public static void main(String[] args) throws IOException {
        String inputPath = "D:\\Java-Advanced-2023\\streams-files-directories\\resources\\input.txt";
        String outputPath = "D:\\Java-Advanced-2023\\streams-files-directories\\resources\\output.txt";

        BufferedReader br = new BufferedReader(new FileReader(inputPath));
        PrintWriter pw = new PrintWriter(new FileWriter(outputPath));

        String line = br.readLine();

        while(line != null) {
            for(char c : line.toCharArray()) {
                String letter = c + "";
                pw.write(letter.toUpperCase());
            }
            pw.println();
            line = br.readLine();
        }
        br.close();
        pw.close();
    }
}
