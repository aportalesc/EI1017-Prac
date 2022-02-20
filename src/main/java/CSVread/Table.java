package CSVread;

import java.util.LinkedList;
import java.util.List;

public class Table {

    private List<Row> headers;

    public Table() {
        super();
        headers = new LinkedList<>();
    }

    public Row getRowAt(int rowNumber){
        return headers.get(rowNumber);
    }

    public List<Double> getColumnAt(int columnNumber){
        List<Double> ret = new LinkedList<>();
        for(Row r : headers)
            ret.add(r.getData().get(columnNumber));
        return ret;
    }

    public void add(Row r){
        headers.add(r);
    }

    @Override
    public String toString() {
       String ret = "";
       for(int i = 0; i < headers.size(); i++){
           ret += headers.get(i);
           ret += '\n';
       }
       return ret;
    }
}
