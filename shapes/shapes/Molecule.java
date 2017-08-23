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
        Back.changeSize(90,90);
        Back.changeColor("black");
        
        Up.changeSize(30, 30);
        Rigth.changeSize(30, 30);
        Down.changeSize(30, 30);
        Left.changeSize(30, 30);
        
        Up.moveHorizontal(30);
        Rigth.moveHorizontal(60);
        Rigth.moveVertical(30);
        Left.moveVertical(30);
        Down.moveHorizontal(30);
        Down.moveVertical(60);
        
        isVisible = false;
        cadena = datos;
        arreglo = cadena.toCharArray();
        longitud = arreglo.length;
        for (int i = 0; i < longitud; i++){
            if (i == 0){
                identificador(arreglo[i], Up);
            }else if (i == 3){
                identificador(arreglo[i], Rigth);
            }else if (i == 6){
                identificador(arreglo[i], Down);
            }else{
                identificador(arreglo[i], Left);
            }
        }
    }
    private void identificador(char s, Rectangle p){
        if (s == 'A'){
            p.changeColor("yellow");
        }else if(s == 'B'){
            p.changeColor("blue");
        }else if(s == 'C'){
            p.changeColor("magenta");
        }else if(s == 'D'){
            p.changeColor("green");
        }else if (s == '0'){
            p.changeColor("red");
        }else{
            Exception e;
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
        Up.makeInvisible();
        Down.makeInvisible();
        Rigth.makeInvisible();
        Left.makeInvisible();
        isVisible = false;
    }
}
