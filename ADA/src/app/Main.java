package app;

import java.util.*;

public class Main extends PairComparator {
    static HashMap<String, HashSet<Point>> fpoint = new HashMap<>();

   /* public static HashMap<String, HashSet<Point>> printResult(){
        return fpoint;
    }*/
    public void findCoolPoints(ArrayList<Point> pArr)  {
        pArr.sort(new PairComparator());
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
            ArrayList<Pair> value = entry.getValue();
            for (Pair pair : value) {
                String equation = pair.lineEquation();
                if (pHash2.containsKey(equation)) {
                    pHash2.get(equation).add(pair.p1);
                    pHash2.get(equation).add(pair.p2);
                } else {
                    HashSet<Point> tempPoints = new HashSet<>();
                    tempPoints.add(pair.p1);
                    tempPoints.add(pair.p2);
                    pHash2.put(equation, tempPoints);
                }
            }
        }
        for (Map.Entry<String, HashSet<Point>> entry2 : pHash2.entrySet()){
            if (entry2.getValue().size() > 3) {
                fpoint.put(entry2.getKey(), entry2.getValue());
            }
        }

        System.out.println(fpoint.values() + "\n");
        fpoint.clear();

    }

    public void test1() {
    /*    Point point1 = new Point(7, 1);
        Point point2 = new Point(12, 3);
        Point point3 = new Point(14, 6);
        Point point4 = new Point(9, 4);
        Point point5 = new Point(1, 6);
        Point point6 = new Point(1, 1);
        Point point7 = new Point(2, 2);
        Point point8 = new Point(3, 3);
        Point point9 = new Point(4, 4);
       // Point point10 = new Point(5, 5);
       // Point point11 = new Point(6, 6);
        Point point12 = new Point(1, 2);
        Point point13 = new Point(2, 4);
        Point point14 = new Point(3, 6);
        Point point15 = new Point(4, 7);
*/
        ArrayList<Point> pointList1 = new ArrayList<>();
        pointList1.add(new Point(7, 1));
        pointList1.add(new Point(12, 3));
        pointList1.add(new Point(14, 6));
        pointList1.add(new Point(9, 4));
        pointList1.add(new Point(1, 6));
        pointList1.add(new Point(1, 1));
        pointList1.add(new Point(2, 2));
        pointList1.add(new Point(3, 3));
        pointList1.add(new Point(4, 4));
     //   pointList.add(new Point(5, 5));
     //   pointList.add(new Point(6, 6));
        pointList1.add(new Point(1, 2));
        pointList1.add(new Point(2, 4));
        pointList1.add(new Point(3, 6));
        pointList1.add(new Point(4, 7));
        findCoolPoints(pointList1);
    }

    public void test2() {
        ArrayList<Point> pointList2 = new ArrayList<>();
        pointList2.add(new Point(7, 1));
        pointList2.add(new Point(12, 5));
        pointList2.add(new Point(14, 6));
        pointList2.add(new Point(9, 4));
        pointList2.add(new Point(1, 6));
        // pointList2.add(new Point(1,1));
        pointList2.add(new Point(2, 2));
        pointList2.add(new Point(3, 3));
        pointList2.add(new Point(4, 4));
        pointList2.add(new Point(1, 2));
        pointList2.add(new Point(2, 4));
        pointList2.add(new Point(3, 6));
        pointList2.add(new Point(4, 7));
        findCoolPoints(pointList2);
    }

    public void test3() {
        ArrayList<Point> pointList3 = new ArrayList<>();
        pointList3.add(new Point(7, 1));
        pointList3.add(new Point(12, 3));
        pointList3.add(new Point(14, 6));
        pointList3.add(new Point(9, 4));
        pointList3.add(new Point(1, 6));
        pointList3.add(new Point(2, 1));
        pointList3.add(new Point(1, 4));
        pointList3.add(new Point(1, 5));
        pointList3.add(new Point(4, 4));
        pointList3.add(new Point(1, 2));
        pointList3.add(new Point(2, 5));
        pointList3.add(new Point(3, 6));
        pointList3.add(new Point(4, 8));
        findCoolPoints(pointList3);
    }

    public void test4() {
        ArrayList<Point> pointList4 = new ArrayList<>();
        pointList4.add(new Point(2, 2));
        pointList4.add(new Point(3, 3));
        pointList4.add(new Point(4, 4));
        pointList4.add(new Point(7, 1));
        pointList4.add(new Point(14, 6));
        pointList4.add(new Point(9, 4));
        pointList4.add(new Point(1, 1));
        pointList4.add(new Point(1, 4));
        pointList4.add(new Point(1, 5));
        pointList4.add(new Point(1, 2));
        pointList4.add(new Point(2, 4));
        findCoolPoints(pointList4);
    }


    public static void main(String[] args) {
        Main main = new Main();
        main.test1();
        main.test2();
        main.test3();
        main.test4();
    }
}