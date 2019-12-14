package eg.edu.alexu.csd.oop.ClassesImplemented.Shapes.Pool;

import eg.edu.alexu.csd.oop.ClassesImplemented.Shapes.Plates.*;
import eg.edu.alexu.csd.oop.ClassesImplemented.Shapes.Plates.Plate;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.util.HashMap;

public class PlatePool {
    private static PlatePool pp = null;
    private HashMap<String, Plate >platePool;
    private PlatePool() {
        platePool = new HashMap<String, Plate>();
    }

    public static PlatePool getInstance() {
        if (pp == null) {
            pp = new PlatePool();
        }
        return (PlatePool) pp;
    }
    public boolean exists (String type){
        return platePool.containsKey(type);
    }
    public void add (Plate p){
       platePool.put(p.getColor() , p);
    }
    public Plate get (String type){
        if(this.exists(type))return (Plate)platePool.remove(type);
        else throw new NullPointerException("GameObject Doesn't Exist in Pool");
    }
}