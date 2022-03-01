package CSVread;

import java.util.LinkedList;
import java.util.List;

public class Row {

    protected List<Double> data;

    public Row(){
        super();
        data = new LinkedList<>();
    }

    public List<Double> getData(){
        return data;
    }

    public void add(Double number){
        data.add(number);
    }

    public int size(){
        return data.size();
    }

    @Override
    public String toString() {
        String ret = "";
        for(int i = 0; i < data.size(); i++) {
            ret += data.get(i);
            ret += "\t\t";
        }
        return ret;
    }
}
