package _03_Animals;

public class Cat extends Animal {
    public Cat(String name, String favouriteFood) {
        super(name, favouriteFood);
    }

    @Override
    String explainSelf() {
        return "I am " + this.name + " and my favourite food is " + this.favouriteFood + " MEEOW";
    }

}
