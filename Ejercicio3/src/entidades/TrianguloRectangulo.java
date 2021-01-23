package entidades;

public class TrianguloRectangulo extends Figura{
    
    //ATRIBUTOS
    
    private float base;
    private float altura;
    
    
    //CONSTRUCTORES
    
    public TrianguloRectangulo(){
        super();
        base = 0.0f;
        altura = 0.0f;
    }

    public TrianguloRectangulo(float base, float altura, String color,
                      String nombreDeLaForma, Punto punto) {
        super(color, nombreDeLaForma, punto);
        this.base = base;
        this.altura = altura;
    }
    
    public TrianguloRectangulo(float base, float altura, String color,
                      String nombreDeLaForma, int x, int y) {
        super(color, nombreDeLaForma, x, y);
        this.base = base;
        this.altura = altura;
    }

      
    //GETTERS Y SETTERS
    
    public float getBase() {
        return base;
    }

    public void setBase(float base) {
        this.base = base;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }
    
    
    //SOBREESCRITURA DE MÉTODO DE IMPRESIÓN
      
    @Override
    public String toString() {
        return super.toString() + "\nTipo: Triángulo Rectángulo"+
        "\nBase: " + getBase() + "\nAltura: " + getAltura() +
        "\nÁrea: "+ getArea() + "\nPerímetro: "+ getPerimetro();
    }
 
    
    //REDEFINICIÓN DE MÉTODOS ABSTRACTOS
    
    @Override
    public float getArea() {
        return (getBase()*getAltura())/2;
    }
    
    @Override
    public float getPerimetro() {
        float c = (float) Math.sqrt((Math.pow(base,2)+Math.pow(altura,2)));
        return base+altura+c;
    }
}
