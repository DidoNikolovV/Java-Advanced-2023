import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) throws IOException {
        String basePath = "D:\\Java-Advanced-2023\\streams-files-directories\\04. Java-Advanced-Files-and-Streams-Lab-Resources";
        String inputPath = basePath + "\\input.txt";
        Scanner scanner = new Scanner(new FileInputStream(inputPath));

        try {
            int number = Integer.parseInt(scanner.nextLine());
            System.out.println(number);
        } catch(NumberFormatException exceptionVariableName) {
            System.out.println("Sorry this was not a number!");
        }

        int readByte = System.in.read();
        while(readByte >= 0) {
            System.out.println(readByte);

            readByte = System.in.read();
        }
    }
}
