package CSVread;

import java.util.LinkedList;
import java.util.List;

public class Table {

    private List<String> headers;

    public Table() {
        super();
        headers = new LinkedList<>();
    }

    public Row getRowAt(int rowNumber){
        return stringToRow(headers.get(rowNumber));
    }

    public List<Double> getColumnAt(int columnNumber){
        List<Double> ret = new LinkedList<>();
        for(int i = 1; i < headers.size(); i++){
            Row r = stringToRow(headers.get(i));
            ret.add(r.getData().get(columnNumber));
        }
        return ret;
    }

    private Row stringToRow(String str){
        Row ret = new Row();
        String[] aux = str.split(",");
        for(String elem : aux)
            ret.add(Double.parseDouble(elem));

        return ret;
    }

    public void add(String str){
        headers.add(str);
    }

    @Override
    public String toString() {
       String ret = "";
       for(int i = 0; i < headers.size(); i++){
           String[] aux = headers.get(i).split(",");
           for(String elem : aux){
               ret += elem;
               ret += "\t\t";
           }
           if(i != headers.size() - 1)
               ret += '\n';
       }
       return ret;
    }
}
