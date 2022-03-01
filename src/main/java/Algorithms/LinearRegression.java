package Algorithms;

import CSVread.Table;
import Statistics.Statistics;
import java.util.List;

public class LinearRegression{

    private double alpha, beta;

    LinearRegression(){
        super();
    }

    public void train(Table data){
        alpha = alphaCalc(data);
        beta = betaCalc(data, alpha);
    }

    public Double estimate(Double sample){
        return alpha * sample + beta;
    }

    private Double alphaCalc(Table t){
        List<Double> x = t.getColumnAt(0);
        List<Double> y = t.getColumnAt(1);
        Double xmean = Statistics.mediaAritmetica(x);
        Double ymean = Statistics.mediaAritmetica(y);
        Double num = 0.0;
        Double denom = 0.0;

        for(int i = 0; i < x.size(); i++){
            num += (x.get(i) - xmean) * (y.get(i) - ymean);
            denom += Math.pow(x.get(i) - xmean, 2);
        }
        return num / denom;
    }

    private Double betaCalc(Table t, Double alpha){
        return Statistics.mediaAritmetica(t.getColumnAt(1)) - alpha * Statistics.mediaAritmetica(t.getColumnAt(0));
    }

    public Double getAlpha(){
       return alpha;
    }
    public Double getBeta(){
        return beta;
    }

}
