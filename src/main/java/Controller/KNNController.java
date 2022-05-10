package Controller;

import Model.KNNModel;
import View.KNNView;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileNotFoundException;

public class KNNController {

    private KNNModel model;
    private KNNView view;

    private FileChooser fileChooser;

    public KNNController(KNNModel model, KNNView view){
        super();
        this.model = model;
        this.view = view;
        this.fileChooser = new FileChooser();
    }

    public void setModel(KNNModel model) {
        this.model = model;
    }

    public void setView(KNNView view) {
        this.view = view;
    }

    public void loadData()  {
       File f = fileChooser.showOpenDialog(null);
       if(f != null)
           model.loadData(f.getAbsolutePath());
    }

    public void estimateParams(String estimatePoint, boolean esNuevo){
        model.estimateParams(estimatePoint, esNuevo);
    }

    public void setDistanceType(Object selectedItem) {
        model.setDistanceType(selectedItem);
    }
}
