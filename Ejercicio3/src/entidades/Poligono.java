package entidades;

public class Poligono extends Figura{
    
    //ATRIBUTOS
    
    private int lados;
    private float mlado;
    private float apotema;
    
    
    //CONSTRUCTORES
    
    public Poligono(){
        super();
        lados = 0;
        apotema = 0.0f;
        mlado = 0.0f;
    }

    public Poligono(int lados, float mlado, float apotema, String color,
                      String nombreDeLaForma, Punto punto) {
        super(color, nombreDeLaForma, punto);
        this.lados = lados;
        this.apotema = apotema;
        this.mlado = mlado;
    }
    
    public Poligono(int lados, float mlado, float apotema, String color,
                      String nombreDeLaForma, int x, int y) {
        super(color, nombreDeLaForma, x, y);
        this.lados = lados;
        this.apotema = apotema;
    }

      
    //GETTERS Y SETTERS
    
    public int getLados() {
        return lados;
    }

    public void setLados(int lados) {
        this.lados = lados;
    }

    public float getApotema() {
        return apotema;
    }

    public void setApotema(float apotema) {
        this.apotema = apotema;
    }
    
    public float getMlado() {
        return mlado;
    }

    public void setMlado(float mlado) {
        this.mlado = mlado;
    }
    
    //SOBREESCRITURA DE MÉTODO DE IMPRESIÓN
      
    @Override
    public String toString() {
        return super.toString() + "\nTipo: Polígono"+
        "\nMedida de cada lado: " + getMlado() +
        "\nNúmero de lados: " + getLados() + "\nApotema: " + getApotema() +
        "\nÁrea: "+ getArea() + "\nPerímetro: "+ getPerimetro();
    }
 
    
    //REDEFINICIÓN DE MÉTODOS ABSTRACTOS
    @Override
    public float getArea() {
        return (getPerimetro()*getApotema())/2;
    }
    
    @Override
    public float getPerimetro() {
        return getMlado() * getLados();
    }
}
