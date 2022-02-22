package CSVread;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CSV {

    public static Table readTable(String fileName) throws FileNotFoundException {
        Table t = new Table();
        Scanner sc = new Scanner(new File(fileName));

        String[] head = sc.nextLine().split(",");
        for(String elem : head)
            t.addHeader(elem);

        while(sc.hasNextLine()){
            Row r = new Row();
            String[] str = sc.next().split(",");
            for(String elem : str)
                r.add(Double.parseDouble(elem));
            t.add(r);
        }
        sc.close();
        return t;
    }

    public static TableWithLabels readTableWithLabels(String fileName) throws FileNotFoundException {
        TableWithLabels t = new TableWithLabels();
        Scanner sc = new Scanner(new File(fileName));

        String[] head = sc.nextLine().split(",");
        for(String elem : head)
            t.addHeader(elem);

        while(sc.hasNextLine()){

            String[] str = sc.next().split(",");
            RowWithLabel r = new RowWithLabel(str[str.length - 1]);
            for(int i = 0; i < str.length - 1; i++)
                r.add(Double.parseDouble(str[i]));
            t.add(r);
        }
        sc.close();
        return t;
    }
}
