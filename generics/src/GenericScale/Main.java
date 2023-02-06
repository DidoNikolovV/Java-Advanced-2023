package GenericScale;

public class Main {
    public static void main(String[] args) {
        Scale<String> stringScale = new Scale<>("a", "b");
        System.out.println(stringScale.getHeavier());
    }
}
