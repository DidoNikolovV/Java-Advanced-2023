package CustomList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        CustomList<String> myList = new CustomList<String>();

        while(!line.equals("END")) {
            String[] tokens = line.split("\\s+");

            switch(tokens[0]) {
                case "Add":
                    myList.add(tokens[1]);
                    break;
                case "Remove":
                    myList.remove(Integer.parseInt(tokens[1]));
                    break;
                case "Contains":
                    System.out.println(myList.contains(tokens[1]));
                    break;
                case "Swap":
                    myList.swap(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
                    break;
                case "Greater":
                    System.out.println(myList.countGreaterThan(tokens[1]));
                    break;
                case "Max":
                    System.out.println(myList.getMax());
                    break;
                case "Min":
                    System.out.println(myList.getMin());
                    break;
                case "Sort":
                    Sorter.sort(myList);
                    break;
                case "Print":
                    System.out.println(myList.toString());;
                    break;
            }
            line = scanner.nextLine();
        }
    }
}
