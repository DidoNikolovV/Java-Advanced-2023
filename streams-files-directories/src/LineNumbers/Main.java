package LineNumbers;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String inputPath = "D:\\Java-Advanced-2023\\streams-files-directories\\resources\\inputLineNumbers.txt";
        String outputPath = "D:\\Java-Advanced-2023\\streams-files-directories\\resources\\05.output.txt";

        BufferedReader br = new BufferedReader(new FileReader(inputPath));
        PrintWriter pr = new PrintWriter(new FileWriter(outputPath));

        String line = br.readLine();
        int lineNumber = 1;
        while(line != null) {
            pr.printf("%d. %s%n", lineNumber, line);
            lineNumber++;
            line = br.readLine();
        }

        br.close();
        pr.close();
    }
}
