package DistanceAlgorithms;

public class DistanceFactory implements Factory{

    public Distance getDistance(DistanceType distanceType){

        Distance dist = new EuclideanDistance();
        switch(distanceType){
            case MANHATTAN:
                dist = new ManhattanDistance();
                break;
        }
        return dist;
    }
}
