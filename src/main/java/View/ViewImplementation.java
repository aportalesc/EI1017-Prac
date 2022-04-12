package View;

import Controller.ControllerImplementation;
import Model.ModelImplementation;
import javafx.scene.control.Button;

public class ViewImplementation {

    private ModelImplementation model;
    private ControllerImplementation controller;

    Button btnLoad = new Button("Cargar dataset");

    ViewImplementation(ModelImplementation model, ControllerImplementation controller){
        super();
        this.model = model;
        this.controller = controller;

    }

    public void start() {

        btnLoad.setOnAction(e-> controller.loadData());
    }

    public void setController(ControllerImplementation controller) {
        this.controller = controller;
    }

    public void setModel(ModelImplementation model) {
        this.model = model;
    }
}
