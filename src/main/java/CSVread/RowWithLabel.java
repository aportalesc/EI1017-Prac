package CSVread;

import java.util.LinkedList;
import java.util.List;

public class RowWithLabel extends Row implements RowInterface{

    private String label;

    RowWithLabel(String label){
        super();
        this.label = label;
    }

    public String getLabel(){
        return label;
    }

    @Override
    public String toString() {
        String ret = "";
        for(int i = 0; i < data.size(); i++) {
            ret += data.get(i);
            ret += "\t\t";
        }
        ret += label;
        return ret;
    }
}
