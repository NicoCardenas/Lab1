import java.awt.*;
import java.util.*;
import java.awt.Graphics;

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
    private String[] arreglo;
    
    /**
     * Constructor for objects of class Molecule
     */
    public Molecule(String datos){
        back = new Rectangle();
        back.changeSize(50,50);
        back.changeColor("yellow");
        isVisible = false;
        cadena = datos;
        //arreglo = cadena.toCharArray();
        //System.out.println(Arrays.toString(arreglo));
        //System.out.println(arreglo[0]);
        arreglo = cadena.split(" ");
    }
    public void makeVisible(){
        back.makeVisible();
        isVisible = true;
        draw();
    }
    public void makeInvisible(){
        back.makeInvisible();
        isVisible = false;
    }
    /*
     * Draw the rectangle with current specifications on screen.
     */

    private void draw() {
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.drawString(cadena, (float)15.0, (float)10.0);
            canvas.wait(10);
        }
    }
}
