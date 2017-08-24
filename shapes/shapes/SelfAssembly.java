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
        lista = new ArrayList();
    }
    public void addmolecule(String cadena){
        lista.add(new Molecule(cadena));
    }
}