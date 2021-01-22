package presentacion2;
import entidades.*;
import javax.swing.JOptionPane;

public interface IngresoDatos {
    
    public static String crearNombre(String figura){
        return JOptionPane.showInputDialog(null,"Nombre del: " + figura,
                "Creación de un " + figura, 3);
    }
    
    public static String crearColor(String figura){
        return JOptionPane.showInputDialog(null,"Color del: " + figura,
                "Creación de un " + figura, 3);
    }
    
    public static Punto ingresarCentro(String figura){
        Punto centro = new Punto();
        centro.setX(Integer.parseInt(JOptionPane.showInputDialog(null,
        "Ingrese la coordenada X\ndel centro del " +figura+": ",
        "Coordenada X",3)));
        centro.setY(Integer.parseInt(JOptionPane.showInputDialog(null,
        "Ingrese la coordenada Y\ndel centro del " +figura+": ",
        "Coordenada Y",3)));
        return centro;
    }
    
    public static Rectangulo ingresarRectangulo(int pos){
        Punto centro = ingresarCentro("Rectángulo");
        String nombre = crearNombre("Rectángulo");
        String color = crearColor("Rectángulo");
        float ladoMenor = Float.parseFloat(JOptionPane.showInputDialog(null,
                          "Ancho del rectangulo: ","Registro de datos",3));
        float ladoMayor = Float.parseFloat(JOptionPane.showInputDialog(null,
                          "Largo del rectangulo: ","Registro de datos",3));
        
        Rectangulo r = new Rectangulo(ladoMayor,ladoMenor,color,nombre,centro);
        return r;
    }
    
    public static Cuadrado ingresarCuadrado(int pos){
        Punto centro = ingresarCentro("Cuadrado");
        String nombre = crearNombre("Cuadrado");
        String color = crearColor("Cuadrado");
        float lado = Float.parseFloat(JOptionPane.showInputDialog(null,
                     "Tamaño del lado del cuadrado: ","Registro de datos",3));
        
        Cuadrado c = new Cuadrado(lado, color, nombre, centro);
        return c;
    }

    public static Elipse ingresarElipse(int pos){
        Punto centro = ingresarCentro("Elipse");
        String nombre = crearNombre("Elipse");
        String color = crearColor("Elipse");
        float radioMenor = Float.parseFloat(JOptionPane.showInputDialog(null,
                          "Radio Menor del elipse: ","Registro de datos",3));
        float radioMayor = Float.parseFloat(JOptionPane.showInputDialog(null,
                          "Radio Mayor del elipse: ","Registro de datos",3));
        
        Elipse e = new Elipse(radioMayor, radioMenor, color, nombre,
                           centro);
        return e;
    }

    public static Circulo ingresarCirculo(int pos){
        Punto centro = ingresarCentro("Circulo");
        String nombre = crearNombre("Circulo");
        String color = crearColor("Circulo");
        float radio = Float.parseFloat(JOptionPane.showInputDialog(null,
                     "Tamaño del radio del circulo: ","Registro de datos",3));
        
        Circulo cr = new Circulo(radio, color, nombre, centro);
        return cr;
    } 
    
}
