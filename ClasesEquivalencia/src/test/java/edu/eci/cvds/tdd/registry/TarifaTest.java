package edu.eci.cvds.tdd.aerodescuentos;

import org.junit.Assert;
import org.junit.Test;

public class TarifaTest {
    @Test
    public void shouldBeInvalidFare(){
        try {
            double tarifa = CalculadorDescuentos.calculoTarifa(-100,-18,-22);
            Assert.assertTrue(false);
        }
        catch(Exception e) {
            Assert.assertTrue(true);
        }
    }
    @Test
    public void shouldBeDisccountAge(){
        double tarifa = CalculadorDescuentos.calculoTarifa(50,8,2);
        Assert.assertEquals(47.5,tarifa,0.05);
    }
}