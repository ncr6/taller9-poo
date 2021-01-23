package presentacion;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import entidades.*;


public class Main {
    
    public static int menuPrincipal(){
        int opcion;
        String mensaje="""
                        Escriba el número de la opción elegida:
                           1. Registrar una figura.
                           2. Ver opciones de una figura.
                           3. Listar figuras registradas.
                           4. Salir.
                       """;
        
        opcion = Integer.parseInt(JOptionPane.showInputDialog(null, mensaje,
                 "Menú principal", 3));
        return opcion;
  
    }
    
    
    public static int menuFigura(int pos){
        int opcion;
        String mensaje="[Opciones de la figura " + pos + "]\n" +
                       """
                        Escriba el número de la opción elegida:
                           1. Mostrar datos.
                           2. Cambiar de color. 
                           3. Cambiar coordenadas.
                           4. Escalar tamaño.
                           5. Regresar al menú principal.
                       """;
        
        opcion = Integer.parseInt(JOptionPane.showInputDialog(null, mensaje,
                "Menú de opciones de la figura " + pos, 3));
        return opcion;
  
    }
    
    
    public static Rectangulo ingresoDeDatos(int pos){
        float ladoMayor, ladoMenor;
        String nombre, color;
        Punto centro = new Punto();
        
        JOptionPane.showMessageDialog(null,"Se creará un nuevo rectángulo\n" +
        "en la posición "+ pos,"Nuevo rectángulo",1);
        centro.setX(Integer.parseInt(JOptionPane.showInputDialog(null,
        "Ingrese la coordenada X\ndel rectángulo: ","Coordenada X",3)));
        centro.setY(Integer.parseInt(JOptionPane.showInputDialog(null,
        "Ingrese la coordenada Y\ndel rectángulo: ","Coordenada Y",3)));
        
        nombre = JOptionPane.showInputDialog(null,"Nombre de la figura: ",
                "Creación de un rectángulo",3);
        color = JOptionPane.showInputDialog(null,"Color de la figura: ",
                "Creación de un rectángulo",3);
        
        ladoMenor = Float.parseFloat(JOptionPane.showInputDialog(null,
                    "Ancho del rectangulo : ","Registro de datos",3));
        ladoMayor = Float.parseFloat(JOptionPane.showInputDialog(null,
                    "Largo del rectangulo : ","Registro de datos",3));
        

        Rectangulo r = new Rectangulo(ladoMayor,ladoMenor,color,nombre,centro);
        return r;
    }
    
    
    public static void salidaDeDatos(Rectangulo r1, int pos){
        JOptionPane.showMessageDialog(null, r1.toString() ,"Información de la "
        + "figura " + pos, 1);
        
    }
     
    
    public static void cambioEscala(Rectangulo r1){
         String mensaje = "Área y perímetro a escala\n";
         float escala;
         escala= Float.parseFloat(JOptionPane.showInputDialog(null,
                 "Razón de escalado: ","Registro de datos",3));
         mensaje = "Area Inicial : " + r1.getArea() 
                 + "\nPerimetro Inicial : " + r1.getPerimetro();
         r1.escalar(escala);
         mensaje += "\n\nArea Escalada: "+ r1.getArea() +
                 "\nPerimetro Escalado: " + r1.getPerimetro();
         JOptionPane.showMessageDialog(null,  mensaje,"Registro de datos",3);
         JOptionPane.showMessageDialog(null,
                     "La figura ha sido escalada con éxito","Exito",1);
    }
    
     
    public static void mostrarDatosGeneral(Rectangulo r1){
          JOptionPane.showMessageDialog(null, r1.toString(),
          "Datos de rectangulo", 1);
    }
    
     
    public static Rectangulo opcionesFigura(Rectangulo rect, int pos){
        int opcion;
        do{ 
            opcion = menuFigura(pos);
            switch(opcion){
                case 1:
                    salidaDeDatos(rect, pos); break;
                case 2:
                    rect.cambiarColor(); break;
                case 3:
                    rect.moverFigura(); break;
                case 4:
                    cambioEscala(rect); break;
                case 5:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "La opción ingresada" +
                    " no es válida.\nInténtelo nuevamente.", "Opción inválida",
                    2);
            }
                        
        } while (opcion != 5);
        return rect;
    }
    
    
   
    public static void main(String[] args) {
        int opcion, pos; 

        //Creación de ArrayList que almacena todo
        ArrayList<Rectangulo> arreglo = new ArrayList<>();

        do{ 
            opcion = menuPrincipal();
            switch(opcion){
                
                case 1 -> {
                    arreglo.add(ingresoDeDatos(arreglo.size()));               
                    break;
                }
                
                case 2 -> {
                    int tam = arreglo.size();
                    pos = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Ingrese el número de posición del rectángulo\n" +
                    "al que desee acceder", "Selección de rectángulo", 3));
                    if (pos < tam && pos >= 0){
                        arreglo.set(pos, opcionesFigura(arreglo.get(pos), pos));
                    } else {
                        String mensaje = "La posición ingresada (" + pos +
                        ") no contiene ningún rectángulo.\n"
                        + "Se han registrado "+tam+" rectángulos.\n";
                        if (tam > 0){
                            mensaje += "Pruebe ingresando posiciones entre 0"
                            + " y " + (tam-1);
                        }
                        JOptionPane.showMessageDialog(null,mensaje,"Posición"
                        + " inválida", 2);
                    }
                }
                
                case 3 -> {
                    String mensaje = "Las figuras registradas son:\n";
                    
                    int cont = 0;
                    //Contador que envia hasta 3 figuras por JOptionPane
                    
                    if (arreglo.size() > 0){
                        for (int i=0; i<arreglo.size(); i++){
                            if (cont<3){
                                mensaje += "\n\nFigura que ocupa la posición "
                                        + i;
                                mensaje += "\n" + arreglo.get(i).toString();
                                cont++;
                            } else {
                                JOptionPane.showMessageDialog(null, mensaje,
                                "Listado de figuras registradas",1);
                                mensaje = "\n";
                                mensaje += "\nFigura que ocupa la posición "+i;
                                mensaje += arreglo.get(i).toString();
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
                
                case 4 -> {
                    JOptionPane.showMessageDialog(null,"Gracias por usar este"
                    + " programa.", "Hasta luego", 1);
                }
                
                default -> {
                    JOptionPane.showMessageDialog(null, "La opción ingresada" +
                    " no es válida.\nInténtelo nuevamente.", "Opción inválida",
                    2);
                }
            }
        } while (opcion != 4);
        
    }
}
