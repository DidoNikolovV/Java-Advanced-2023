package _03_Random_Array_List;

public class Main {
    public static void main(String[] args) {
        RandomArrayList<String> rArrayList = new RandomArrayList<>();
        rArrayList.add("Pesho");
        rArrayList.add("Tisho");
        rArrayList.add("Gosho");
        rArrayList.add("Dido");
        System.out.println(rArrayList.getRandomElement());
        System.out.println(rArrayList.getRandomElement());
    }
}
