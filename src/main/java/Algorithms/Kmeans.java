package Algorithms;

import CSVread.Row;
import CSVread.Table;
import Statistics.Statistics;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Kmeans implements Algorithm<Table, String, Row>{

    private int numberClusters;
    private int iterations;
    private long seed;
    private List<Row> centr;

    public Kmeans(int numberClusters, int iterations, long seed){
        super();
        this.numberClusters = numberClusters;
        this.iterations = iterations;
        this.seed = seed;
        this.centr = new ArrayList<>();
    }

    public void train(Table data){
        List<List<Row>> clusters = new ArrayList<>();
        for(int i = 0; i < numberClusters; i++) {       //Inicializa los centroides de cada cluster
            centr.add(data.getRowAt(i));
            clusters.add(new LinkedList<>());
        }

        for(int n = 0; n < iterations; n++){
            for(int i = 0; i < data.getSize(); i++){    //Asigna cada elemento al cluster más cercano
                Row elem = data.getRowAt(i);
                int ncluster = closestCluster(elem);
                clusters.get(ncluster).add(elem);
            }

            for(int i = 0; i < clusters.size(); i++){   //Calcula el centroide de cada grupo
                List<Row> cl = clusters.get(i);
                centr.set(i, centrCalc(cl));
                clusters.get(i).clear();                // Vacía el grupo para volver a calcularlo
            }

        }
    }

    public String estimate(Row r){
        return "cluster-" + (closestCluster(r) + 1);
    }

    private double euclideanDist(Row r1, Row r2) {
        double dist = 0;
        for(int i = 0; i < r1.size(); i++)
            dist += Math.pow(r1.getData().get(i) - r2.getData().get(i), 2);
        dist = Math.sqrt(dist);
        return dist;
    }

    private int closestCluster(Row elem){
        double min = Double.MAX_VALUE;
        double dist = 0.0;
        int ncluster = 0;
        for(int i = 0; i < centr.size(); i++){
            dist = euclideanDist(centr.get(i), elem);
            if(dist < min){
                min = dist;
                ncluster = i;
            }
        }
        return ncluster;
    }

    private Row centrCalc(List<Row> cluster){
        Row ret = new Row();
        for(int i = 0; i < cluster.get(0).size(); i++){
            double mean = Statistics.mediaAritmetica(getColumnAt(i, cluster));
            ret.add(mean);
            }
        return ret;
    }

    private List<Double> getColumnAt(int columnNumber, List<Row> cluster){
        List<Double> ret = new ArrayList<>();
        for(Row r : cluster)
            ret.add(r.getData().get(columnNumber));
        return ret;
    }


    public List<Row> getCentr() {
        return centr;
    }
}
