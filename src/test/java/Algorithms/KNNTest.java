package Algorithms;

import CSVread.CSV;
import CSVread.TableWithLabels;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class KNNTest {

    @Test
    void estimate() throws FileNotFoundException {
        TableWithLabels t = CSV.readTableWithLabels("src/main/resources/iris.csv");

        KNN k = new KNN();
        k.train(t);
        List<Double> l = new ArrayList<>();
        l.add(5.8);
        l.add(4.0);
        l.add(1.2);
        l.add(0.2);
        List<Double> l2 = new ArrayList<>();
        l2.add(6.7);
        l2.add(3.0);
        l2.add(5.0);
        l2.add(1.7);
        List<Double> l3 = new ArrayList<>();
        //6.5,3.2,5.1,2.0,Iris-virginica
        l3.add(6.5);
        l3.add(3.2);
        l3.add(5.1);
        l3.add(2.0);
        assertEquals("Iris-setosa",k.estimate(l));
        assertEquals("Iris-versicolor",k.estimate(l2));
        assertEquals("Iris-virginica",k.estimate(l3));
    }
}