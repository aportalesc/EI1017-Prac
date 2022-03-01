package Algorithms;

import CSVread.TableWithLabels;

import java.util.List;

public class KNN {

    private TableWithLabels data;

    KNN(){
        super();
    }

    public void train(TableWithLabels data){
        this.data = data;
    }

    public String estimate(List<Double> sample){
        double min = Double.MAX_VALUE;
        double calc = 0;
        String type = null;
        for(int i = 0; i < data.getSize(); i++){
            for(int j = 0; j < data.getRowAt(i).size(); j++) {
                double xi = data.getRowAt(i).getData().get(j);
                calc += Math.pow(sample.get(j) - xi, 2);
            }
            calc = Math.sqrt(calc);

            if(calc < min){
                min = calc;
                type = data.getRowAt(i).getLabel();
            }
            calc = 0;
        }
        return type;
    }
}
