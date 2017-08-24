import java.util.*;

/**
 * Write a description of class SelfAssembly here.
 * 
 * @author Nicolas Cardenas y Paola Cuellar
 * @version 1.0  (24 August 2017)
 */
public class SelfAssembly{
    private ArrayList<Molecule> lista;
    private int contadorX,contadorY;
    private boolean isVisible;
    /**
     * Constructor for objects of class SelfAssembly
     */
    public SelfAssembly(){
        lista = new ArrayList<Molecule>();
        contadorX = contadorY = 0;
        isVisible = false;
    }
    
    /**
     *Agrega a una lista las moleculas creadas y las posiciona 
     */
    public void addmolecule(String cadena){
        lista.add(new Molecule(cadena));
        for(int i = 0; i < contadorX; i++) lista.get(lista.size()-1).moveRight();
        for(int i = 0; i < contadorY; i++) lista.get(lista.size()-1).moveDown(); 
        if((contadorX+1)%4==0){
            contadorX=0;contadorY++;
        }else{
            contadorX++;
        }
        if (isVisible){
            lista.get(lista.size()-1).makeVisible();
        }
    }
    
    /**
     *
     */
    public void valid(){
        
    }
    
    /**
     *Hacer visible toda la molecula creada
     */
    public void makeVisible(){
        if(!isVisible){
            for(int i = 0; i < lista.size(); i++){
                lista.get(i).makeVisible();
            }
            isVisible = true;
        }
    }
    
    /**
     *Hacer invisible toda la molecula creada
     */
    public void makeInvisible(){
        if(isVisible){
            for(int i = 0; i < lista.size(); i++){
                lista.get(i).makeInvisible();
            }
            isVisible = false;
        }
    }
}