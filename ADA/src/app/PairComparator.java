package app;

import java.util.Comparator;
public class PairComparator implements Comparator
{
    public int compare(Object a, Object b)
    {
        double slope1 = ((Pair)a).findSlope();
        double slope2 = ((Pair)b).findSlope();
        return Double.compare(slope1, slope2);
    }
}
