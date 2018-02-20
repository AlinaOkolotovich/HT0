/**
 * Created by okolotovich on 2/19/18.
 */
public class Furniture {
    String name;
    double size;

    public Furniture(){
        this.name = "default name";
    }
    public Furniture(String name) {
        this.name = name;
        this.size = 1;
    }
     public Furniture(String name, double size){
         this.name = name;
         this.size = size;
     }

    public double getSize() {
        return size;
    }
}
