package Algorithms;

import CSVread.CSV;
import CSVread.Table;
import CSVread.TableWithLabels;
import DistanceAlgorithms.Distance;
import DistanceAlgorithms.EuclideanDistance;
import DistanceAlgorithms.ManhattanDistance;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        TableWithLabels t1 = CSV.readTableWithLabels("src/main/resources/iris.csv");
        Distance dist = new EuclideanDistance();
        Kmeans modelo = new Kmeans(3, 20, 1, dist);
        modelo.train(t1);
        System.out.println(modelo.getCentr());
    }
}
