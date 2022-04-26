package Model;

import CSVread.CSV;
import CSVread.TableWithLabels;
import View.KNNView;

import java.io.FileNotFoundException;


public class KNNModel {

    private KNNView view;


    private TableWithLabels data;

    public KNNModel(KNNView view){
        super();
        this.view = view;
    }

    public void setView(KNNView view) {
        this.view = view;
    }


    public void loadData(String fileName) throws FileNotFoundException {
        data = CSV.readTableWithLabels(fileName);
        view.newDataIsLoaded();
    }


}
