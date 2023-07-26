import org.example.AvionComercial;
import org.junit.Assert;
import org.junit.Test;

public class AvionComercialTest {
    public AvionComercial avionComercial = new AvionComercial(50, 10);
    @Test
    public void testVolar() {
        int resultado = avionComercial.volar(20);

        Assert.assertEquals(200, resultado);
    }

    @Test
    public void testGetConsumoCombustible() {
        int resultado = avionComercial.getConsumoCombustible();

        Assert.assertEquals(10, resultado);
    }
}
