package CSVread;

import java.util.List;

public class Row {

    List<Double> data;

    public Row(){
        super();
    }

    public List<Double> getData(){
        return data;
    }
    

    public void add(Double number){
        data.add(number);
    }

}
