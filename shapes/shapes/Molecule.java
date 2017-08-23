import java.awt.*;

/**
 * Write a description of class Molecule here.
 * 
 * @author  Paola Cuellar y Nicolás Cárdenas
 * @version 1.0  (22 August 2017)
 */

public class Molecule{
    private Rectangle back;
    private String cadena;
    private boolean isVisible;
    
    /**
     * Constructor for objects of class Molecule
     */
    public Molecule(String cadena){
        back = new Rectangle();
        back.changeSize(50,50);
        back.changeColor("yellow");
        isVisible = false;
    }
    public void makeVisible(){
        back.makeVisible();
    }
    public void makeInvisible(){
        back.makeInvisible();
    }
}
