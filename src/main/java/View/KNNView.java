package View;

import Controller.KNNController;
import Model.KNNModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
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

        // Parte derecha de la ventana
        Button btnLoad = new Button("Open file");
        btnLoad.setOnAction(e-> controller.loadData());

        ObservableList distances = FXCollections.observableArrayList("EUCLIDEAN", "MANHATTAN")  ;
        ComboBox comboDistances = new ComboBox(distances);

        TextField enterPoint = new TextField("New Point");
        TextField labelText = new TextField("Label");
        labelText.setDisable(true);
        Button btnEstm = new Button("Estimate");

        VBox vBoxRight = new VBox(btnLoad, comboDistances, enterPoint, labelText, btnEstm);
        vBoxRight.setAlignment(Pos.CENTER_LEFT);

        BorderPane bp = new BorderPane();
        bp.setRight(vBoxRight);

        // Parte izquierda de la ventana
        ObservableList AxisNames = FXCollections.observableArrayList("sepal length", "sepal width", "petal length", "petal width");
        ComboBox yAxisCombo = new ComboBox(AxisNames);

        VBox vBoxLeft = new VBox(yAxisCombo);
        vBoxLeft.setAlignment(Pos.CENTER_LEFT);
        bp.setLeft(vBoxLeft);

        // Parte inferior de la ventana
        ComboBox xAxisCombo = new ComboBox(AxisNames);

        VBox vBoxBottom = new VBox(xAxisCombo);
        vBoxBottom.setAlignment(Pos.CENTER);
        bp.setBottom(vBoxBottom);

        // Parte central de la ventana
        NumberAxis xAxis = new NumberAxis();
        xAxis.setLabel("X");
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Y");

        ScatterChart scatterChart = new ScatterChart(xAxis, yAxis);
        bp.setCenter(scatterChart);

        // Creación de la escena
        Tab KNNTab = new Tab("KNN", bp);

        TabPane tabPane = new TabPane();
        tabPane.getTabs().add(KNNTab);
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        Scene scene = new Scene(tabPane, 700, 500);
        stage.setScene(scene);
        stage.show();

    }

    public void setController(KNNController controller) {
        this.controller = controller;
    }

    public void setModel(KNNModel model) {
        this.model = model;
    }

    public void newDataIsLoaded(){

    }
}
