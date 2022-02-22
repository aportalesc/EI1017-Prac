package Statistics;

public class Statistics {

    public double mediaAritmetica(double[] c){
        if(c.length == 0)
            return 0;
        double suma = 0;
        for(Double elemento : c)
            suma += elemento;
        return suma/c.length;
    }

    public double varianza(double[] c){
        if(c.length == 0)
            return 0;
        double sumatorio = 0;
        double media = mediaAritmetica(c);
        for(Double elemento : c)
            sumatorio += Math.pow(elemento - media, 2);

        return sumatorio/c.length;
    }

    public double desviacionTipica(double[] c){
        if(c.length == 0)
            return 0;
        return Math.sqrt(varianza(c));
    }
}
