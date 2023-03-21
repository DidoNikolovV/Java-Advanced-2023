package TrafficLights;

import java.util.List;

public class TrafficLight {

    private Light currentLight;

    public TrafficLight(Light currentLight) {
        this.currentLight = currentLight;
    }

    public Light getCurrentLight() {
        return currentLight;
    }

    public void changeColor() {

        switch(currentLight) {
            case RED:
                this.currentLight = Light.GREEN;
                break;
            case GREEN:
                this.currentLight = Light.YELLOW;
                break;
            case YELLOW:
                this.currentLight = Light.RED;
                break;
            default:
                throw new IllegalArgumentException("Invalid light");
        }
    }
}
