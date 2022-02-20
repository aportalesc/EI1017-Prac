package CSVread;

import java.util.ArrayList;
import java.util.List;

public class TableWithLabels extends Table implements TableInterface{

    TableWithLabels(){
        super();
    }

    private RowWithLabel stringToRowWithLabel(String str){
        String[] aux = str.split(",");
        RowWithLabel ret = new RowWithLabel(aux[aux.length - 1]);
        for(int i = 0; i < aux.length - 1; i++)
            ret.add(Double.parseDouble(aux[i]));

        return ret;
    }

    @Override
    public RowWithLabel getRowAt(int rowNumber) {
        return stringToRowWithLabel(headers.get(rowNumber));
    }

    @Override
    public int numberOfColumns() {
        return stringToRowWithLabel(headers.get(1)).getData().size();
    }
}
