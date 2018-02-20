import java.util.List;

/**
 * Created by okolotovich on 2/15/18.
 */
public class Main {
    public static void main(String[] args) {
       Building b = new Building("House#1");

       b.addRoom("kitchen", 27.21, 3);
       b.addRoom("children room", 23.04, 2);

       System.out.println(b.getRoom("kitchen").name.toString());
       b.getRoom("kitchen").addLamp(5, 1000);
       b.describe();
    }
}