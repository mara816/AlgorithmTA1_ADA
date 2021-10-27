package app;

public class Pair {
    Point p1;
    Point p2;

    public Pair(Point p1, Point p2) {
        if (p1.x < p2.x) {
            this.p1 = p1;
            this.p2 = p2;
        } else {
            this.p1 = p2;
            this.p2 = p1;
        }
    }

    public double findSlope() {
        return (p2.y - p1.y) / (p2.x - p1.x);
    }

    public String lineEquation() {

        double a = p2.y - p1.y;
        double b = p1.x - p2.x;
        double c = a * (p1.x) + b * (p1.y);

        // ax + by = c
        if (p1.x == p2.x) {
            return "x = " + p1.x;
        } else if (p1.y == p2.y) {
            return "y = " + p1.y;
        }
        return reduce(a, b, c);
    }

    public String reduce(double a, double b, double c) {
        // a + "x - " + b + "y = " + c
        // Using while loop with time complextity plexity of O(n log n).
        // Modulus is used to make sure we
        while (a % 5 == 0 && b % 5 == 0 && c % 5 == 0) {
            a /= 5;
            b /= 5;
            c /= 5;
        }
        while (a % 4 == 0 && b % 4 == 0 && c % 4 == 0) {
            a /= 4;
            b /= 4;
            c /= 4;
        }
        while (a % 3 == 0 && b % 3 == 0 && c % 3 == 0) {
            a /= 3;
            b /= 3;
            c /= 3;
        }
        while (a % 2 == 0 && b % 2 == 0 && c % 2 == 0) {
            a /= 2;
            b /= 2;
            c /= 2;
        }
        if (b < 0) {
            return a + "x " + b + "y = " + c;
        } else {
            return a + "x + " + b + "y = " + c;
        }
    }

    public String toString() {
        return "{" + p1 + "," + p2 + "}";
    }
}
