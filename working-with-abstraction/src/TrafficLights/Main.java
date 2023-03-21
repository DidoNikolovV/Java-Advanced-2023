package TrafficLights;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<Light> lights = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Light::valueOf)
                .collect(Collectors.toList());

        TrafficLight trafficLight = new TrafficLight(lights);

        int numberOfIterations = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfIterations; i++) {
            for (Light light : trafficLight.lights) {
                light.setLight().changeColor(light);
                System.out.print(light + " ");
            }

            System.out.println();
        }


    }
}
