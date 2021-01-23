package entidades;

public class Linea {
    
    private Punto inicio;
    private Punto fin;
    private double longitud;
    
    
    public Linea(){
        inicio = new Punto();
        fin = new Punto();
        longitud = 0;
    }
    
    public Linea(Punto inicio, Punto fin){
        this.inicio = inicio;
        this.fin = fin;
        longitud = 0;
    }
    
    public Linea(int x1, int y1, int x2, int y2){
        inicio = new Punto(x1, y1);
        fin = new Punto(x2, y2);
        ajustarLongitud();
    }
    

    public Punto getInicio() {
        return inicio;
    }

    public void setInicio(Punto inicio) {
        this.inicio = inicio;
        ajustarLongitud();
    }
    
    public void setInicio(int x, int y){
        inicio.setX(x); inicio.setY(y);
        ajustarLongitud();
        
    }

    public Punto getFin() {
        return fin;
    }

    public void setFin(Punto fin) {
        this.fin = fin;
        ajustarLongitud();
    }
    
    public void setFin(int x, int y){
        fin.setX(x); fin.setY(y);
        ajustarLongitud();
    }
    
    public double getLongitud(){
        return longitud;
    }
    
    private void ajustarLongitud(){
        double a = Math.pow((fin.getX()-inicio.getX()),2);
        double b = Math.pow((fin.getY()-inicio.getY()),2);
        longitud = Math.sqrt(a+b);
    }
    
    @Override
    public String toString(){
        return "Tipo: Línea" + "\nCoordenadas de inicio: (" + inicio.getX() +
        ";" + inicio.getY() + ")" + "\nCoordenadas de fin: (" + fin.getX() +
        ";" + fin.getY() + ")" + "\nLongitud: " + getLongitud();
    }
    
}
