package CSVread;

import java.util.List;

public class TableWithLabels extends Table{


    TableWithLabels(){
        super();
    }


    @Override
    public RowWithLabel getRowAt(int rowNumber) {
        return (RowWithLabel) data.get(rowNumber);
    }

    public void add(RowWithLabel r){
        data.add(r);
    }

    public String toString(){
        String ret = "";
        for(String elem : headers){
            ret += elem;
            ret += "\t\t";
        }
        ret += "\n";
        for(int i = 0; i < data.size(); i++){
            ret += data.get(i);
            //ret += ' ' + data.get(i).getLabel();
            ret += '\n';
        }
        return ret;
    }

}
