package CSVread;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CSV {

    public static Table readTable(String fileName) throws FileNotFoundException {
        Table t = new Table();
        Scanner sc = new Scanner(new File(fileName));

        while(sc.hasNextLine())
            t.add(sc.next());

        sc.close();
        return t;
    }
}
