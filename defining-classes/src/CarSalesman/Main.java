package CarSalesman;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nEngine = Integer.parseInt(scanner.nextLine());

        List<Engine> engines = new LinkedList<>();
        Engine engine = new Engine();
        for (int i = 0; i < nEngine; i++) {
            String engineData = scanner.nextLine();
            String[] tokens = engineData.split("\\s+");
            String model = tokens[0];
            int power = Integer.parseInt(tokens[1]);
            if(tokens.length == 2) {
                engine = new Engine(model, power);
            } else if(tokens.length == 3) {
                if(Character.isDigit(tokens[2].charAt(0))) {
                    int displacement = Integer.parseInt(tokens[2]);
                    engine = new Engine(model, power, displacement);
                } else {
                    String efficiency = tokens[2];
                    engine = new Engine(model, power, efficiency);
                }
            } else {
                int displacement = Integer.parseInt(tokens[2]);
                String efficiency= tokens[3];
                engine = new Engine(model, power, displacement, efficiency);
            }

            engines.add(engine);
        }

        int mCars = Integer.parseInt(scanner.nextLine());
        Car car = new Car();

        List<Car> cars = new LinkedList<>();
        for (int i = 0; i < mCars; i++) {
            String carData = scanner.nextLine();
            String[] tokens = carData.split("\\s+");

            String model = tokens[0];
            Engine carEngine = engines.stream().filter(e -> e.getModel().equals(tokens[1])).collect(Collectors.toList()).get(0);

            if(tokens.length == 2) {
                car = new Car(model, carEngine);
            } else if(tokens.length == 3) {
                if(tokens[2] != null) {
                    String color = tokens[2];
                    car = new Car(model, carEngine, color);
                } else {
                    int weight = Integer.parseInt(tokens[2]);
                    car = new Car(model, carEngine, weight);
                }
            } else {
                int weight = Integer.parseInt(tokens[2]);
                String color = tokens[3];
                car = new Car(model, carEngine, weight, color);
            }

            cars.add(car);
        }

        cars.forEach(c -> System.out.println(c.toString()));
    }
}
