package app;

public class Point
{
    double x;
    double y;
    public Point(double x, double y)
    {
        this.x = x;
        this.y = y;
    }
    public String toString()
    {
        return "{" + (int) x + "," + (int) y + "}";
    }
}
