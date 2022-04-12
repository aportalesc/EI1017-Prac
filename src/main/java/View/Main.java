package View;

import Controller.ControllerImplementation;
import Model.ModelImplementation;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        ViewImplementation view = new ViewImplementation(stage,null, null);
        ModelImplementation model = new ModelImplementation(view);
        ControllerImplementation controller = new ControllerImplementation(model, view);

        view.setModel(model);
        view.setController(controller);

        view.createGUI();

    }
}