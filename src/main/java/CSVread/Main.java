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
        fila2.add(1.0);
        fila2.add(2.0);
        fila2.add(3.0);
        boolean pr = 1.0 == 1.0;
        fila.equals(fila2);
        Table tabla = new Table();
        System.out.println(fila.equals(fila2));
        //tabla.add(fila);
        //tabla.add(fila2);
        //System.out.println(tabla);

       //List<Double> col = tabla.getColumnAt(2);
       //System.out.println(col);

       //Table t = CSV.readTable("src/main/resources/miles_dollars.csv");
       //List<Double> colum = t.getColumnAt(1);
       //System.out.println(t);

        /*
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
        System.out.println(f.getData());
        System.out.println(f.getLabel());

        TableWithLabels t = new TableWithLabels();
        t.add("1,2,3,4,sedoso");
        t.add(("5,6,7,8,belmont"));

        RowWithLabel filaa = t.getRowAt(1);
        System.out.println(filaa);
        System.out.println(filaa.getLabel());
        System.out.println(filaa.data);


        RowWithLabel f = new RowWithLabel("iris-setosa");
        f.add(1.0);
        f.add(2.0);
        f.add(3.0);
        RowWithLabel f2 = new RowWithLabel("iris-virginica");
        f2.add(4.0);
        f2.add(5.0);
        f2.add(6.0);

        TableWithLabels tl = new TableWithLabels();
        tl.add(f);
        tl.add(f2);
        tl.addHeader("C1");
        tl.addHeader("C2");
        tl.addHeader("C3");
        tl.addHeader("Clase");

        System.out.println(tl);

         */
        //TableWithLabels tl = CSV.readTableWithLabels("src/main/resources/iris.csv");
        //System.out.println(tl);
    }
}
