package JarOfT;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Jar<Integer> jarOfIntegers = new Jar<>();

        jarOfIntegers.add(5);

        Integer number = jarOfIntegers.remove();
        System.out.println(number);
    }
}
