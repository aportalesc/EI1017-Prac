package Model;

import CSVread.CSV;
import CSVread.TableWithLabels;
import View.KNNObserver;
import View.KNNView;

import java.io.FileNotFoundException;

public class KNNModel {

    private KNNView view;
    private KNNObserver observers;

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
        for(KNNObserver obs : observers)
            obs.newDataIsLoaded();

    }

    public void registerObserver(KNNObserver o){
        observers.add(o);
    }

}
