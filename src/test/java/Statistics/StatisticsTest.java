package Statistics;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StatisticsTest {

    double[] c0 = {1};
    double[] c1 = {5,5,5,5,5};
    double[] c2 = {1,2,3,4};
    double[] c3 = {1,2,-2,-1};
    double[] c4 = {};
    Statistics est = new Statistics();

    @Test
    @DisplayName("Test de la media aritmética")
    void mediaAritmeticaTest() {
        assertEquals(1, est.mediaAritmetica(c0));
        assertEquals(5, est.mediaAritmetica(c1));
        assertEquals(2.5, est.mediaAritmetica(c2));
        assertEquals(0, est.mediaAritmetica(c3));
        assertEquals(0, est.mediaAritmetica(c4));
    }

    @Test
    @DisplayName("Test de la varianza")
    void varianza() {
        assertEquals(0, est.varianza(c0));
        assertEquals(0, est.varianza(c1));
        assertEquals(1.25, est.varianza(c2));
        assertEquals(2.5, est.varianza(c3));
        assertEquals(0, est.varianza(c4));
    }

    @Test
    @DisplayName("Test de la desviación típica")
    void desviacionTipica() {
        assertEquals(0, est.desviacionTipica(c0));
        assertEquals(0, est.desviacionTipica(c1));
        assertEquals(1.118, est.desviacionTipica(c2), 0.001);
        assertEquals(1.581, est.desviacionTipica(c3), 0.001);
        assertEquals(0, est.desviacionTipica(c4));
    }
}