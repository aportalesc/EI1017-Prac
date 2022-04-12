package Model;

import CSVread.CSV;
import CSVread.TableWithLabels;
import Controller.ControllerImplementation;
import View.ViewImplementation;

import java.io.FileNotFoundException;

public class ModelImplementation{
    private ViewImplementation view;
    private ControllerImplementation controller;

    private TableWithLabels data;

    ModelImplementation(ViewImplementation view, ControllerImplementation controller){
        super();
        this.view = view;
        this.controller = controller;
    }

    public void setView(ViewImplementation view) {
        this.view = view;
    }

    public void setController(ControllerImplementation controller) {
        this.controller = controller;
    }

    public void loadData(String fileName) throws FileNotFoundException {
        data = CSV.readTableWithLabels(fileName);
    }
    
}
