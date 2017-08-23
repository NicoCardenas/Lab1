import java.awt.*;
import java.util.*;

/**
 * Write a description of class Molecule here.
 * 
 * @author  Paola Cuellar y Nicolás Cárdenas
 * @version 1.0  (22 August 2017)
 */

public class Molecule{
    private Rectangle Back;
    private Rectangle Up;
    private Rectangle Left;
    private Rectangle Down;
    private Rectangle Rigth;
    private String cadena;
    private boolean isVisible;
    private char[] arreglo;
    private int longitud;
    
    /**
     * Constructor for objects of class Molecule
     */
    public Molecule(String datos){
        Up = new Rectangle();
        Rigth = new Rectangle();
        Left = new Rectangle();
        Down = new Rectangle();
        
        Back = new Rectangle();
        Back.changeSize(50,50);
        Back.changeColor("green");
        
        isVisible = false;
        cadena = datos;
        arreglo = cadena.toCharArray();
        longitud = arreglo.length;
        for (int i = 0; i < longitud; i++){
            //System.out.println(i);
            if (arreglo[i] == 'A'){
                Up.changeColor("yellow");
            }else if(arreglo[i] == 'B'){
                Up.changeColor("blue");
            }else if(arreglo[i] == 'C'){
                Up.changeColor("orange");
            }else if(arreglo[i] == 'D'){
                Up.changeColor("black");
            }else if (arreglo[i] == '0'){
                Up.changeColor("red");
            }else{
                Exception e;
            }
        }
    }
    public void makeVisible(){
        Back.makeVisible();
        Up.makeVisible();
        Down.makeVisible();
        Rigth.makeVisible();
        Left.makeVisible();
        isVisible = true;
    }
    public void makeInvisible(){
        Back.makeInvisible();
        isVisible = false;
    }
}
