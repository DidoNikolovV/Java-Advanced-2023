package CountCharacterTypes;

import java.io.*;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        String inputPath = "D:\\Java-Advanced-2023\\streams-files-directories\\resources\\input.txt";
        String outputPath = "D:\\Java-Advanced-2023\\streams-files-directories\\resources\\04.output.txt";

        BufferedReader br = new BufferedReader(new FileReader(inputPath));
        PrintWriter pw = new PrintWriter(outputPath);

        String line = br.readLine();

        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        Set<Character> punctuation = Set.of('!', ',', '.', '?');

        int vowelsCount = 0;
        int symbols = 0;
        int punctuationCount = 0;
        while(line != null) {
           for(char c : line.toCharArray()) {
               if(c == ' ') {
                   continue;
               } else if(vowels.contains(c)) {
                   vowelsCount++;
               } else if(punctuation.contains(c)) {
                   punctuationCount++;
               } else {
                   symbols++;
               }
           }

           line = br.readLine();

        }

        pw.println("Vowels: " + vowelsCount);
        pw.println("Other symbols: " + symbols);
        pw.println("Punctuation: " + punctuationCount);

        br.close();
        pw.close();
    }
}
