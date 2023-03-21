package TrafficLights;

public enum Light {
    RED("RED"),
    GREEN("GREEN"),
    YELLOW("YELLOW");

    private String color;

    Light(String color) {
        this.color = color;
    }
}
