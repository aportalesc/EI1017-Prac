package View;

import javafx.scene.control.Button;

public class ViewImplementation {

    Button btnLoad = new Button("Cargar dataset");

    ViewImplementation(modelo, controlador);
    {

    }
    void empezar(){

        btnLoad.setOnAction(e-> controlador.loadData());
    }

}
