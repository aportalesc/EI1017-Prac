package CSVread;

import java.util.LinkedList;
import java.util.List;

public class Table implements TableInterface{

    protected List<String> headers;

    public Table() {
        super();
        headers = new LinkedList<>();
    }

    public Row getRowAt(int rowNumber){
        return stringToRow(headers.get(rowNumber));
    }

    public int numberOfColumns() {
        return stringToRow(headers.get(1)).getData().size();
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

    public int getSize(){
        return headers.size();
    }
    @Override
    public String toString() {
       String ret = "";
       String [] etiq = headers.get(0).split(",");
       for(String elem : etiq){
           ret += elem;
           ret += "\t\t";
       }
       ret += "\n";
       for(int i = 1; i < headers.size(); i++){
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
