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
        Factory f = new DistanceFactory();
        Distance dist = f.getDistance(DistanceType.EUCLIDEAN);
        Distance dist2 = f.getDistance(DistanceType.MANHATTAN);
        Kmeans modelo = new Kmeans(3, 3, 1, dist);
        Kmeans modelo2 = new Kmeans(3, 3, 1, dist2);

        modelo.train(t);
        modelo2.train(t);
        assertNotEquals(modelo.getCentr(), modelo2.getCentr());
    }
}