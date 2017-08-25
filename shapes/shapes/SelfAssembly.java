import java.util.*;

/**
 * La clase SelfAssembly estructura un conjunto de Moleculas
 * 
 * @author Nicolas Cardenas y Paola Cuellar
 * @version 1.0  (24 August 2017)
 */
public class SelfAssembly{
    private ArrayList<Molecule> lista, tablero;
    private int contadorX,contadorY,contadorXT, contadorYT;
    private boolean isVisible;
    private ArrayList<Integer> comp;
    /**
     * Constructor del objeto de la clase SelfAssembly
     */
    public SelfAssembly(){
        lista = new ArrayList<Molecule>();
        tablero = new ArrayList<Molecule>();
        comp = new ArrayList<Integer>();
        contadorX = contadorY = contadorYT = 0;
        contadorXT = 4;
        isVisible = false;
    }
    
    /**
     *Agrega a una lista las moleculas creadas y las posiciona 
     */
    public void addmolecule(String cadena){
        lista.add(new Molecule(cadena));
        for (int i = 0; i < contadorX; i++){
            lista.get(lista.size()-1).moveRight();
        }
        for (int i = 0; i < contadorY; i++){
            lista.get(lista.size()-1).moveDown(); 
        }
        if((contadorX+1)%4 == 0){
            contadorX = 0;
            contadorY++;
        }else{
            contadorX++;
        }
        if (isVisible){
            lista.get(lista.size()-1).makeVisible();
        }
    }
    
    /**
     * Posiciona la molecula
     * @param Molecule mol
     */
    private void posicionamiento(Molecule mol, int num){
        tablero.add(num, mol);
        lista.remove(mol);
        for (int i = 0; i < 4; i++){
            tablero.get(tablero.size()-1).moveRight();
        }
        if (isVisible){
            tablero.get(tablero.size()-1).enUso();
            tablero.get(tablero.size()-1).makeVisible();
        }
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
    
    /**
     * Evalua que molecula es compatible con la estructura
     */
    public void value(){
        int i = 0;
        if (tablero.size() == 0){
            posicionamiento(lista.get(i), 0);
        }
        while (comp.isEmpty()){
            comp = lista.get(i).esCompatible(tablero.get(tablero.size()-1));
            i++;
        }
        for (int j = 0; j < comp.size(); j++){
            if (comp.get(j) != 0){
                if (comp.get(j) == 1 && comp.get(j+1) == 1){
                    lista.get(i-1).reflect();
                    posicionamiento(tablero.get(tablero.size()-1), tablero.size()-1);
                }else if (comp.get(j) == 1 && comp.get(j+1) == 3){
                    posicionamiento(tablero.get(tablero.size()-1), tablero.size()-1);
                }
            }
        }
    }
    
    /**
     * Evalua si la estructura ya esta cerrada
     */
    public void close(){
        
    }
}