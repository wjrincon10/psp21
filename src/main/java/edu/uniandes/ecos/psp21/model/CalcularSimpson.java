/*
 * Paquete que representa el modelo.
 */
package edu.uniandes.ecos.psp21.model;

/**
 * Clase que calcula el valor esperado segun la
 * segun la regla de simpson
 * @author wilman rincon
 */
public class CalcularSimpson {
     /*
    * valor predetermindao de numseg
    */
    private double num_seg = 10; 
    
    /*
    * varibale valor de x
    */
    private double x=0;
    
    /*
    * varibale de W
    */
    private double W = 0; 
    
    /*
    * variable para dof
    */
    private double dof = 0; 
    
    /*
    * Constructor de la clase
    */
    public CalcularSimpson(double xp,double dof){ 
        this.dof = dof; 
        x= xp;
        W = xp/num_seg; 
    }
    
    /*
    * Metodo principal para calcular la intergral
    */
    public double integral(){
        W = W/3;
        double Xi=0;
        double sum=0;
        
        sum = sum + functionX((x*0) /10)*W*1;
        sum = sum + functionX((x*1) /10)*W*4;
        sum = sum + functionX((x*2) /10)*W*2;
        sum = sum + functionX((x*3) /10)*W*4;
        sum = sum + functionX((x*4) /10)*W*2;
        sum = sum + functionX((x*5) /10)*W*4;
        sum = sum + functionX((x*6) /10)*W*2;
        sum = sum + functionX((x*7) /10)*W*4;
        sum = sum + functionX((x*8) /10)*W*2;
        sum = sum + functionX((x*9) /10)*W*4;
        sum = sum + functionX((x*10) /10)*W*1;
        
        
        return sum;
    }
    
    /*
    * Calcula el valor de F(x)
    */
    public double functionX(double x){
        double num=0;
        double den =0;
        
        num = factorial(((dof+1)/2));
        den = (Math.sqrt(dof*Math.PI))*factorial((dof/2));
        return (num/den)*function2(x); 
    }
    
    /*
    * Calcula el valor  de la segunda parte de la funcion
    */
    public double function2 (double x){
        double base=0;
        double exp =0;
        
        base= 1+((x*x)/dof);
        exp = -1*((dof+1)/2);
        
        return Math.pow(base, exp);
    }
    
    /*
    * Calcula el valor del factorial de un numero
    */
    public double factorial(double n){ 
         int fact = 1;
          n = n-1;
          
        for ( int i = 1 ; i <= n ; i++ ){
            fact = fact*i;
        }
          
        return fact;
    } 
}
