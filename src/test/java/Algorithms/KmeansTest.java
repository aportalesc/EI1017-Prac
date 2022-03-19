package Algorithms;

import CSVread.CSV;
import CSVread.Row;
import CSVread.RowWithLabel;
import CSVread.Table;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class KmeansTest {

    Kmeans modelo = new Kmeans(3, 3, 1);
    Kmeans modelo2 = new Kmeans(2, 3, 1);

    KmeansTest() throws FileNotFoundException {
        Table t = CSV.readTable("src/main/resources/prueba2d.csv");
        modelo.train(t);
        modelo2.train(t);
    }

    @Test
    void train() {
        List<Row> l1 = new LinkedList<>();
        List<Row> l2 = new LinkedList<>();
        Row r1 = new Row();
        r1.add(2.0);
        r1.add(2.0);
        Row r2 = new Row();
        r2.add(22.0);
        r2.add(22.0);
        Row r3 = new Row();
        r3.add(92.0);
        r3.add(92.0);
        l1.add(r1);
        l1.add(r2);
        l1.add(r3);
        Row r4 = new Row();
        r4.add(12.0);
        r4.add(12.0);
        l2.add(r4);
        l2.add(r3);
        
        assertEquals(l1,modelo.getCentr());
        assertEquals(l2,modelo2.getCentr());

    }

    @Test
    void estimate() {
        Row r1 = new Row();
        r1.add(2.0);
        r1.add(4.0);
        Row r2 = new Row();
        r2.add(100.0);
        r2.add(100.0);
        Row r3 = new Row();
        r3.add(19.3);
        r3.add(36.8);
        Row r4 = new Row();
        r4.add(47.8);
        r4.add(17.2);

        assertEquals("cluster-1", modelo.estimate(r1));
        assertEquals("cluster-3", modelo.estimate(r2));
        assertEquals("cluster-2", modelo.estimate(r3));
        assertEquals("cluster-2", modelo.estimate(r4));
        assertEquals("cluster-1", modelo2.estimate(r1));
        assertEquals("cluster-2", modelo2.estimate(r2));
        assertEquals("cluster-1", modelo2.estimate(r3));
        assertEquals("cluster-1", modelo2.estimate(r4));
    }
}