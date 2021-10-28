public class Point {
    // Protected to be reachable from outside the class.
    // Eliminates the need for getters
    protected int x;
    protected int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "{" + x + "," + y + "}";
    }
}
