package Model;

import Algorithms.KNN;
import CSVread.CSV;
import CSVread.TableWithLabels;
import DistanceAlgorithms.Distance;
import DistanceAlgorithms.DistanceFactory;
import DistanceAlgorithms.DistanceType;
import DistanceAlgorithms.Factory;
import Exceptions.EmptyTableException;
import View.KNNView;

import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;


public class KNNModel {

    private KNNView view;

    private Factory factory;

    private KNN KNNAlgorithm;


    private TableWithLabels data;

    public KNNModel(KNNView view){
        super();
        this.view = view;
        this.factory = new DistanceFactory();
        this.KNNAlgorithm = new KNN(factory.getDistance(DistanceType.EUCLIDEAN));
    }

    public void setView(KNNView view) {
        this.view = view;
    }


    public void loadData(String fileName) {
        try {
            data = CSV.readTableWithLabels(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            KNNAlgorithm.train(data);
        } catch (EmptyTableException e) {
            e.printStackTrace();
        }
        view.newDataIsLoaded();
    }

    public TableWithLabels getData(){
        return data;
    }

    public void estimateParams(String estimatePoint, boolean esNuevo){

        String[] newPoint = estimatePoint.split(",");
        try{
            Double.parseDouble(newPoint[0]);
        } catch(NumberFormatException e){
            return;
        }
        List<Double> point = new LinkedList<>();
        for(int i = 0; i < newPoint.length; i++)
            point.add(Double.parseDouble(newPoint[i]));

        String type = KNNAlgorithm.estimate(point);
        view.newPointIsEstimated(type, point, esNuevo);
    }


    public void setDistanceType(Object selectedItem) {
        Distance dist;
        if(selectedItem.toString().equals("EUCLIDEAN"))
            dist = factory.getDistance(DistanceType.EUCLIDEAN);
        else
            dist = factory.getDistance(DistanceType.MANHATTAN);
        KNNAlgorithm.setDistance(dist);

        view.reestimatePoint();
    }

}
