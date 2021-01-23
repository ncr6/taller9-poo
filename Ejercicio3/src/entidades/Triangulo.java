package entidades;

public class Triangulo extends Figura {
   
//ATRIBUTOS
    
    private float lado1;
    private float lado2;
    private float lado3;
    
    
    //CONSTRUCTORES
    
    public Triangulo(){
        super();
        lado1 = 0.0f;
        lado2 = 0.0f;
        lado3 = 0.0f;
    }

    public Triangulo(float lado1, float lado2, float lado3, String color,
                      String nombreDeLaForma, Punto punto) {
        super(color, nombreDeLaForma, punto);
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
    }
    
    public Triangulo(float lado1, float lado2, float lado3, String color,
                      String nombreDeLaForma, int x, int y) {
        super(color, nombreDeLaForma, x, y);
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
    }

      
    //GETTERS Y SETTERS
    
    public float getLado1() {
        return lado1;
    }

    public void setLado1(float lado1) {
        this.lado1 = lado1;
    }

    public float getLado2() {
        return lado2;
    }

    public void setLado2(float lado2) {
        this.lado2 = lado2;
    }
    
    public float getLado3() {
        return lado3;
    }

    public void setLado3(float lado3) {
        this.lado3 = lado3;
    }
    
    
    //SOBREESCRITURA DE MÉTODO DE IMPRESIÓN
      
    @Override
    public String toString() {
        return super.toString() + "\nTipo: Triángulo"+ "\nLado 1: " +
        getLado1() + "\nLado 2: " + getLado2() + "\nLado 3: " + getLado3() +
        "\nÁrea: "+ getArea()  + "\nPerímetro: "+ getPerimetro();
    }
 
    
    //REDEFINICIÓN DE MÉTODOS ABSTRACTOS
    @Override
    public float getArea() {
        float s = getPerimetro()/2;
        return (float) Math.sqrt(s*(s-lado1)*(s-lado2)*(s-lado3));
    }
    
    @Override
    public float getPerimetro() {
        return lado1+lado2+lado3;
    }
    
}
