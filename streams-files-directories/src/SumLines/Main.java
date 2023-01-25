package SumLines;

import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        String inputPath = "D:\\Java-Advanced-2023\\streams-files-directories\\resources\\input.txt";

        BufferedReader br = new BufferedReader(new FileReader(inputPath));
        String line = br.readLine();
        while(line != null) {
            long sum = 0;
            for(char ch : line.toCharArray()) {
                sum += ch;
            }

            System.out.println(sum);
            line = br.readLine();
        }
    }
}
