import java.util.*;

/**
 * Write a description of class SelfAssembly here.
 * 
 * @author Nicolas Cardenas y Paola Cuellar
 * @version 1.0  24/08/2017
 */
public class SelfAssembly{
    private ArrayList<Molecule> lista;

    /**
     * Constructor for objects of class SelfAssembly
     */
    public SelfAssembly(){
        lista = new ArrayList<Molecule>();
    }
    public void addmolecule(String cadena){
        lista.add(new Molecule(cadena));
    }
    public void valid(){
        
    }
    public void onhold(){
        for (int i = 0; i < lista.size();i++){
            for (int j = 0; i >= j; j++){
                lista.get(i).moveDown();
            }
            lista.get(i).makeVisible();
        }
    }
}