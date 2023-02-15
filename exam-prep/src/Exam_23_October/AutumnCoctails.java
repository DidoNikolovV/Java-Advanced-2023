package Exam_23_October;

import java.util.*;

public class AutumnCoctails {
    public static void main(String[] args) {
        Scanner  scanner = new Scanner(System.in);

        Deque<Integer> ingredients = new ArrayDeque<>();
        Deque<Integer> freshness = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(ingredients::offer);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(freshness::push);

        Map<Integer, String> coctailsData = new HashMap<>();
        coctailsData.put(150, "Pear Sour");
        coctailsData.put(250, "The Harvest");
        coctailsData.put(300, "Apple Hinny");
        coctailsData.put(400, "High Fashion");

        Map<String, Integer> cocktailsMade = new TreeMap<>();

        while(!ingredients.isEmpty() && !freshness.isEmpty()) {
            int ingredient = ingredients.peek();
            int freshnessLevel = freshness.peek();

            if(ingredient == 0) {
                ingredients.poll();
                continue;
            }

            int totalFreshnessLevel = ingredient * freshnessLevel;

            if(coctailsData.containsKey(totalFreshnessLevel)) {
                String cocktail = coctailsData.get(totalFreshnessLevel);
                makeCocktail(cocktailsMade, cocktail);
                ingredients.poll();
                freshness.pop();
            } else {
                freshness.pop();
                ingredient += 5;
                ingredients.poll();
                ingredients.offer(ingredient);
            }


        }

        if(cocktailsMade.size() >= 4) {
            System.out.println("It's party time! The cocktails are ready!");
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }

        if(ingredients.size() > 0) {
            int sum = 0;
            for (Integer ingredient : ingredients) {
                sum += ingredient;
            }

            System.out.println("Ingredients left: " + sum);
        }

        for(var entry: cocktailsMade.entrySet()) {
            System.out.printf(" # %s --> %d%n", entry.getKey(), entry.getValue());
        }
    }


    public static void makeCocktail(Map<String, Integer> cocktailsMade, String cocktail) {
        if(!cocktailsMade.containsKey(cocktail)) {
            cocktailsMade.put(cocktail, 0);
        }

        int oldValue = cocktailsMade.get(cocktail);
        cocktailsMade.put(cocktail, oldValue + 1);
    }
}
