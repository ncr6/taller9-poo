package entidades;


public class Circulo extends Elipse {
    public Circulo(){
        super();
    }
    
    public Circulo(float radio, String color, String nombreDeLaForma,
           Punto centro){
        super(radio, radio, color, nombreDeLaForma, centro);
    }
    
    public Circulo(float radio, String color, String nombreDeLaForma,
           int x, int y){
        super(radio, radio, color, nombreDeLaForma, x, y);
    }    

}