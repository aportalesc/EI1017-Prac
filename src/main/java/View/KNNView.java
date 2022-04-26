package View;

import Controller.KNNController;
import Model.KNNModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class KNNView {

    private KNNModel model;
    private KNNController controller;
    private Stage stage;
    private ScatterChart scatterChart;
    private NumberAxis xAxis;
    private NumberAxis yAxis;
    private ComboBox xAxisCombo;
    private ComboBox yAxisCombo;



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
        comboDistances.getSelectionModel().selectFirst();

        TextField enterPoint = new TextField("New Point");
        TextField labelText = new TextField("Label");
        labelText.setDisable(true);

        Button btnEstimate = new Button("Estimate");
        //btnEstimate.setOnAction(e -> controller.estimateParams());

        VBox vBoxRight = new VBox(btnLoad, comboDistances, enterPoint, labelText, btnEstimate);
        vBoxRight.setAlignment(Pos.CENTER_LEFT);

        BorderPane bp = new BorderPane();
        bp.setRight(vBoxRight);

        // Parte izquierda de la ventana
        yAxisCombo = new ComboBox();

        VBox vBoxLeft = new VBox(yAxisCombo);
        vBoxLeft.setAlignment(Pos.CENTER_LEFT);
        bp.setLeft(vBoxLeft);

        // Parte inferior de la ventana
        xAxisCombo = new ComboBox();

        VBox vBoxBottom = new VBox(xAxisCombo);
        vBoxBottom.setAlignment(Pos.CENTER);
        bp.setBottom(vBoxBottom);

        // Parte central de la ventana
        xAxis = new NumberAxis();
        xAxis.setLabel("X");
        yAxis = new NumberAxis();
        yAxis.setLabel("Y");

        scatterChart = new ScatterChart(xAxis, yAxis);
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

        List<String> labels = new ArrayList<>();
        List<XYChart.Series> series = new LinkedList<>();

        for(int i = 0; i < model.getData().getSize(); i++) {
            if(!labels.contains(model.getData().getRowAt(i).getLabel())) {
                labels.add(model.getData().getRowAt(i).getLabel());
                series.add(new XYChart.Series());
            }
        }

        for(int i = 0; i < model.getData().getSize(); i++){
            String l = model.getData().getRowAt(i).getLabel();

            for(int j = 0; j < series.size(); j++){
                if(l.equals(labels.get(j)))

                    series.get(j).getData().add(new XYChart.Data(model.getData().getRowAt(i).getData().get(0), model.getData().getRowAt(i).getData().get(1)));

            }
        }

        for(int i = 0; i < series.size(); i++)
            scatterChart.getData().addAll(series.get(i));

        ObservableList axisNames = FXCollections.observableArrayList(model.getData().getHeaders());
        axisNames.remove(axisNames.size() - 1);
        scatterChart.setTitle(axisNames.get(1).toString() + " vs. " + axisNames.get(0).toString());
        xAxis.setLabel(axisNames.get(0).toString());
        yAxis.setLabel(axisNames.get(1).toString());
        xAxisCombo.setItems(axisNames);
        xAxisCombo.getSelectionModel().selectFirst();
        yAxisCombo.setItems(axisNames);
        yAxisCombo.getSelectionModel().select(1);

    }
}
