package DistanceAlgorithms;

import java.util.List;

public class EuclideanDistance implements Distance{
    @Override
    public double calculateDistance(List<Double> p, List<Double> q) {
        double dist = 0;
        for(int i = 0; i < p.size(); i++)
            dist += Math.pow(p.get(i) - q.get(i), 2);
        dist = Math.sqrt(dist);
        return dist;
    }
}
