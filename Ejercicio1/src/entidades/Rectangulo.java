package entidades;


public class Rectangulo extends Figura {
    
    //ATRIBUTOS
    
    private float ladoMayor;
    private float ladoMenor;
    
    
    //CONSTRUCTORES
    
    public Rectangulo(){
        super();
        ladoMayor = 0.0f;
        ladoMenor = 0.0f;
    }

    public Rectangulo(float ladoMayor, float ladoMenor, String color,
                      String nombreDeLaForma, Punto punto) {
        super(color, nombreDeLaForma, punto);
        this.ladoMayor = ladoMayor;
        this.ladoMenor = ladoMenor;
    }
    
    public Rectangulo(float ladoMayor, float ladoMenor, String color,
                      String nombreDeLaForma, int x, int y) {
        super(color, nombreDeLaForma, x, y);
        this.ladoMayor = ladoMayor;
        this.ladoMenor = ladoMenor;
    }

      
    //GETTERS Y SETTERS
    
    public float getLadoMayor() {
        return ladoMayor;
    }

    public void setLadoMayor(float ladoMayor) {
        this.ladoMayor = ladoMayor;
    }

    public float getLadoMenor() {
        return ladoMenor;
    }

    public void setLadoMenor(float ladoMenor) {
        this.ladoMenor = ladoMenor;
    }

     public float areaEscala(float escala){
       return (getLadoMayor()*escala) * (getLadoMenor()*escala);
    }
     
      public float perimetroEscala(float escala){
       return 2*(getLadoMayor()*escala + getLadoMenor()*escala);
    }
    
    
    //SOBREESCRITURA DE MÉTODO DE IMPRESIÓN
      
    @Override
    public String toString() {
        return super.toString() + "\nLado Mayor: " + getLadoMayor() +
               "\nLado Menor: " + getLadoMenor() + "\nÁrea: "+ getArea()  + 
               "\nPerímetro: "+ getPerimetro();
    }
 
    
    //REDEFINICIÓN DE MÉTODOS ABSTRACTOS
    @Override
    public float getArea() {
        return getLadoMayor()*getLadoMenor();
    }
    
    @Override
    public float getPerimetro() {
        return 2*(getLadoMayor() + getLadoMenor());
    }

    
}