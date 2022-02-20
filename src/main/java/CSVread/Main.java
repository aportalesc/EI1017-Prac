package CSVread;

public class Main {
    public static void main(String[] args) {


        Row fila = new Row();
        fila.add(1.0);
        fila.add(2.0);
        fila.add(3.0);
        Row fila2 = new Row();
        fila2.add(4.0);
        fila2.add(5.0);
        fila2.add(6.0);

        Table tabla = new Table();
        tabla.add(fila);
        tabla.add(fila2);
        System.out.println(tabla);


    }
}
