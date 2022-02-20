package CSVread;

import java.io.FileNotFoundException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {


        Row fila = new Row();
        fila.add(1.0);
        fila.add(2.0);
        fila.add(3.0);
        Row fila2 = new Row();
        fila2.add(4.0);
        fila2.add(5.0);
        fila2.add(6.0);

        Table tabla = new Table();
        tabla.add("1.0,2.0,3.0");
        tabla.add("4.0,5.0,6.0");
        //System.out.println(tabla);

       //List<Double> col = tabla.getColumnAt(2);
       //System.out.println(col);

       //Table t = CSV.readTable("src/main/resources/miles_dollars.csv");

       //System.out.println(t);

        RowWithLabel f = new RowWithLabel("iris-setosa");
        f.add(1.0);
        f.add(2.0);
        f.add(3.0);
        RowWithLabel f2 = new RowWithLabel("iris-virginica");
        f2.add(4.0);
        f2.add(5.0);
        f2.add(6.0);
        System.out.println(f);
        System.out.println(f2);

    }
}
