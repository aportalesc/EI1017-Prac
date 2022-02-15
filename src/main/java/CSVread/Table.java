package CSVread;

import CSVread.Row;

import java.util.LinkedList;
import java.util.List;

public class Table {
    String headers;
    List<Row> elem;

    public Table() {
        super();
    }

    public Row getRowAt(int rowNumber){
        return elem.get(rowNumber);
    }

    public List<Double> getColumnAt(int columnNumber){
        List<Double> ret = new LinkedList<>();
        for(Row r : elem)
            ret.add(r.getData().get(columnNumber));
        return ret;
    }

    public void add(Row r){
        elem.add(r);
    }
}
