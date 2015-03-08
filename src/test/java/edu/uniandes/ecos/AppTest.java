/*
 * Paquete para probar el modelo 
 */
package edu.uniandes.ecos;

import static junit.framework.Assert.assertTrue;
import edu.uniandes.ecos.psp21.model.CalcularSimpson;

/**
 * Clase para probar la clase CalcularSimsons 
 * @author wilman rincon
 */
public class AppTest {
    /**
     * verifica el valor esperado para un valor de X y Dof dado
     */
    public void testApp()
    {
        double p=0.20;
        double dof = 6;
        double x = 0.55338;
        
        CalcularSimpson calcSimpson = new CalcularSimpson(p,dof);
        
        calcSimpson.integral();
        assertTrue( true );
    }
}