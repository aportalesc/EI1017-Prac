package DistanceAlgorithms;

import Algorithms.Kmeans;
import CSVread.CSV;
import CSVread.TableWithLabels;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class DistanceTest {

    @Test
    void calculateDistance() throws FileNotFoundException {
        TableWithLabels t = CSV.readTableWithLabels("src/main/resources/iris.csv");
        Distance dist = new EuclideanDistance();
        Distance dist2 = new ManhattanDistance();
        Kmeans modelo = new Kmeans(3, 3, 1, dist);
        Kmeans modelo2 = new Kmeans(3, 3, 1, dist2);

        modelo.train(t);
        modelo2.train(t);
        assertNotEquals(modelo.getCentr(), modelo2.getCentr());
    }
}