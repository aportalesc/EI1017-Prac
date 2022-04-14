package View;

import Algorithms.KNN;
import Controller.KNNController;
import DistanceAlgorithms.Distance;
import Model.KNNModel;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class KNNView {

    private KNNModel model;
    private KNNController controller;
    private Stage stage;



    KNNView(Stage stage, KNNModel model, KNNController controller){
        super();
        this.stage = stage;
        this.model = model;
        this.controller = controller;

    }

    public void createGUI(){
        Button btnLoad = new Button("Cargar dataset");

        btnLoad.setOnAction(e-> controller.loadData());
        Scene scene = new Scene(btnLoad, 400, 300);
        stage.setScene(scene);
        stage.show();

    }

    public void setController(KNNController controller) {
        this.controller = controller;
    }

    public void setModel(KNNModel model) {
        this.model = model;
    }
}
