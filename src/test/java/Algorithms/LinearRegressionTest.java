package Algorithms;

import CSVread.CSV;
import CSVread.Table;
import Exceptions.EmptyTableException;
import Exceptions.ZeroDivisionException;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class LinearRegressionTest {

    LinearRegression recta = new LinearRegression();

    LinearRegressionTest() throws FileNotFoundException, ZeroDivisionException, EmptyTableException {

        Table t = CSV.readTable("src/main/resources/miles_dollars.csv");
        recta.train(t);

    }

    @Test
    void train(){
        Table t2 = new Table();
        assertEquals(1.255, recta.getAlpha(), 0.001);
        assertEquals(274.85, recta.getBeta(), 0.01);
        assertThrows(EmptyTableException.class, () -> recta.train(t2));
        assertThrows(ZeroDivisionException.class, () -> recta.train(t2));
    }

    @Test
    void estimate(){
        assertEquals(283.635, recta.estimate(7.0), 0.01);
        assertEquals(281.125, recta.estimate(5.0), 0.01);

    }
}