package Algorithms;

import CSVread.Row;
import CSVread.TableWithLabels;
import DistanceAlgorithms.Distance;
import DistanceAlgorithms.DistanceClient;
import Exceptions.EmptyTableException;

import java.util.List;

public class KNN implements Algorithm<TableWithLabels, String, List<Double>>, DistanceClient {

    private TableWithLabels data;
    private Distance distance;

    KNN(Distance distance){
        super();
        this.distance = distance;
    }

    public void train(TableWithLabels data) throws EmptyTableException {
        if(data.getSize() == 0)
            throw new EmptyTableException();

        this.data = data;
    }

    public String estimate(List<Double> sample){
        double min = Double.MAX_VALUE;
        String type = null;
        for(int i = 0; i < data.getSize(); i++){
            double dist = distance.calculateDistance(sample, data.getRowAt(i).getData());
            if(dist < min){
                min = dist;
                type = data.getRowAt(i).getLabel();
            }
        }
        return type;
    }

    public void setDistance(Distance distance){
        this.distance = distance;
    }
}
