package _03_Animals;

public class Dog extends Animal{
    public Dog(String name, String favouriteFood) {
        super(name, favouriteFood);
    }

    @Override
    String explainSelf() {
        return "I am " + this.name + " and my favourite food is " + this.favouriteFood + " DJAAF";
    }
}
