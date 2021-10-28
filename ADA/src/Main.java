// Comments should be read from top to bottom.
// Comments associated to implementation are located directly ABOVE the implementation.
// Comments associated with time complexity of separate parts are located ON THE LINE introduced.
// Comments associated with calculating the time complexity are located AFTER the implementation.
// The Big O notation: The time complexity for this algorithm is O(n² log n) - See calculations on line 130 - 137.
// The method findColinearPoints() holds the algorithm. It has four different processes:
// 1. Sort: O(n log n)
// 2. equationMap: O(n² log n)
// 3. resultMap: 0(n*m)
// 4. finalResultMap: O(n)
// After eliminating the smallest joints the final time complexity of the algorithm is O(n² log n).

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Main extends SortComparator {

    public void findColinearPoints(ArrayList<Point> initDataArray) {
        // Holds the groups of colinear points
        HashMap<String, HashSet<Point>> resultMap = new HashMap<>();
        // Holds the groups of minimum 4 colinear points
        HashMap<String, ArrayList<Point>> finalResultMap = new HashMap<>();
        // Sorting the initial dataset of x, y points.
        // List.sort to reduce the extra method call of Collections.sort
        // List.sort uses a modified version of Merge Sort called TimSort
        initDataArray.sort(new SortComparator()); // O(n log n)

        // -------------------------------------------------------------------------
        // CAPTION: Filling equationMap with the line equations(key) and pairs(value)
        HashMap<String, ArrayList<Pair>> equationMap = new HashMap();

        // Iterating through initDataArray containing the sorted dataset of initial points
        for (int i = 0; i < initDataArray.size() - 1; i++) { // O(n)
            // In each iteration of first for loop iterate through initDataArray
            for (int j = 1; j < initDataArray.size(); j++) { // O(n²)
                // Instantiate a new Pair object taking index i and j in initDataArray
                Pair pair = new Pair(initDataArray.get(i), initDataArray.get(j));

                // Initializing a string containing the line equations
                // Because lineEquation() returns the reduce(a,b,c) method with a time complexity of O(log n),
                // and the current time complexity is O(n²), the time complexity is now O(n² log n)
                String equation = pair.lineEquation(); // O(log n)

                // Checks if equationMap, containing the line equations and pairs, already has a key with the equation.
                if (equationMap.containsKey(equation)) { //O(1)
                    // If equation exist, the new pair will be added to the existing key
                    // By doing this the pairs having the same equation will be grouped
                    equationMap.get(equation).add(pair); // O(1)

                    // If equationMap does not contain a key with a similar equation
                } else { // O(1)
                    // Instantiates a temporary array
                    ArrayList<Pair> tempArray = new ArrayList<>();
                    // Add the pair to the temporary array
                    tempArray.add(pair); // O(1)
                    // Puts the equation(key) and temporary array (value), containing all the pairs, into equationMap.
                    // Now each pair has its own array as value, meaning that when adding two pairs with similar equations (key),
                    // The pairs will be grouped up with the same key
                    equationMap.put(equation, tempArray); // O(1)
                }
            }
        }
        // Time complexity:
        // O(n) * O(n²) * O(log n) * O(1) * O(1) * O(1) * O(1)
        // Removing the constants and smallest joints
        // O(n² log n)


        // -------------------------------------------------------------------------
        // CAPTION: Filling resultMap with the line equations(key) and points (value) that share the same equation
        // Iterating through equationMap
        for (Map.Entry<String, ArrayList<Pair>> entry : equationMap.entrySet()) { // O(n)
            // We only want to add groups of 4 pairs with colinear points to the resultMap
            // Checking if each entry contains more than 3 pairs
            if (entry.getValue().size() > 3) { // O(1)
                // Then checking if resultMap already has a similar equation as key
                if (resultMap.containsKey(entry.getKey())) { // O(1)
                    // Then iterate through the entry values
                    for (int i = 0; i < entry.getValue().size(); i++) { // O(n*m)
                        // For each entry that contains a similar equation,
                        // get the existing key and add the pair to the group of values.
                        resultMap.get(entry.getKey()).add(entry.getValue().get(i).p1); // O(1)
                        resultMap.get(entry.getKey()).add(entry.getValue().get(i).p2); // O(1)
                    }
                    // If resultMap does not have a similar equation as key
                } else { // O(1)
                    // Instantiate a new HashSet - HashSet is used because it cannot contain duplicates
                    HashSet<Point> hashSet = new HashSet<>();

                    // Then iterate through the entry values
                    for (int i = 0; i < entry.getValue().size(); i++) { // O(n*m)
                        // Add the points to the HashSet
                        hashSet.add(entry.getValue().get(i).p1); // O(1)
                        hashSet.add(entry.getValue().get(i).p2); // O(1)
                    }
                    // Put the equation (key) and the HashSet(value) into resultMap
                    resultMap.put(entry.getKey(), hashSet); // O(1)
                }
            }
        }
        // Time complexity:
        // O(n) * O(n*m) * O(1) * O(1) * O(1) * O(1) * O(1)
        // Removing the constants and smallest joints
        // O(n*m)

        // -------------------------------------------------------------------------
        // CAPTION: Filling finalResultMap with the line equations(key) and points(value) that are colinear and in groups of more than 3
        // Iterating through the resultMap containing the equation as key and HashSet of points as value
        for (Map.Entry<String, HashSet<Point>> entry : resultMap.entrySet()) { // O(n)
            // Checks if the groups of colinear points have more than 3 entries
            if (entry.getValue().size() > 3) { // O(1)
                // If the groups of colinear points have more than 3 entries,
                // instantiate a new temporary array taking the entry value
                ArrayList<Point> tempArray = new ArrayList<>(entry.getValue());
                // Puts the equation (key) and the temporary array into finalResultMap
                finalResultMap.put(entry.getKey(), tempArray); // O(1)
            }
        }
        // Time complexity:
        // O(n) * O(1)
        // Removing constants
        // O(n)

        // -------------------------------------------------------------------------
        // Prints the finalResultMap values
        System.out.println(finalResultMap.values() + "\n");
    }
    // Time complexity of algorithm:
    // O(n log n) + O(n) * O(n²) * O(log n) * O(1) * O(1) * O(1) * O(1) + O(n) * O(n*m) * O(1) * O(1) * O(1) * O(1) * O(1) + O(n) * O(1)
    // Removing constants:
    // O(n log n) + O(n) * O(n²) * O(log n) + O(n) * O(n*m) + O(n)
    // Reduction:
    // O(n log n + n * n² * log n + nm + n)
    // Simplify and removing the smallest joints
    // O(n² log n)

    public void test1() {
        // Instantiating a new ArrayList of points to be given as an argument for the algorithm findColinearPoints()
        ArrayList<Point> testPointList1 = new ArrayList<>();
        testPointList1.add(new Point(7, 1));
        testPointList1.add(new Point(12, 3));
        testPointList1.add(new Point(14, 6));
        testPointList1.add(new Point(9, 4));
        testPointList1.add(new Point(1, 6));
        testPointList1.add(new Point(1, 1));
        testPointList1.add(new Point(2, 2));
        testPointList1.add(new Point(3, 3));
        testPointList1.add(new Point(4, 4));
        //   testPointList1.add(new Point(5, 5));
        //   testPointList1.add(new Point(6, 6));
        testPointList1.add(new Point(1, 2));
        testPointList1.add(new Point(2, 4));
        testPointList1.add(new Point(3, 6));
        testPointList1.add(new Point(4, 7));
        System.out.println("TEST 1 - Groups of 4 colinear points");
        // After adding to initial ArrayList, run the algorithm
        findColinearPoints(testPointList1);
    }

    public void test2() {
        ArrayList<Point> testPointList2 = new ArrayList<>();
        testPointList2.add(new Point(7, 1));
        testPointList2.add(new Point(12, 5));
        testPointList2.add(new Point(14, 6));
        testPointList2.add(new Point(9, 4));
        testPointList2.add(new Point(1, 6));
        // testPointList2.add(new Point(1,1));
        testPointList2.add(new Point(2, 2));
        testPointList2.add(new Point(3, 3));
        testPointList2.add(new Point(4, 4));
        testPointList2.add(new Point(1, 2));
        testPointList2.add(new Point(2, 4));
        testPointList2.add(new Point(3, 6));
        testPointList2.add(new Point(4, 7));
        System.out.println("TEST 2 - No groups of 4 colinear points");
        findColinearPoints(testPointList2);
    }

    public void test3() {
        ArrayList<Point> testPointList3 = new ArrayList<>();
        testPointList3.add(new Point(7, 1));
        testPointList3.add(new Point(12, 3));
        testPointList3.add(new Point(14, 6));
        testPointList3.add(new Point(9, 4));
        testPointList3.add(new Point(1, 6));
        testPointList3.add(new Point(2, 1));
        testPointList3.add(new Point(1, 4));
        testPointList3.add(new Point(1, 5));
        testPointList3.add(new Point(4, 4));
        testPointList3.add(new Point(1, 2));
        testPointList3.add(new Point(2, 5));
        testPointList3.add(new Point(3, 6));
        testPointList3.add(new Point(4, 8));
        System.out.println("TEST 3 - Colinear points on a vertical line");
        findColinearPoints(testPointList3);
    }

    public void test4() {
        ArrayList<Point> testPointList4 = new ArrayList<>();
        testPointList4.add(new Point(2, 2));
        testPointList4.add(new Point(3, 3));
        testPointList4.add(new Point(4, 4));
        testPointList4.add(new Point(7, 1));
        testPointList4.add(new Point(14, 6));
        testPointList4.add(new Point(9, 4));
        testPointList4.add(new Point(1, 1));
        testPointList4.add(new Point(1, 4));
        testPointList4.add(new Point(1, 5));
        testPointList4.add(new Point(1, 2));
        testPointList4.add(new Point(2, 4));
        System.out.println("TEST 4 - Multiple groups of colinear points");
        findColinearPoints(testPointList4);
    }

    public static void main(String[] args) {
        // Instantiating Main class
        Main main = new Main();
        // Runs the 4 test cases
        main.test1();
        main.test2();
        main.test3();
        main.test4();

    }
}