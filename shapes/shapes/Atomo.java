
/**
 * Write a description of class Atomo here.
 * 
 * @author  Paola Cuellar y Nicolás Cárdenas
 * @version 1.0  (24 August 2017)
 */
public class Atomo
{
    // instance variables - replace the example below with your own
    private Rectangle x;
    private Circle y;
    private String ato;
    private boolean isVisible;

    /**
     * Constructor for objects of class Atomo
     */
    public Atomo(String cadena)
    {
        ato=cadena;
        char s = cadena.charAt(0);
        char l = cadena.charAt(1);
        x = new Rectangle(30,30,30);
        y = new Circle(35,35,20);
        x.changeColor(asignColorR(s));
        y.changeColor(asignColorC(l));        
    }
    
    /**
     *Construye el atomo indicando la posicion y el tamaño
     */
    public Atomo(String cadena, int xPosition, int yPosition, int size)
    {
        ato=cadena;
        char s = cadena.charAt(0);
        char l = cadena.charAt(1);
        x = new Rectangle(xPosition,yPosition,size);
        y = new Circle(xPosition+5,yPosition+5,size-10);
        x.changeColor(asignColorR(s));
        y.changeColor(asignColorC(l));  
    }
    
    /**
     *Asigna el color de las letras
     */
    public String asignColorR(char s){
        String color;
        if (s == 'A'){
            color = "yellow";
        }else if(s == 'B'){
            color = "blue";
        }else if(s == 'C'){
            color = "magenta";
        }else if(s == 'D'){
            color = "green";
        }else if (s == '0'){
            color = "red";
        }else{
            color = "black";
        }
        return color;
    }
    
    /**
     *Asigna el color de los signos
     */
    public String asignColorC(char s){
        String color;
         if (s == '+'){
            color = "white";
        }else if(s == '-'){
            color = "black";
        }else{
            color = "red";
        }
        return color;
    }
    

    /**
     * Move the rectangle horizontally.
     * @param distance the desired distance in pixels
     */
    public void moveHorizontal(int distance){
        int cambio = 0;
        if(isVisible){
            makeInvisible();
            cambio++;
        }
        x.moveHorizontal(distance);
        y.moveHorizontal(distance);
        if(cambio==1)makeVisible();
    }

    /**
     * Move the rectangle vertically.
     * @param distance the desired distance in pixels
     */
    public void moveVertical(int distance){
        int cambio = 0;
        if(isVisible){
            makeInvisible();
            cambio++;
        }
        x.moveVertical(distance);
        y.moveVertical(distance);
        if(cambio==1)makeVisible();
    }

    /**
     *Hace visible los atomos 
     */
    public void makeVisible()
    {  
        if(!isVisible){
            x.makeVisible();
            y.makeVisible();
            isVisible=true;
        }
    }
    
    /**
     *Hace invisible los atomos
     */
    public void makeInvisible()
    {  
        if(isVisible){
            x.makeInvisible();
            y.makeInvisible();
            isVisible=false;
        }
    }
    
    /**
     *Retorna la caracteristica (color) del signo
     */
    private String getSign(){
        return asignColorC(ato.charAt(1));
    }
    
    /**
     *Retorna la caracteristica (color) de la letra
     */
    private String getLetter(){
        return asignColorR(ato.charAt(0));
    }
    
    /**
     *Definir si 2 moleculas son compatibles
     */
    public boolean compatible(Atomo otro){
        return getLetter().equals(otro.getLetter()) && !getSign().equals("red") && !getSign().equals(otro.getSign()); 
    }
}
