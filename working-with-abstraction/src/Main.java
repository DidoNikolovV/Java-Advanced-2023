import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int bottomLeftX = Integer.parseInt(input[0]);
        int bottomLeftY = Integer.parseInt(input[1]);
        int topRightX = Integer.parseInt(input[2]);
        int topRightY = Integer.parseInt(input[3]);

        Point a = new Point(bottomLeftX, bottomLeftY);
        Point b = new Point(topRightX, topRightY);

        Rectangle rect = new Rectangle(a, b);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            int[] coordinates = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int x = coordinates[0];
            int y = coordinates[1];
            Point p = new Point(x, y);
            System.out.println(rect.contains(p));
        }
    }
}
