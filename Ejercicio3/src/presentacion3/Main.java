package presentacion3;
import entidades.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import javax.swing.JOptionPane;
import static presentacion3.IngresoDatos.*;

public class Main {
    
    public static int menuPrincipal(){
        int opcion;
        String mensaje="""
                        Escriba el número de la opción elegida:
                           1. Registrar una figura.
                           2. Asignar un color a todas las figuras.
                           3. Asignar un color a todo un tipo de figuras.
                           4. Mover todas las figuras a una posición.
                           5. Listar todas las figuras registradas.
                           6. Obtener la figura con el área más grande.
                           7. Salir.
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
                           5. Triángulo.
                           6. Triángulo Rectángulo.
                           7. Polígono.
                           8. Regresar al menú principal.
                       """;
        
        do{
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, mensaje,
                "Menú de selección de figura ", 3));
            if (opcion < 1 && opcion > 9){
                JOptionPane.showMessageDialog(null, "La opción ingresada" +
                    " no es válida.\nInténtelo nuevamente.", "Opción inválida",
                    2);
            }
        } while (opcion < 1 && opcion > 9);
        
        return opcion;
  
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
                        case 5: arr.add(ingresarTriangulo(arr.size())); break;
                        case 6: arr.add(ingresarTRectangulo(arr.size())); break;
                        case 7: arr.add(ingresarPoligono(arr.size())); break;
                        case 8: break;
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
                    + " todas las figuras con éxito", "Éxito", 1); break;
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
                                }
                            }
                            JOptionPane.showMessageDialog(null,"Se cambió el color de"
                            + " todos los rectángulos con éxito", "Éxito", 1); break;
                        }
                        case 2 -> {
                            for (int i=0 ; i < arr.size(); i++){
                                if (arr.get(i) instanceof Cuadrado){
                                    Figura f = arr.get(i); f.setColor(nuevoColor);
                                    arr.set(i, f);                                
                               }
                            }
                            JOptionPane.showMessageDialog(null,"Se cambió el color de"
                            + " todos los cuadrados con éxito", "Éxito", 1); break;   
                        }
                        case 3 -> {
                            for (int i=0 ; i < arr.size(); i++){
                                if (arr.get(i) instanceof Elipse){
                                    Figura f = arr.get(i); f.setColor(nuevoColor);
                                    arr.set(i, f);
                                       
                               }
                            }
                            JOptionPane.showMessageDialog(null,"Se cambió el color de"
                            + " todos los elipses con éxito", "Éxito", 1); break;                              
                        }
                        case 4 -> {
                            for (int i=0 ; i < arr.size(); i++){
                                if (arr.get(i) instanceof Circulo){
                                    Figura f = arr.get(i); f.setColor(nuevoColor);
                                    arr.set(i, f);                                     
                               }
                            }
                            JOptionPane.showMessageDialog(null,"Se cambió el color de"
                            + " todos los círculos con éxito", "Éxito", 1); break;   
                        }
                        case 5 -> {
                            for (int i=0 ; i < arr.size(); i++){
                                if (arr.get(i) instanceof Triangulo){
                                    Figura f = arr.get(i); f.setColor(nuevoColor);
                                    arr.set(i, f);                                     
                               }
                            }
                            JOptionPane.showMessageDialog(null,"Se cambió el color de"
                            + " todos los triángulos con éxito", "Éxito", 1); break;   
                        }
                        case 6 -> {
                            for (int i=0 ; i < arr.size(); i++){
                                if (arr.get(i) instanceof TrianguloRectangulo){
                                    Figura f = arr.get(i); f.setColor(nuevoColor);
                                    arr.set(i, f);                                     
                               }
                            }
                            JOptionPane.showMessageDialog(null,"Se cambió el color de"
                            + " todos los triángulos rectángulos con éxito", "Éxito", 1); break;   
                        }
                        case 7 -> {
                            for (int i=0 ; i < arr.size(); i++){
                                if (arr.get(i) instanceof Poligono){
                                    Figura f = arr.get(i); f.setColor(nuevoColor);
                                    arr.set(i, f);                                     
                               }
                            }
                            JOptionPane.showMessageDialog(null,"Se cambió el color de"
                            + " todos los poligonos con éxito", "Éxito", 1); break;   
                        }
                    }                    
                    break;
                }
                
                
                case 4 -> {
                    int posmv = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Ingrese la cantidad de posiciones\nque desea desplazar en"
                    +" todos los elementos:","Desplazamiento de objetos", 3));
                    Collections.rotate(arr,posmv);
                }
                
                
                case 5 -> {
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
                
                
                case 6 -> {
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
                
                
                case 7 -> {
                    JOptionPane.showMessageDialog(null,"Gracias por usar este"
                    + " programa.", "Hasta luego", 1); break;
                }
            }
        } while (opcion != 7);
        
    }
}