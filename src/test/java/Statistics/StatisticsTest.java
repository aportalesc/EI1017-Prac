package Statistics;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class StatisticsTest {

    Collection<Double> c0 = new ArrayList<>();
    Collection<Double> c1 = new ArrayList<>();
    Collection<Double> c2 = new ArrayList<>();
    Collection<Double> c3 = new ArrayList<>();
    Collection<Double> c4 = new ArrayList<>();


    StatisticsTest(){
        c0.add(1.0);
        c1.add(5.0);
        c1.add(5.0);
        c1.add(5.0);
        c1.add(5.0);
        c1.add(5.0);
        c2.add(1.0);
        c2.add(2.0);
        c2.add(3.0);
        c2.add(4.0);
        c3.add(1.0);
        c3.add(2.0);
        c3.add(-2.0);
        c3.add(-1.0);
    }
    @Test
    @DisplayName("Test de la media aritmética")
    void mediaAritmeticaTest() {
        assertEquals(1, Statistics.mediaAritmetica(c0));
        assertEquals(5, Statistics.mediaAritmetica(c1));
        assertEquals(2.5, Statistics.mediaAritmetica(c2));
        assertEquals(0, Statistics.mediaAritmetica(c3));
        assertEquals(0, Statistics.mediaAritmetica(c4));
    }

    @Test
    @DisplayName("Test de la varianza")
    void varianza() {
        assertEquals(0, Statistics.varianza(c0));
        assertEquals(0, Statistics.varianza(c1));
        assertEquals(1.25, Statistics.varianza(c2));
        assertEquals(2.5, Statistics.varianza(c3));
        assertEquals(0, Statistics.varianza(c4));
    }

    @Test
    @DisplayName("Test de la desviación típica")
    void desviacionTipica() {
        assertEquals(0, Statistics.desviacionTipica(c0));
        assertEquals(0, Statistics.desviacionTipica(c1));
        assertEquals(1.118, Statistics.desviacionTipica(c2), 0.001);
        assertEquals(1.581, Statistics.desviacionTipica(c3), 0.001);
        assertEquals(0, Statistics.desviacionTipica(c4));
    }
}