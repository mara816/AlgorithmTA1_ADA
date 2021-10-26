package app;

public class Pair
{
    Point p1;
    Point p2;

    public Pair(Point p1, Point p2)
    {
        if (p1.x < p2.x)
        {
            this.p1 = p1;
            this.p2 = p2;
        }
        else{
            this.p1 = p2;
            this.p2 = p1;
        }
    }
    public double findSlope()
    {
        return (p2.y - p1.y) / (p2.x - p1.x);
    }

    public String lineEquation() {
        // ax + by = c
        if (p1.x == p2.x) {
            return "x = " + p1.x;
        } else if (p1.y == p2.y) {
            return "y = " + p1.y;
        }
        double a = p2.y - p1.y;
        double b = p1.x - p2.x;
        double c = a * (p1.x) + b * (p1.y);

        if (a % 2 == 0 && b % 2 == 0 && c % 2 == 0) {
            a/=2;
            b/=2;
            c/=2;
        }
        return reduce(a,b,c);

    }

    public String reduce(double a, double b, double c) {
        // a + "x - " + b + "y = " + c
        int value = 0;

        if (a % 5 == 0 && b % 5 == 0 && c % 5 == 0) {
            value = 5;
        } else if (a % 4 == 0 && b % 4 == 0 && c % 4 == 0) {
            value = 4;
        } else if (a % 3 == 0 && b % 3 == 0 && c % 3 == 0) {
            value = 3;
        } else if (a % 2 == 0 && b % 2 == 0 && c % 2 == 0) {
            value = 2;
        } else {
            if(b < 0) {
                return a + "x " + b + "y = " + c;
            } else {
                return a + "x + " + b + "y = " + c;
            }
        }

        switch (value) {
            case 5: a/=5;
                    b/=5;
                    c/=5;
            case 4: a/=4;
                    b/=4;
                    c/=4;
            case 3: a/=3;
                    b/=3;
                    c/=3;
            case 2: a/=2;
                    b/=2;
                    c/=2;
        }
        return reduce(a,b,c);
    }
    public String toString()
    {
        return "{" + p1 + "," + p2 + "}";
    }
}
