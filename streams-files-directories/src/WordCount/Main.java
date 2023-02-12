package WordCount;

import java.io.*;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        String wordsPath = "D:\\Java-Advanced-2023\\streams-files-directories\\resources\\words.txt";
        String textPath = "D:\\Java-Advanced-2023\\streams-files-directories\\resources\\text.txt";

        String outputPath = "D:\\Java-Advanced-2023\\streams-files-directories\\resources\\result.txt";

        BufferedReader br = new BufferedReader(new FileReader(wordsPath));
        BufferedWriter bw = new BufferedWriter(new FileWriter(outputPath));

        List<String> words = br.lines().toList();
        for(String w : words) {
            System.out.println(w);
        }




    }
}
