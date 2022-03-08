package Exceptions;

public class EmptyTableException extends Exception{
    public EmptyTableException() {
        super("Error: la tabla no contiene datos");
    }
}
