 

/**
 * Una clase sencilla para realizar calculos con fracciones.
 * @author (Milton Jesús Vera Contreras - miltonjesusvc@ufps.edu.co)
 * @version 0.000000000000001 :) --> Math.sin(Math.PI-Double.MIN_VALUE)
 */
public class Fraccionario {

    /**
     * Numerador
     */
    private int numerador;

    /**
     * Denominador
     */
    private int denominador;
    

    /**
     * Constructor default
     */
    public Fraccionario() {
        this.numerador = 0;
        this.denominador = 1;
    }//fin constructor default

    /**
     * Constructor 
     * @param numerador valor inicial de numerador
     * @param denominador valor inicial de denominador
     */
    public Fraccionario(int numerador, int denominador) {
        this.numerador = numerador;
        this.denominador = denominador;
        validar();
    }//fin constructor parametrizado
    public Fraccionario(Fraccionario otro){
        this(otro.getNumerador(),otro.getDenominador());
    }

    /**
     * Realiza la operacion suma = this + otro y retorna suma
     *
     * @param otro Un Fraccionario como sumando
     * @return this + otro
     */
    public Fraccionario sumar(Fraccionario otro) {
         Fraccionario rest= new Fraccionario();
        int num = this.getNumerador()*otro.getDenominador() + this.getDenominador()*otro.getNumerador();
        int den = this.getDenominador()*otro.getDenominador();
        rest.setNumerador(num);
        rest.setDenominador(den);
        //rest.simplificar();
        return rest;
        
    }//fin sumar

    /**
     * Realiza la operacion resta = this - otro y retorna suma
     *
     * @param otro Un Fraccionario como sustraendo
     * @return this - otro
     */
    public Fraccionario restar(Fraccionario otro) {
        Fraccionario rest= new Fraccionario();
        int num = this.getNumerador()*otro.getDenominador() - this.getDenominador()*otro.getNumerador();
        int den = this.getDenominador()*otro.getDenominador();
        rest.setNumerador(num);
        rest.setDenominador(den);
        //rest.simplificar();
        return rest;
    }//fin restar

    /**
     * Realiza la operacion producto = this * otro y retorna producto
     *
     * @param otro Un Fraccionario como factor
     * @return this * otro
     */
    public Fraccionario multiplicar(Fraccionario otro) {
        Fraccionario rest= new Fraccionario();
        rest.setNumerador(this.numerador*otro.getNumerador());
        rest.setDenominador(this.getDenominador()*otro.getDenominador());
        //rest.simplificar();
        return rest;
    }//fin multiplicar

    /**
     * Realiza la operacion cociente = this / otro y retorna cociente
     *
     * @param otro Un Fraccionario como divisor
     * @return this / otro
     */
    public Fraccionario dividir(Fraccionario otro) {
        Fraccionario rest= new Fraccionario();
        rest.setNumerador(this.numerador*otro.getDenominador());
        rest.setDenominador(this.getDenominador()*otro.getNumerador());
        //rest.simplificar();
        return rest;
    }//fin dividir 
    
    /**
     * Simplifica el fraccionario
     */
    public void simplificar(){
       //COMPLETE SIMPLIFICAR
       int maxDiv = mcd();
       setNumerador(this.numerador/maxDiv);
       setDenominador(this.denominador/maxDiv);
    }
    /**Retorna el maximo común divisor entre el numerador y el denominador*/
    private int mcd() {
        int n = Math.abs(this.numerador); 
        int d = Math.abs(this.denominador); 
        if (d == 0) {
            return n;
        }
        int r;
        while (d != 0) {
            r = n % d;
            n = d;
            d = r;
        }
        return n;
    }

    //Start GetterSetterExtension Code
    /**Getter method numerador*/
    public int getNumerador(){
        return this.numerador;
    }//end method getNumerador

    /**Setter method numerador*/
    public void setNumerador(int numerador){
        this.numerador = numerador;
    }//end method setNumerador

    /**Getter method denominador*/
    public int getDenominador(){
        return this.denominador;
    }//end method getDenominador

    /**Setter method denominador*/
    public void setDenominador(int denominador){
        this.denominador = denominador;
        validar();
    }//end method setDenominador
     /**
     * Valida si el denominador es distinto de 0
     */
    public void validar(){
        if(this.denominador==0) throw new RuntimeException("El denominador no puede ser 0");
    }

    //End GetterSetterExtension Code
}//End class !

