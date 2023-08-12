import org.example.Avion;
import org.example.CalculadorCombustible;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CalculadorCombustibleTest {
    private CalculadorCombustible calculador;

    @Before
    public void setUp() {
        calculador = CalculadorCombustible.getInstance();
    }

    @Test
    public void testGetInstanceNotNull() {
        CalculadorCombustible resultado = CalculadorCombustible.getInstance();

        Assert.assertSame(calculador, resultado);
    }

    @Test
    public void testCalcularCombustibleAvion() {
        Avion avion = mock(Avion.class);
        final int distancia = 10;

        //Con mockito simulamos el comportamiento de la clase Avion, que es externa a la que queremos testear
        when(avion.volar(distancia)).thenReturn(125);

        int resultado = calculador.calcularCombustible(avion, distancia);

        Assert.assertEquals(125, resultado);
    }
}
