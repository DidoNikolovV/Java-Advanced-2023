import java.security.KeyStore;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ApocalypsePreparation {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Deque<Integer> textiles = new ArrayDeque<>();
        Deque<Integer> medicaments = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(textiles::offer);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(medicaments::push);

        Map<Integer, String> healingItems = new HashMap<>();
        healingItems.put(30, "Patch");
        healingItems.put(40, "Bandage");
        healingItems.put(100, "MedKit");

        int medKitValue = 100;

        Map<String, Integer> itemsCreated = new TreeMap<>();

        String item;

        while(!textiles.isEmpty() && !medicaments.isEmpty()) {
            int textile = textiles.poll();
            int medicament = medicaments.pop();

            int sum = textile + medicament;

            if(healingItems.containsKey(sum)) {
                item = healingItems.get(sum);
                createItem(itemsCreated, item);
            } else if(sum > medKitValue) {
                sum -= medKitValue;
                medicament = medicaments.pop();
                medicaments.push(sum + medicament);
                item = "MedKit" ;
                createItem(itemsCreated, item);
            } else {
                medicament += 10;
                medicaments.push(medicament);
            }
        }

        if(textiles.isEmpty() && medicaments.isEmpty()) {
            System.out.println("Textiles and medicaments are both empty.");
        } else if(textiles.isEmpty()) {
            System.out.println("Textiles are empty.");
        } else if(medicaments.isEmpty()) {
            System.out.println("Medicaments are empty.");
        }


        itemsCreated.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(entry -> System.out.println(entry.getKey() + " - " + entry.getValue()));

        if(medicaments.size() > 0) {
            System.out.printf("Medicaments left: %s%n", medicaments.toString().replaceAll("[\\[\\]]", ""));
        }

        if(textiles.size() > 0) {
            System.out.printf("Textiles left: %s%n", textiles.toString().replaceAll("[\\[\\]]", ""));
        }

    }

    public static void createItem(Map<String, Integer> items, String item) {
        if(!items.containsKey(item)) {
            items.put(item, 0);
        }

        int oldValue = items.get(item);
        items.put(item, oldValue + 1);
    }
}
