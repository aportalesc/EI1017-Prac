package CSVread;

import java.util.List;

public interface TableInterface {
    public Row getRowAt(int rowNumber);
    public List<Double> getColumnAt(int columnNumber);
    public void add(String str);
    public int getSize();
    public String toString();
}
