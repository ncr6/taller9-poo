package entidades;


public class Cuadrado extends Rectangulo{
    public Cuadrado(){
        super();
    }
    
    public Cuadrado(float lado, String color, String nombreDeLaForma,
           Punto centro){
        super(lado, lado, color, nombreDeLaForma, centro);
    }
    
    public Cuadrado(float lado, String color, String nombreDeLaForma,
           int x, int y){
        super(lado, lado, color, nombreDeLaForma, x, y);
    }
    
}