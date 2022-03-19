package Algorithms;

import CSVread.CSV;
import CSVread.Table;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Table t1 = CSV.readTable("src/main/resources/prueba2d.csv");
        Kmeans modelo = new Kmeans(2, 20, 1);
        modelo.train(t1);
        System.out.println(modelo.getCentr());
    }
}
