import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) throws FileNotFoundException {
        String basePath = "D:\\Java-Advanced-2023\\streams-files-directories\\04. Java-Advanced-Files-and-Streams-Lab-Resources";
        String inputPath = basePath + "\\input.txt";
        Scanner scanner = new Scanner(new FileInputStream(inputPath));

        try {
            int number = Integer.parseInt(scanner.nextLine());
            System.out.println(number);
        } catch(NumberFormatException exceptionVariableName) {
            System.out.println("Sorry this was not a number!");
        }
    }
}
