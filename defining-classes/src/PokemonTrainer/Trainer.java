package PokemonTrainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private String name;
    private int badges;
    private List<Pokemon> pokemons;

    public Trainer(String name) {
        this.name = name;
        this.badges = 0;
        this.pokemons = new ArrayList<>();
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }

    public void increaseBadges() {
        this.badges++;
    }

    public void decreasePokemonsHealthBy10() {
        for (Pokemon pokemon : this.pokemons) {
            pokemon.reduceHealthBy10();
        }
    }

    public String getName() {
        return name;
    }

    public int getBadges() {
        return badges;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void destroyPokemon() {
        this.pokemons.removeIf(pokemon -> pokemon.getHealth() <= 0);
    }

    @Override
    public String toString() {
        return String.format("%s %d %d",
                this.name,
                this.badges,
                this.pokemons.size()
        );
    }
}
