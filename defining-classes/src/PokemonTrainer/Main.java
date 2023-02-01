package PokemonTrainer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        List<Trainer> trainers = new LinkedList<>();

        while(!line.equals("Tournament")) {
            String[] tokens = line.split("\\s+");
            String trainerName = tokens[0];
            String pokemonName = tokens[1];
            String pokemonElement = tokens[2];
            int pokemonHealth = Integer.parseInt(tokens[3]);

            boolean exists = false;

            Trainer trainer = new Trainer(trainerName);
            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);

            for (Trainer t : trainers) {
                if(t.getName().equals(trainerName)) {
                    t.getPokemons().add(pokemon);
                    exists = true;
                }
            }

            if(!exists) {
                trainer.addPokemon(pokemon);
                trainers.add(trainer);
            }

            line = scanner.nextLine();
        }

        String input = scanner.nextLine();
        while(!input.equals("End")) {
            String element = input;
            for (Trainer trainer : trainers) {
                boolean found = false;
                List<Pokemon> trainerPokemons = trainer.getPokemons();
                for (Pokemon pokemon : trainerPokemons) {
                    if(pokemon.getElement().equals(element)) {
                        found = true;
                        break;
                    }
                }

                if(found) {
                    trainer.increaseBadges();
                } else {
                    trainer.decreasePokemonsHealthBy10();
                    trainer.destroyPokemon();
                }
            }

            input = scanner.nextLine();
        }

        List<Trainer> sortedTrainersByBadges = trainers.stream().sorted((f, s) -> s.getBadges() - f.getBadges()).collect(Collectors.toList());
        sortedTrainersByBadges.forEach(t -> System.out.println(t.toString()));
    }
}
