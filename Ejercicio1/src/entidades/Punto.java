package entidades;


public class Punto {
    
    //ATRIBUTOS
    
    private int x;
    private int y;

    
    //CONSTRUCTORES
    
    public Punto() {
        x = 0;
        y = 0;
    }

    public Punto(int x, int y) {
        this.x = x;
        this.y = y;
    }

    
    //GETTERS Y SETTERS
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    

    //SOBREESCRITURA DE MÉTODO DE IMPRESIÓN
    
    @Override
    public String toString() {
        return "\nCoordenadas del centro: (" + getX() +";" + getY() + ")";
    } 


}
