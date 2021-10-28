public class Pair {
    Point p1;
    Point p2;

    public Pair(Point p1, Point p2) {
        // Always have the lowest x value to be p1
        if (p1.x < p2.x) {
            this.p1 = p1;
            this.p2 = p2;
        } else {
            this.p1 = p2;
            this.p2 = p1;
        }
    }

    // Calculating the line equation between to points
    public String lineEquation() {
        // Equation for a linear line: ax + by = c
        double a = p2.y - p1.y;
        double b = p1.x - p2.x;
        double c = a * (p1.x) + b * (p1.y);

        // Checks for vertical (x) and horizontal (y) lines.
        // Returns a string with either x or y and the point value attached
        while (p1.x == p2.x) return "x=" + p1.x; // O(1)
        while (p1.y == p2.y) return "y=" + p1.y; // O(1)

        return reduce(a, b, c); // O(log n)
    } // O(log n)

    // Reduces the line equation to the simplest form
    public String reduce(double a, double b, double c) {
        // To simplify the line equation modulus 5, 4, 3 and 2  is used.
        // This makes sure the equation returned is the simplest form
        while (a % 5 == 0 && b % 5 == 0 && c % 5 == 0) {
            a /= 5;
            b /= 5;
            c /= 5;
        } // O(log n)
        while (a % 4 == 0 && b % 4 == 0 && c % 4 == 0) {
            a /= 4;
            b /= 4;
            c /= 4;
        } // O(log n)
        while (a % 3 == 0 && b % 3 == 0 && c % 3 == 0) {
            a /= 3;
            b /= 3;
            c /= 3;
        } // O(log n)
        while (a % 2 == 0 && b % 2 == 0 && c % 2 == 0) {
            a /= 2;
            b /= 2;
            c /= 2;
        } // O(log n)

        // Checks if b is positive or negative
        if (b < 0) {
            // If b is negative return the simplified line equation without the "+" sign
            return a + "x" + b + "y=" + c;
        } // O(log n)
        else {
            // If b is positive or 0 return the simplified line equation with the "+" sign
            return a + "x+" + b + "y=" + c;
        } // O(log n)
    } // O(log n)

    public String toString() {
        return "{" + p1 + "," + p2 + "}";
    }
}
