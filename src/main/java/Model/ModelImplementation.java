package Model;

import CSVread.CSV;
import CSVread.TableWithLabels;
import Controller.ControllerImplementation;
import View.ViewImplementation;

import java.io.FileNotFoundException;

public class ModelImplementation{

    private ViewImplementation view;

    private TableWithLabels data;

    public ModelImplementation(ViewImplementation view){
        super();
        this.view = view;
    }

    public void setView(ViewImplementation view) {
        this.view = view;
    }


    public void loadData(String fileName) throws FileNotFoundException {
        data = CSV.readTableWithLabels(fileName);
    }

}
