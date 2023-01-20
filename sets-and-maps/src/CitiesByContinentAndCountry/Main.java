package CitiesByContinentAndCountry;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Map<String, LinkedHashMap<String, List<String>>> towns = new LinkedHashMap<>();
        for(int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String[] inputParts = input.split("\\s+");
            String continent = inputParts[0];
            String country = inputParts[1];
            String city = inputParts[2];

            List<String> cities = new ArrayList<>();

            if(!towns.containsKey(continent)) {
                towns.put(continent, new LinkedHashMap<>());
                towns.get(continent).put(country, cities);
            }

            if(!towns.get(continent).containsKey(country)) {
                towns.get(continent).put(country, cities);
            }

            List<String> oldCities = towns.get(continent).get(country);
            oldCities.add(city);
            towns.get(continent).put(country, oldCities);

        }

        for(var entry : towns.entrySet()) {
            String continent = entry.getKey();
            System.out.println(continent + ":");
            for(var city : entry.getValue().entrySet()) {
                System.out.print("  " + city.getKey() + " -> ");
                String result = String.join(", ",  city.getValue());
                System.out.println(result);
            }
        }
    }
}
