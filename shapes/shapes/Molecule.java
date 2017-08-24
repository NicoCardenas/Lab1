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
    private Circle upsign;
    private Circle leftsign;
    private Circle rigthsign;
    private Circle downsign;
    private Rectangle tempr;
    private Circle tempc;
    
    /**
     * Constructor del Objeto Molecula
     */
    public Molecule(String datos){
        // Instanciacion de la variables
        Up = new Rectangle();
        Rigth = new Rectangle();
        Left = new Rectangle();
        Down = new Rectangle();
        upsign = new Circle();
        rigthsign = new Circle();
        leftsign = new Circle();
        downsign = new Circle();
        tempr = new Rectangle();
        tempc = new Circle();
        // Creacion del fondo del la molecula
        Back = new Rectangle();
        Back.changeSize(90,90);
        Back.changeColor("black");
        // Modificacion de tamaño de los objetos
        Up.changeSize(30, 30);
        Rigth.changeSize(30, 30);
        Down.changeSize(30, 30);
        Left.changeSize(30, 30);
        upsign.changeSize(20);
        rigthsign.changeSize(20);
        leftsign.changeSize(20);
        downsign.changeSize(20);        
        // Modificacion de la posición de los objetos
        Up.moveHorizontal(30);
        Rigth.moveHorizontal(60);
        Rigth.moveVertical(30);
        Left.moveVertical(30);
        Down.moveHorizontal(30);
        Down.moveVertical(60);
        upsign.moveHorizontal(80);
        rigthsign.moveHorizontal(110);
        rigthsign.moveVertical(30);
        leftsign.moveVertical(30);
        leftsign.moveHorizontal(50);
        downsign.moveHorizontal(80);
        downsign.moveVertical(60);
        // determinacion y asignacion de la cadena entrante
        isVisible = false;
        cadena = datos;
        arreglo = cadena.toCharArray();
        longitud = arreglo.length;
        for (int i = 0; i < longitud; i++){
            if (i == 0){
                identificador(arreglo[i], Up);
                identificador(arreglo[i+1],upsign);
            }else if (i == 3){
                identificador(arreglo[i], Rigth);
                identificador(arreglo[i+1],rigthsign);
            }else if (i == 6){
                identificador(arreglo[i], Down);
                identificador(arreglo[i+1],downsign);
            }else if (i == 9){
                identificador(arreglo[i], Left);
                identificador(arreglo[i+1],leftsign);
            }
        }
    }
    /**
     * la asigna el color al objeto (rectangulo) de la posicion del parametro
     * @param s una caracter tipo char
     * @param p un objeto tipo Rectangle
     */
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
            p.changeColor("black");
        }
    }
    /**
     * la asigna el color al objeto (circulo) de la posicion del parametro
     * @param s una caracter tipo char
     * @param p un objeto tipo Circle
     */
    private void identificador(char s, Circle p){
        if (s == '+'){
            p.changeColor("white");
        }else if(s == '-'){
            p.changeColor("black");
        }else{
            p.changeColor("red");
        }
    }
    /**
     *Se hace visible el objeto 
     */
    public void makeVisible(){
        Back.makeVisible();
        Up.makeVisible();
        Down.makeVisible();
        Rigth.makeVisible();
        Left.makeVisible();
        upsign.makeVisible();
        rigthsign.makeVisible();
        leftsign.makeVisible();
        downsign.makeVisible();
        isVisible = true;
    }
    /**
     *Se hace invisible el objeto
     */
    public void makeInvisible(){
        Back.makeInvisible();
        Up.makeInvisible();
        Down.makeInvisible();
        Rigth.makeInvisible();
        Left.makeInvisible();
        upsign.makeInvisible();
        rigthsign.makeInvisible();
        leftsign.makeInvisible();
        downsign.makeInvisible();
        isVisible = false;
    }
    /**
     *Se refleja respecto al eje y 
     */
    public void reflect(){
       //Rigth.moveHorizontal(-60); 
       //rigthsign.moveHorizontal(-60);
       //Left.moveHorizontal(60);
       //leftsign.moveHorizontal(60);
       tempr = Rigth;
       tempc = rigthsign;
       Rigth = Left;
       rigthsign = leftsign;
       Left = tempr;
       leftsign = tempc;
    }
    /**
     *Se rota en el sentido de las manecillas del reloj
     */
    public void rotate(){
        
    }
    /**
     * 
     */
    public void moveDown(){
        Back.moveDown();
        Up.moveDown();
        Down.moveDown();
        Rigth.moveDown();
        Left.moveDown();
        upsign.moveDown();
        rigthsign.moveDown();
        leftsign.moveDown();
        downsign.moveDown();
    }
    /**
     * 
     */
    public void moveRight(){
        Back.moveRight();
        Up.moveRight();
        Down.moveRight();
        Rigth.moveRight();
        Left.moveRight();
        upsign.moveRight();
        rigthsign.moveRight();
        leftsign.moveRight();
        downsign.moveRight();
    }
}
