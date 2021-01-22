package entidades;
import javax.swing.JOptionPane;


public abstract class Figura implements Comparable<Figura> {
    
    //ATRIBUTOS
    
    private String color;
    private Punto centro;
    private String nombreDeLaForma;

    
    //CONSTRUCTORES
    
    public Figura() {
        color = "NA";
        nombreDeLaForma = "NA";
        centro = new Punto();
    }
    
     public Figura(String color, String nombreDeLaForma) {
        this.color=color;
        this.nombreDeLaForma=nombreDeLaForma;
        centro = new Punto();
    }
     public Figura(String color, String nombreDeLaForma, Punto centro) {
        this.color = color;
        this.nombreDeLaForma = nombreDeLaForma;
        this.centro = centro;
    }
     
      public Figura(String color, String nombreDeLaForma, int x, int y) {
        this.color = color;
        this.nombreDeLaForma = nombreDeLaForma;
        centro = new Punto(x,y);
    }
    
    
    //GETTERS Y SETTERS

    public Punto getCentro() {
        return centro;
    }

    public void setCentro(Punto centro) {
        this.centro = centro;
    }
  

    public String getColor() {
        return color;
    }
    
    public void setCentro(int x, int y) {
        //centro = new Punto(X, Y);
        centro.setX(x);
        centro.setY(y);
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getNombreDeLaForma() {
        return nombreDeLaForma;
    }

    public void setNombreDeLaForma(String nombreDeLaForma) {
        this.nombreDeLaForma = nombreDeLaForma;
    }
    
    public String cambiarColor() {
        color = (JOptionPane.showInputDialog(null,"Nuevo color de la figura: ",
                "Modificación de color de la figura",3));
        setColor(color);
        JOptionPane.showMessageDialog(null, "El color de " +
        getNombreDeLaForma() + " ha sido cambiado a " + color, "Éxito",1);
        return getColor();
    }
    
    public void moverFigura() {
        centro.setX(Integer.parseInt(JOptionPane.showInputDialog(null,
              "Nueva coordenada en x: ","Cambio de centro de la figura",3)));
        centro.setY(Integer.parseInt(JOptionPane.showInputDialog(null,
              "Nueva coordenada en y: ","Cambio de centro de la figura",3)));
        JOptionPane.showMessageDialog(null,"La figura fue trasladada " + 
        "con éxito.", "Éxito", 1);
    }
    
    
    //SOBREESCRITURA DE MÉTODO DE IMPRESIÓN
    
    @Override
    public String toString() {
        return "Nombre: " + getNombreDeLaForma() + "\nColor: " +  getColor()
                + getCentro().toString();
    }
    
    
    //MÉTODOS ABSTRACTOS
    
    public abstract float getArea();
    public abstract float getPerimetro();
    
    
    @Override
    public int compareTo(Figura otraFig) {
        if(this.getArea() > otraFig.getArea())
            return 1;
        else if (this.getArea() == otraFig.getArea())
            return 0 ;
        return -1 ;
    }
    
}
