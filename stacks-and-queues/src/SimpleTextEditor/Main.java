package SimpleTextEditor;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        StringBuilder text = new StringBuilder();

        StringBuilder commandBuilder = new StringBuilder();


        ArrayDeque<String[]> commands = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
           String[] cmdParts = scanner.nextLine().split("\\s+");

           int command = Integer.parseInt(cmdParts[0]);
           switch(command) {
               case 1:
                   String textToAppend = cmdParts[1];
                   append(text, textToAppend);
                   commands.push(cmdParts);
                   break;
               case 2:
                   int numberOfElementsToErase = Integer.parseInt(cmdParts[1]);
                   erase(text, numberOfElementsToErase);
                   commands.push(cmdParts);
                   break;
               case 3:
                   int index = Integer.parseInt(cmdParts[1]);
                   getElementAtIndex(text, index);
                   break;
               case 4:
                   cmdParts = commands.pop();
                   command = Integer.parseInt(cmdParts[0]);
                   if(command == 1) {
                       append(text, cmdParts[1]);
                   } else if(command == 2) {
                       erase(text, Integer.parseInt(cmdParts[1]));
                   }
           }
        }
    }

    public static void append(StringBuilder builder, String text) {
        builder.append(text);
    }

    public static void erase(StringBuilder builder, int numberOfElementsToErase) {
        for (int j = 0; j < numberOfElementsToErase; j++) {
            builder.deleteCharAt(builder.length() - 1);
        }
    }

    public static void getElementAtIndex(StringBuilder builder, int index) {
        System.out.println(builder.charAt(index - 1));
    }

}
