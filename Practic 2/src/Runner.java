import by.gsu.asoilab.Material;
import by.gsu.asoilab.Subject;

public class Runner {
    public static void main(String[] args) {
        Subject wire = new Subject("wire", new Material("steel", 7850), 0.03);
        System.out.println(wire);
        wire.setMaterial(new Material("copper", 8500));
        System.out.println(wire.getMass());
        wire.setMaterial(new Material("steel", 7850));
        System.out.println(wire);
    }
}
