import org.example.Avion;
import org.example.AvionPrivado;
import org.junit.Assert;
import org.junit.Test;

public class AvionPrivadoTest {
    private AvionPrivado privado = new AvionPrivado(50, 10);
    @Test
    public void testVolar() {
        int resultado = privado.volar(10);

        Assert.assertEquals(125, resultado);
    }
    @Test
    public void testGetConsumoCombustible() {
        int resultado = privado.getConsumoCombustible();

        Assert.assertEquals(10, resultado);
    }
}
