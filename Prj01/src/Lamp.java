
public class Lamp {
    private double illuminance;

    public Lamp(double illuminance) {
        this.illuminance = illuminance;
    }

    public Lamp() {
        this.illuminance = 100;
    }


    public double getIlluminance() {
        return illuminance;
    }
}
