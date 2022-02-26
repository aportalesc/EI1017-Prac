package CSVread;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Table{

    protected List<String> headers;
    protected List<Row> data;

    public Table() {
        super();
        headers = new ArrayList<>();
        data = new ArrayList<>();
    }

    public Row getRowAt(int rowNumber){
        return data.get(rowNumber);
    }

    public int numberOfColumns() {
        return data.get(0).getData().size();
    }

    public List<Double> getColumnAt(int columnNumber){
        List<Double> ret = new ArrayList<>();
        for(Row r : data)
            ret.add(r.getData().get(columnNumber));
        return ret;
    }

    public void add(Row r){
        data.add(r);
    }

    public void addHeader(String s){
        headers.add(s);
    }

    public int getSize(){
        return data.size();
    }
    @Override
    public String toString() {
        String ret = "";
        for(String elem : headers){
            ret += elem;
            ret += "\t\t";
        }
        ret += "\n";
        for(int i = 0; i < data.size(); i++){
            ret += data.get(i);
            ret += '\n';
        }
        return ret;
    }
}
