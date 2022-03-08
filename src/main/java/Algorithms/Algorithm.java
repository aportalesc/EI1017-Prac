package Algorithms;

import CSVread.Table;
import Exceptions.EmptyTableException;
import Exceptions.ZeroDivisionException;

public interface Algorithm <T extends Table, U, V>{

    public void train(T data) throws ZeroDivisionException, EmptyTableException;

    public U estimate(V sample);
}