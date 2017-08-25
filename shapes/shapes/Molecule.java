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
    private Atomo[] atomos;
    private Atomo tempr;
    private boolean isVisible;
    private int[] position={30,60,90,60};
    private int[] rota={30,30,-30,-30};
    private int[] reflejo={0,-2,0,-2};
    private int posicion;
    
    /**
     * Constructor del Objeto Molecula
     * @param String datos entra una cadena
     */
    public Molecule(String datos){
        atomos = new Atomo[5];
        String[] atos = datos.split(" ");
        back = new Rectangle(30,30,90);
        back.changeColor("black");
        for(int i = 0; i < 4; i++){
            atomos[i] =  new Atomo(atos[i],position[(i+1)%4],position[(i)%4],30);
        }
        posicion = 0;
    }
    
    /**
     * Hace Visible las moleculas
     */
    public void makeVisible(){
        if(!isVisible){
            back.makeVisible();
            for(int i = 0; i < 4; i++){
                atomos[i].makeVisible();
            }
            isVisible = true;
        }
    }
    
    /**
     * Hace invisible las moleculas
     */
    public void makeInvisible(){
        if(isVisible){
            back.makeInvisible();
            for(int i = 0; i < 4; i++){
                atomos[i].makeInvisible();
            }
            isVisible=false;
        }
    }
    
    /**
     * Retorna el tipo de molecula
     */
    public String getType(){
        return "Molecule";
    }
    
    /**
     * Mueve la molecula hacia abajo
     */
    public void moveDown(){
         int cambio = 0;
        if(isVisible){
            makeInvisible();
            cambio++;
        }
        back.moveVertical(90);
        for(int i = 0; i < 4; i++){
            atomos[i].moveVertical(90);
        }
         if(cambio==1)makeVisible();
    }
    
    /**
     * Mover la molecula hacia la derecha
     */
    public void moveRight(){
         int cambio = 0;
        if(isVisible){
            makeInvisible();
            cambio++;
        }
        back.moveHorizontal(90);
        for(int i = 0; i < 4; i++){
            atomos[i].moveHorizontal(90);
        }
         if(cambio==1)makeVisible();
    }
    
    /**
     * Se refleja respecto al eje y 
     */
    public void reflect(){
       // Modificar la posicion invirtiendo la derecha por la izquierda
       atomos[(posicion+1+reflejo[posicion])%4].moveHorizontal(-60); 
       atomos[(posicion+3+reflejo[posicion])%4].moveHorizontal(60);
       // Asignacion de las referencias de los cuadrados
       tempr = atomos[(posicion+1)%4];
       atomos[(posicion+1)%4] = atomos[(posicion+3)%4];
       atomos[(posicion+3)%4] = tempr;
    }
    
    /**
     * Se rota en el sentido de las manecillas del reloj
     */
    public void rotate(){
         int cambio = 0;
        if(isVisible){
            makeInvisible();
            cambio++;
        }
       
        for(int i = 0; i < 4; i++){
            atomos[i].moveHorizontal(rota[(posicion+i+1)%4]);
            atomos[i].moveVertical(rota[(posicion+i)%4]);
        }
        posicion= (posicion+1)%4;
         if(cambio==1)makeVisible();
    }
    
    /**
     * Retorna lista de los atomos
     */
    private Atomo[] getAtomos(){
        return atomos;
    }
    
    /**
     * Retorna en que atomos son compatibles las dos moleculas
     */
    public ArrayList<Integer> esCompatible(Molecule m){
        Atomo[] tmp = m.getAtomos();
        ArrayList<Integer> posiciones = new ArrayList<Integer>();
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                if(atomos[i].compatible(tmp[j])){
                    posiciones.add(i);
                    posiciones.add(j);
                }
            }
        }
        return posiciones;
    }
    /**
     * Cambia el fonde de la molecula
     */
    public void enUso(){
        makeInvisible();
        back.changeColor("cyan");
        makeVisible();
    }
}