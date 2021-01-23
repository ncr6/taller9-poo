package entidades;


public class Elipse extends Figura{
    
    //ATRIBUTOS
    
    private float radioMayor;
    private float radioMenor;
    
    
    //CONSTRUCTORES
    
    public Elipse(){
        super();
        radioMayor = 0.0f;
        radioMenor = 0.0f;
    }

    public Elipse(float radioMayor, float radioMenor, String color,
                  String nombreDeLaForma, Punto punto) {
        super(color, nombreDeLaForma, punto);
        this.radioMayor = radioMayor;
        this.radioMenor = radioMenor;
    }
    
    public Elipse(float radioMayor, float radioMenor, String color,
                  String nombreDeLaForma, int x, int y) {
        super(color, nombreDeLaForma, x, y);
        this.radioMayor = radioMayor;
        this.radioMenor = radioMenor;
    }

      
    //GETTERS Y SETTERS
    
    public float getRadioMayor() {
        return radioMayor;
    }

    public void setRadioMayor(float radioMayor) {
        this.radioMayor = radioMayor;
    }

    public float getRadioMenor() {
        return radioMenor;
    }

    public void setRadioMenor(float radioMenor) {
        this.radioMenor = radioMenor;
    }

     public float areaEscala(float escala){
       return (getRadioMayor()*escala) * (getRadioMenor()*escala);
    }
     
      public float perimetroEscala(float escala){
       return 2*(getRadioMayor()*escala + getRadioMenor()*escala);
    }
    
    
    //SOBREESCRITURA DE MÉTODO DE IMPRESIÓN
      
    @Override
    public String toString() {
        return super.toString() + "\nTipo: Figura curva." + "\nRadio Mayor: " +
                getRadioMayor() + "\nRadio Menor: " + getRadioMenor() +
                "\nÁrea: "+ getArea()  + "\nPerímetro: "+ getPerimetro();
    }
 
    
    //REDEFINICIÓN DE MÉTODOS ABSTRACTOS
    @Override
    public float getArea() {
        return (float)Math.PI*(getRadioMayor()*getRadioMenor());
    }
    
    @Override
    public float getPerimetro() {
        double perimetro = 2*Math.PI*Math.sqrt((Math.pow(getRadioMenor(),2)+
                           Math.pow(getRadioMayor(), 2))/2);
        return (float)perimetro;
    }

    
}
