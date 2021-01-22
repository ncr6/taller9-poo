package presentacion2;
import entidades.*;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;
import static presentacion2.IngresoDatos.*;
import java.util.Comparator;

public class Main {
    
    public static int menuPrincipal(){
        int opcion;
        String mensaje="""
                        Escriba el número de la opción elegida:
                           1. Registrar una figura.
                           2. Asignar un color a todas las figuras.
                           3. Asignar un color a todo un tipo de figuras.
                           4. Mover todas las figuras a una posición.
                           5. Mover todas las figuras de un tipo.
                           6. Listar todas las figuras registradas.
                           7. Obtener la figura con el área más grande.
                           8. Salir.
                       """;
        
        opcion = Integer.parseInt(JOptionPane.showInputDialog(null, mensaje,
                 "Menú principal", 3));
        return opcion;
  
    }    
    
    public static int menuSeleccionFigura(){
        int opcion;
        String mensaje=
                       """
                        Escriba el número de la figura elegida:
                           1. Rectángulo.
                           2. Cuadrado. 
                           3. Elipse.
                           4. Círculo.
                           5. Regresar al menú principal.
                       """;
        
        do{
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, mensaje,
                "Menú de selección de figura ", 3));
            if (opcion < 1 && opcion > 5){
                JOptionPane.showMessageDialog(null, "La opción ingresada" +
                    " no es válida.\nInténtelo nuevamente.", "Opción inválida",
                    2);
            }
        } while (opcion < 1 && opcion > 5);
        
        return opcion;
  
    }    
    
    
    public static Rectangulo ingresoDeDatos(int pos, String figura){
        float ladoMayor, ladoMenor;
        String nombre, color;
        Punto centro = new Punto();
        
        JOptionPane.showMessageDialog(null,"Se creará un nuevo "+figura+ "\n" +
        "en la posición "+ pos,"Nuevo "+figura,1);
        centro.setX(Integer.parseInt(JOptionPane.showInputDialog(null,
        "Ingrese la coordenada X\ndel "+figura,"Coordenada X",3)));
        centro.setY(Integer.parseInt(JOptionPane.showInputDialog(null,
        "Ingrese la coordenada Y\ndel "+figura,"Coordenada Y",3)));
        
        nombre = JOptionPane.showInputDialog(null,"Nombre de la figura: ",
                "Creación de una figura",3);
        color = JOptionPane.showInputDialog(null,"Color de la figura: ",
                "Creación de una figura",3);
        
        ladoMenor = Float.parseFloat(JOptionPane.showInputDialog(null,
                    "Ancho del rectangulo : ","Registro de datos",3));
        ladoMayor = Float.parseFloat(JOptionPane.showInputDialog(null,
                    "Largo del rectangulo : ","Registro de datos",3));
        

        Rectangulo r = new Rectangulo(ladoMayor,ladoMenor,color,nombre,centro);
        return r;
    }
    
    
    public static void main(String[] args) {
        int opcion;
        ArrayList<Figura> arr = new ArrayList<>();
        
        do{
            opcion = menuPrincipal();
            switch (opcion){
                case 1 -> {
                    int fig = menuSeleccionFigura();
                    switch (fig){
                        case 1: arr.add(ingresarRectangulo(arr.size())); break;
                        case 2: arr.add(ingresarCuadrado(arr.size())); break;
                        case 3: arr.add(ingresarElipse(arr.size())); break;
                        case 4: arr.add(ingresarCirculo(arr.size())); break;
                        case 5: break;
                    }     
                }
                case 2 -> {
                    String nuevoColor = JOptionPane.showInputDialog(null,
                    "Ingrese el color que desee asignar a todas las figuras",
                    "Cambio de color global", 3);
                    for (int i=0; i<arr.size(); i++){
                        Figura f = arr.get(i); f.setColor(nuevoColor);
                        arr.set(i, f);
                    }
                    JOptionPane.showMessageDialog(null,"Se cambió el color de"
                    + "todas las figuras con éxito", "Éxito", 1); break;
                }
                case 3 -> {
                    int clase = menuSeleccionFigura();
                    String nuevoColor = JOptionPane.showInputDialog(null,
                    "Ingrese el color que desee asignar a todas las figuras" +
                    " de este tipo", "Cambio de color de tipo de figuras", 3);
                    switch (clase){
                        case 1 -> {
                            for (int i=0 ; i < arr.size(); i++){
                                if (arr.get(i) instanceof Rectangulo){
                                    Figura f = arr.get(i); f.setColor(nuevoColor);
                                    arr.set(i, f);
                                    JOptionPane.showMessageDialog(null,"Se cambió el color de"
                                    + " todos los rectángulos con éxito", "Éxito", 1); break;
                                }
                            }
                        }
                        case 2 -> {
                            for (int i=0 ; i < arr.size(); i++){
                                if (arr.get(i) instanceof Cuadrado){
                                    Figura f = arr.get(i); f.setColor(nuevoColor);
                                    arr.set(i, f);
                                    JOptionPane.showMessageDialog(null,"Se cambió el color de"
                                    + " todos los cuadrados con éxito", "Éxito", 1); break;                                    
                               }
                            }
                        }
                        case 3 -> {
                            for (int i=0 ; i < arr.size(); i++){
                                if (arr.get(i) instanceof Elipse){
                                    Figura f = arr.get(i); f.setColor(nuevoColor);
                                    arr.set(i, f);
                                    JOptionPane.showMessageDialog(null,"Se cambió el color de"
                                    + " todos los elipses con éxito", "Éxito", 1); break;                                         
                               }
                            }
                       }
                        case 4 -> {
                            for (int i=0 ; i < arr.size(); i++){
                                if (arr.get(i) instanceof Circulo){
                                    Figura f = arr.get(i); f.setColor(nuevoColor);
                                    arr.set(i, f);
                                    JOptionPane.showMessageDialog(null,"Se cambió el color de"
                                    + " todos los círculos con éxito", "Éxito", 1); break;                                         
                               }
                            }
                       }
                    }                    
                    break;
                }
                case 4 -> {}
                case 5 -> {}              
                case 6 -> {
                    String mensaje = "Las figuras registradas son:\n";
                    
                    int cont = 0;
                    //Contador que envia hasta 3 figuras por JOptionPane
                    
                    if (arr.size() > 0){
                        for (int i=0; i<arr.size(); i++){
                            if (cont<3){
                                mensaje += "\n\nFigura que ocupa la posición "
                                        + i;
                                mensaje += "\n" + arr.get(i).toString();
                                cont++;
                            } else {
                                JOptionPane.showMessageDialog(null, mensaje,
                                "Listado de figuras registradas",1);
                                mensaje = "\n";
                                mensaje += "\nFigura que ocupa la posición "+i;
                                mensaje += arr.get(i).toString();
                                cont = 1;
                            }
                        }
                        if (cont <= 4){
                            JOptionPane.showMessageDialog(null, mensaje,
                            "Listado de figuras registradas",1);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "No se han "
                        + "registrado figuras hasta el momento.",
                        "Registro vacío", 2);
                    }
                    break;
                }
                case 7 -> {
                    if (arr.size()>0){
                        Figura[] figuras = new Figura[arr.size()];
                        
                        Arrays.sort(figuras);
                        JOptionPane.showMessageDialog(null, "Figura con la"
                        + " mayor área.\n" + figuras[arr.size()-1],
                        "Información de la figura más grande", 1);
                    } else {
                        JOptionPane.showMessageDialog(null, "No se han "
                        + "registrado figuras hasta el momento.",
                        "Registro vacío", 2);                        
                    } break;
                }
                case 8 -> {
                    JOptionPane.showMessageDialog(null,"Gracias por usar este"
                    + " programa.", "Hasta luego", 1); break;
                }
            }
        } while (opcion != 8);
        
    }
}