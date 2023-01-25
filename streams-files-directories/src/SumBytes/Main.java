package SumBytes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String inputPath = "D:\\Java-Advanced-2023\\streams-files-directories\\resources\\input.txt";

        BufferedReader br = new BufferedReader(new FileReader(inputPath));
        String line = br.readLine();
        long sum = 0;
        while(line != null) {
            for(char c : line.toCharArray()) {
                sum += c;
            }
            line = br.readLine();
        }

        System.out.println(sum);
    }
}
