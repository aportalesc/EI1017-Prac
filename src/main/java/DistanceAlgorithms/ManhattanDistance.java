package DistanceAlgorithms;

import java.util.List;

public class ManhattanDistance implements Distance{
    @Override
    public double calculateDistance(List<Double> p, List<Double> q) {
        double dist = 0;
        for(int i = 0; i < p.size(); i++)
            dist += Math.abs(p.get(i) - q.get(i));
        return dist;
    }
}
