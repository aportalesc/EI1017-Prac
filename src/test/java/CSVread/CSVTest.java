package CSVread;

import org.junit.jupiter.api.DisplayName;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class CSVTest {

    @org.junit.jupiter.api.Test
    @DisplayName("readTableTest")
    void readTable() throws FileNotFoundException {
        Table t = CSV.readTable("src/main/resources/miles_dollars.csv");
        System.out.println("Comprobamos el número de filas de miles_dollars.csv");
        assertEquals(25, t.getSize());
        System.out.println("Comprobamos el número de columnas de miles_dollars.csv");
        assertEquals(2, t.numberOfColumns());

    }

    @org.junit.jupiter.api.Test
    @DisplayName("readTableWithLabelsTest")  // Revisar
    void readTableWithLabels() throws FileNotFoundException {
        Table t = CSV.readTableWithLabels("src/main/resources/iris.csv");
        System.out.println("Comprobamos el número de filas de iris.csv");
        assertEquals(150, t.getSize());
        System.out.println("Comprobamos el número de columnas de iris.csv");
        assertEquals(4, t.numberOfColumns());
    }
}