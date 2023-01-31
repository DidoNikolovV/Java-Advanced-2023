package RawData;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<Car> cars = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String[] tokens = input.split("\\s+");
            List<Tire> tires = new ArrayList<>();
            String model = tokens[0];
            int engineSpeed = Integer.parseInt(tokens[1]);
            int enginePower = Integer.parseInt(tokens[2]);
            Engine engine = new Engine(engineSpeed, enginePower);

            int cargoWeight = Integer.parseInt(tokens[3]);
            String cargoType = tokens[4];
            Cargo cargo = new Cargo(cargoWeight, cargoType);

            for (int j = 5; j < 12; j+=2) {
                double tirePressure = Double.parseDouble(tokens[j]);
                int tireAge = Integer.parseInt(tokens[j + 1]);
                Tire tire = new Tire(tirePressure, tireAge);
                tires.add(tire);
            }

            Car car = new Car(model, engine, cargo, tires);
            cars.add(car);
        }

        String line = scanner.nextLine();
        if(line.equals("fragile")) {
            for (Car car : cars) {
                List<Tire> currentTires = car.getTires();
                double totalPressure = 0;
                for (Tire currentTire : currentTires) {
                    totalPressure += currentTire.getPressure();
                }
                totalPressure /= currentTires.size();
                if(car.getCargo().getType().equals("fragile") && totalPressure < 1) {
                    System.out.println(car.getModel());
                }
            }
        } else if(line.equals("flamable")) {
            for (Car car : cars) {
                if(car.getCargo().getType().equals("flamable") && car.getEngine().getPower() > 250) {
                    System.out.println(car.getModel());
                }
            }
        }
    }
}
