import java.awt.*;
import java.util.*;

/**
 * La clase Molecula recibe como parametro String para representar una molecula 
 * 
 * @author  Paola Cuellar y Nicolás Cárdenas
 * @version 1.0  (22 August 2017)
 */

public class Molecule{
    private Rectangle back;
    private Rectangle up;
    private Rectangle left;
    private Rectangle down;
    private Rectangle rigth;
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
        // Instanciacion de variables
        up = new Rectangle();
        rigth = new Rectangle();
        left = new Rectangle();
        down = new Rectangle();
        upsign = new Circle();
        rigthsign = new Circle();
        leftsign = new Circle();
        downsign = new Circle();
        tempr = new Rectangle();
        tempc = new Circle();
        // Creacion del fondo del la molecula
        back = new Rectangle();
        back.changeSize(90,90);
        back.changeColor("black");
        // Modificacion de tamaño de los objetos
        up.changeSize(30, 30);
        rigth.changeSize(30, 30);
        down.changeSize(30, 30);
        left.changeSize(30, 30);
        upsign.changeSize(20);
        rigthsign.changeSize(20);
        leftsign.changeSize(20);
        downsign.changeSize(20);        
        // Modificacion de la posición de los objetos
        up.moveHorizontal(30);
        rigth.moveHorizontal(60);
        rigth.moveVertical(30);
        left.moveVertical(30);
        down.moveHorizontal(30);
        down.moveVertical(60);
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
                identificador(arreglo[i], up);
                identificador(arreglo[i+1],upsign);
            }else if (i == 3){
                identificador(arreglo[i], rigth);
                identificador(arreglo[i+1],rigthsign);
            }else if (i == 6){
                identificador(arreglo[i], down);
                identificador(arreglo[i+1],downsign);
            }else if (i == 9){
                identificador(arreglo[i], left);
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
     * Retorna el tipo de la clase Molecula
     */
    public String getType(){
        return "<Molecule>";
    }
    /**
     *Se hace visible el objeto 
     */
    public void makeVisible(){
        back.makeVisible();
        up.makeVisible();
        down.makeVisible();
        rigth.makeVisible();
        left.makeVisible();
        upsign.makeVisible();
        rigthsign.makeVisible();
        leftsign.makeVisible();
        downsign.makeVisible();
        isVisible = true;
    }
    /**
     * Se hace invisible el objeto
     */
    public void makeInvisible(){
        back.makeInvisible();
        up.makeInvisible();
        down.makeInvisible();
        rigth.makeInvisible();
        left.makeInvisible();
        upsign.makeInvisible();
        rigthsign.makeInvisible();
        leftsign.makeInvisible();
        downsign.makeInvisible();
        isVisible = false;
    }
    /**
     * Se refleja respecto al eje y 
     */
    public void reflect(){
       // Modificar la posicion invirtiendo la derecha por la izquierda
       rigth.moveHorizontal(-60); 
       rigthsign.moveHorizontal(-60);
       left.moveHorizontal(60);
       leftsign.moveHorizontal(60);
       // Asignacion de las referencias de los cuadrados
       tempr = rigth;
       rigth = left;
       left = tempr;
       // Asignacion de las referencias de los circulos
       tempc = rigthsign;
       rigthsign = leftsign;
       leftsign = tempc;
    }
    /**
     * Se rota en el sentido de las manecillas del reloj
     */
    public void rotate(){
        // Rotacion en bloque de los cuadrados
        up.moveHorizontal(30);
        up.moveVertical(30);
        rigth.moveHorizontal(-30);
        rigth.moveVertical(30);
        down.moveHorizontal(-30);
        down.moveVertical(-30);
        left.moveHorizontal(30);
        left.moveVertical(-30);
        // Rotacion en bloque de los circulos
        upsign.moveHorizontal(30);
        upsign.moveVertical(30);
        rigthsign.moveHorizontal(-30);
        rigthsign.moveVertical(30);
        downsign.moveHorizontal(-30);
        downsign.moveVertical(-30);
        leftsign.moveHorizontal(30);
        leftsign.moveVertical(-30);
        // Asignacion de las referencias de los cuadrados
        tempr = up;
        up = left;
        left = down;
        down = rigth;
        rigth = tempr;
        // Asignacion de las referencias de los circulos
        tempc = upsign;
        upsign = leftsign;
        leftsign = downsign;
        downsign = rigthsign;
        rigthsign = tempc;
    }
    /**
     * Mover la molecula hacia abajo
     */
    public void moveDown(){
        back.moveVertical(90);
        up.moveVertical(90);
        down.moveVertical(90);
        rigth.moveVertical(90);
        left.moveVertical(90);
        upsign.moveVertical(90);
        rigthsign.moveVertical(90);
        leftsign.moveVertical(90);
        downsign.moveVertical(90);
    }
    /**
     * Mover la molecula hacia la derecha
     */
    public void moveRight(){
        back.moveHorizontal(90);
        up.moveHorizontal(90);
        down.moveHorizontal(90);
        rigth.moveHorizontal(90);
        left.moveHorizontal(90);
        upsign.moveHorizontal(90);
        rigthsign.moveHorizontal(90);
        leftsign.moveHorizontal(90);
        downsign.moveHorizontal(90);
    }
}
