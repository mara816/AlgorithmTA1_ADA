package app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Main {
    static ArrayList<Point> pointList = new ArrayList<>();
    static HashMap<String, HashSet<Point>> fpoint = new HashMap<>();

    public static HashMap<String, HashSet<Point>> printResult(){
        System.out.println(fpoint);
        return fpoint;
    }
    public HashMap<String, HashSet<Point>> findCoolPoints(ArrayList<Point> pArr) {
        HashMap<Double, ArrayList<Pair>> pHash = new HashMap<>();

        // Filling pHash with slope(key) and pair(value)
        for (int i = 0; i < pArr.size() - 1; i++) {
            for (int j = 1; j < pArr.size(); j++) {
                Pair pair = new Pair(pArr.get(i), pArr.get(j));
                double slope = pair.findSlope();

                if (pHash.containsKey(slope)){
                    pHash.get(slope).add(pair);
                } else {
                    ArrayList<Pair> tempArr = new ArrayList<>();
                    tempArr.add(pair);
                    pHash.put(slope, tempArr);
                }
            }
        }

        HashMap<String, HashSet<Point>> pHash2 = new HashMap<>();
        for (Map.Entry<Double, ArrayList<Pair>> entry : pHash.entrySet()){
            double key = entry.getKey();
            ArrayList<Pair> value = entry.getValue();
            for (int i = 0; i < value.size(); i++) {
                String equation = value.get(i).lineEquation();
                if (pHash2.containsKey(equation)){
                    pHash2.get(equation).add(value.get(i).p1);
                    pHash2.get(equation).add(value.get(i).p2);
                } else {
                    HashSet<Point> tempPoints = new HashSet<>();
                    tempPoints.add(value.get(i).p1);
                    tempPoints.add(value.get(i).p2);
                    pHash2.put(equation,tempPoints);
                }
            }
        }

        for (Map.Entry<String, HashSet<Point>> entry2 : pHash2.entrySet()){
            if (entry2.getValue().size() > 3) {
                System.out.println("hello");
                fpoint.put(entry2.getKey(), entry2.getValue());
            }

        }
       // System.out.println(fpoint);
        return fpoint;
    }

    public static void test1() {
        pointList.add(new Point(7, 1));
        pointList.add(new Point(12, 3));
        pointList.add(new Point(14, 6));
        pointList.add(new Point(9, 4));
        pointList.add(new Point(1, 6));
        pointList.add(new Point(1, 1));
        pointList.add(new Point(2, 2));
        pointList.add(new Point(3, 3));
        pointList.add(new Point(4, 4));
     //   pointList.add(new Point(5, 5));
     //   pointList.add(new Point(6, 6));
        pointList.add(new Point(1, 2));
        pointList.add(new Point(2, 4));
        pointList.add(new Point(3, 6));
        pointList.add(new Point(4, 7));
    }

    public static void test2() {
        pointList.add(new Point(7, 1));
        pointList.add(new Point(12, 5));
        pointList.add(new Point(14, 6));
        pointList.add(new Point(9, 4));
        pointList.add(new Point(1, 6));
        // pointList.add(new Point(1,1));
        pointList.add(new Point(2, 2));
        pointList.add(new Point(3, 3));
        pointList.add(new Point(4, 4));
        pointList.add(new Point(1, 2));
        pointList.add(new Point(2, 4));
        pointList.add(new Point(3, 6));
        pointList.add(new Point(4, 7));
    }

    public static void test3() {
        pointList.add(new Point(7, 1));
        pointList.add(new Point(12, 3));
        pointList.add(new Point(14, 6));
        pointList.add(new Point(9, 4));
        pointList.add(new Point(1, 6));
        pointList.add(new Point(2, 1));
        pointList.add(new Point(1, 4));
        pointList.add(new Point(1, 5));
        pointList.add(new Point(4, 4));
        pointList.add(new Point(1, 2));
        pointList.add(new Point(2, 5));
        pointList.add(new Point(3, 6));
        pointList.add(new Point(4, 8));
    }

    public static void test4() {
        pointList.add(new Point(2, 2));
        pointList.add(new Point(3, 3));
        pointList.add(new Point(4, 4));
        pointList.add(new Point(7, 1));
        pointList.add(new Point(14, 6));
        pointList.add(new Point(9, 4));
        pointList.add(new Point(1, 1));
        pointList.add(new Point(1, 4));
        pointList.add(new Point(1, 5));
        pointList.add(new Point(1, 2));
        pointList.add(new Point(2, 4));
    }

    public static void main(String[] args) {
        Main main = new Main();
        test3();
        main.findCoolPoints(pointList);
        printResult();
    }
}