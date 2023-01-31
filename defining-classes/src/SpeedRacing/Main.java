package SpeedRacing;

import javax.management.modelmbean.ModelMBean;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Set<Car> cars = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            String carsInfo = scanner.nextLine();
            String[] tokens = carsInfo.split("\\s+");
            String model = tokens[0];
            double fuelAmount = Double.parseDouble(tokens[1]);
            double fuelCostPerKm = Double.parseDouble(tokens[2]);
            Car car = new Car(model, fuelAmount, fuelCostPerKm);
            cars.add(car);
        }

        String inputCommand = scanner.nextLine();

        while(!inputCommand.equals("End")) {
            String[] tokens = inputCommand.split("\\s+");
            String model = tokens[1];
            int amountOfKm = Integer.parseInt(tokens[2]);

            Car car = cars.stream().filter(c -> c.getModel().equals(model)).collect(Collectors.toList()).get(0);
            car.drive(amountOfKm);

            inputCommand = scanner.nextLine();
        }

        cars.forEach(c -> System.out.println(c.toString()));
    }
}
