package View;

import Controller.ControllerImplementation;
import Model.ModelImplementation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ViewImplementation {

    private ModelImplementation model;
    private ControllerImplementation controller;
    private Stage stage;

    Button btnLoad = new Button("Cargar dataset");

    ViewImplementation(Stage stage, ModelImplementation model, ControllerImplementation controller){
        super();
        this.stage = stage;
        this.model = model;
        this.controller = controller;

    }

    public void createGUI(){

        btnLoad.setOnAction(e-> controller.loadData());
        Scene scene = new Scene(btnLoad, 400, 300);
        stage.setScene(scene);
        stage.show();


    }

    public void setController(ControllerImplementation controller) {
        this.controller = controller;
    }

    public void setModel(ModelImplementation model) {
        this.model = model;
    }
}
