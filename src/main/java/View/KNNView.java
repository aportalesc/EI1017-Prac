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
    private ObservableList axisNames;
    private NumberAxis xAxis;
    private NumberAxis yAxis;
    private ComboBox comboDistances;
    private ComboBox xAxisCombo;
    private ComboBox yAxisCombo;
    private TextField labelText;
    private TextField enterPoint;
    private List<XYChart.Series> series;            // Contiene las series de puntos que se dibujan en la gráfica
    private List<String> labels;                    // Contiene los nombres de las etiquetas de cada grupo
    private List<List<List<Double>>> dataSeries;    // Contiene los puntos clasificados en las distintas series

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
        comboDistances = new ComboBox(distances);
        comboDistances.getSelectionModel().selectFirst();
        comboDistances.setDisable(true);
        comboDistances.setOnAction(e -> controller.setDistanceType(comboDistances.getSelectionModel().getSelectedItem()));

        enterPoint = new TextField("New Point");
        labelText = new TextField("Label");
        labelText.setDisable(true);

        Button btnEstimate = new Button("Estimate");
        btnEstimate.setOnAction(e -> controller.estimateParams(enterPoint.getText(), true));

        VBox vBoxRight = new VBox(btnLoad, comboDistances, enterPoint, labelText, btnEstimate);
        vBoxRight.setAlignment(Pos.CENTER_LEFT);

        BorderPane borderPane = new BorderPane();
        borderPane.setRight(vBoxRight);

        // Parte izquierda de la ventana
        yAxisCombo = new ComboBox();
        yAxisCombo.setOnAction(e -> setAxis(xAxisCombo.getSelectionModel().getSelectedIndex(), yAxisCombo.getSelectionModel().getSelectedIndex()));

        VBox vBoxLeft = new VBox(yAxisCombo);
        vBoxLeft.setAlignment(Pos.CENTER_LEFT);
        borderPane.setLeft(vBoxLeft);

        // Parte inferior de la ventana
        xAxisCombo = new ComboBox();
        xAxisCombo.setOnAction(e -> setAxis(xAxisCombo.getSelectionModel().getSelectedIndex(), yAxisCombo.getSelectionModel().getSelectedIndex()));

        VBox vBoxBottom = new VBox(xAxisCombo);
        vBoxBottom.setAlignment(Pos.CENTER);
        borderPane.setBottom(vBoxBottom);

        // Parte central de la ventana
        xAxis = new NumberAxis();
        xAxis.setLabel("X");
        yAxis = new NumberAxis();
        yAxis.setLabel("Y");

        scatterChart = new ScatterChart(xAxis, yAxis);
        scatterChart.setLegendVisible(false);
        scatterChart.animatedProperty().set(false);
        borderPane.setCenter(scatterChart);

        // Creación de la escena
        Tab KNNTab = new Tab("KNN", borderPane);

        TabPane tabPane = new TabPane();
        tabPane.getTabs().add(KNNTab);
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        Scene scene = new Scene(tabPane, 700, 500);
        stage.setScene(scene);
        stage.show();
    }

    private void setAxis(int xIndex, int yIndex) {

        if(xIndex < 0 || yIndex < 0)
            return;

        scatterChart.setTitle(axisNames.get(yIndex).toString() + " vs. " + axisNames.get(xIndex).toString());
        xAxis.setLabel(axisNames.get(xIndex).toString());
        yAxis.setLabel(axisNames.get(yIndex).toString());

        for(int i = 0; i < series.size(); i++){
            for(int j = 0; j < dataSeries.get(i).size(); j++)
                series.get(i).getData().set(j, new XYChart.Data(dataSeries.get(i).get(j).get(xIndex), dataSeries.get(i).get(j).get(yIndex)));
        }
    }

    public void setController(KNNController controller) {
        this.controller = controller;
    }

    public void setModel(KNNModel model) {
        this.model = model;
    }

    public void newDataIsLoaded(){

        labels = new ArrayList<>();
        series = new LinkedList<>();
        dataSeries = new LinkedList<>();

        for(int i = 0; i < model.getData().getSize(); i++) {
            if(!labels.contains(model.getData().getRowAt(i).getLabel())) {
                labels.add(model.getData().getRowAt(i).getLabel());
                series.add(new XYChart.Series());
                dataSeries.add(new LinkedList<>());
            }
        }

        for(int i = 0; i < model.getData().getSize(); i++){
            String l = model.getData().getRowAt(i).getLabel();
            for(int j = 0; j < series.size(); j++){
                if(l.equals(labels.get(j))) {
                    series.get(j).getData().add(new XYChart.Data(model.getData().getRowAt(i).getData().get(0), model.getData().getRowAt(i).getData().get(1)));
                    dataSeries.get(j).add(model.getData().getRowAt(i).getData());
                }
            }
        }
        for(int i = 0; i < series.size(); i++)
            scatterChart.getData().addAll(series.get(i));

        axisNames = FXCollections.observableArrayList(model.getData().getHeaders());
        axisNames.remove(axisNames.size() - 1);
        scatterChart.setTitle(axisNames.get(1).toString() + " vs. " + axisNames.get(0).toString());
        xAxis.setLabel(axisNames.get(0).toString());
        yAxis.setLabel(axisNames.get(1).toString());
        comboDistances.setDisable(false);
        xAxisCombo.setItems(axisNames);
        xAxisCombo.getSelectionModel().selectFirst();
        yAxisCombo.setItems(axisNames);
        yAxisCombo.getSelectionModel().select(1);
    }

    public void newPointIsEstimated(String type, List<Double> point, boolean esNuevo){
        labelText.setText(type);
        if(esNuevo)
            addNewPoint(point);
    }

    public void addNewPoint(List<Double> point){
        /*for(int i = 0; i < series.size(); i++){
            if(type.equals(labels.get(i))){
                series.get(i).getData().add(new XYChart.Data(point.get(xAxisCombo.getSelectionModel().getSelectedIndex()), point.get(yAxisCombo.getSelectionModel().getSelectedIndex())));
                dataSeries.get(i).add(point);
            }
        }*/
        XYChart.Series series = new XYChart.Series();
        series.getData().add(new XYChart.Data(point.get(xAxisCombo.getSelectionModel().getSelectedIndex()), point.get(yAxisCombo.getSelectionModel().getSelectedIndex())));
        dataSeries.add(new LinkedList<>());
        dataSeries.get(dataSeries.size() - 1).add(point);
        scatterChart.getData().add(series);
    }

    public void reestimatePoint() {
        controller.estimateParams(enterPoint.getText(), false);
    }
}
