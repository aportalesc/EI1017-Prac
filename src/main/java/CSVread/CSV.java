package CSVread;
//hola que tal bien o mal???????
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CSV {

    public Table readTable(String fileName) throws FileNotFoundException {
        Table t = new Table();
        Scanner sc = new Scanner(new File(fileName));

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
}
