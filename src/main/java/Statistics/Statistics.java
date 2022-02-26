package Statistics;

import java.util.Collection;

public class Statistics {

    public static double mediaAritmetica(Collection<Double> c){
        if(c.size() == 0)
            return 0;
        double suma = 0;
        for(Double elemento : c)
            suma += elemento;
        return suma/c.size();
    }

    public static double varianza(Collection<Double> c){
        if(c.size() == 0)
            return 0;
        double sumatorio = 0;
        double media = mediaAritmetica(c);
        for(Double elemento : c)
            sumatorio += Math.pow(elemento - media, 2);

        return sumatorio/c.size();
    }

    public static double desviacionTipica(Collection<Double> c){
        if(c.size() == 0)
            return 0;
        return Math.sqrt(varianza(c));
    }
}
