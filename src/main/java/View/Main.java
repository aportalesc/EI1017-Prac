package View;

import Controller.KNNController;
import Model.KNNModel;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        KNNView view = new KNNView(stage,null, null);
        KNNModel model = new KNNModel(view);
        KNNController controller = new KNNController(model, view);

        view.setModel(model);
        view.setController(controller);

        view.createGUI();

    }
}