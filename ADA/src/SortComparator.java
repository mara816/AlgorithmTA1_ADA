import java.util.Comparator;

public class SortComparator implements Comparator<Point> {

    // Comparing x and y values of point a and point b
    // compare(a,b) will return as following:
    // If a > b = 1
    // If a == b = 0
    // If a < b = -1
    @Override
    public int compare(Point a, Point b) {
        // Comparing x values of point a and point b
        int result = Double.compare(a.x, b.x);
        // If x values are the same, compare y
        if (result == 0) {
            result = Double.compare(a.y, b.y);
        }
        return result;
    }
}
