package utils;

import java.util.ArrayList;

public class Sorter {

    public static ArrayList<Double> sortS(ArrayList<Double> arrList) {
        ArrayList<Double> newArr = new ArrayList<Double>();

        for (int i = 0; i < arrList.size(); i++) {
            // System.out.println(min(arrList));
            if (arrList.get(i) == min(arrList)) {
                newArr.add(arrList.remove(i));
                i--;
            } else {
                arrList.add(arrList.remove(i));
                i--;
            }
        }

        return newArr;
    }

    private static double min(ArrayList<Double> myList) {
        double minimum = myList.get(0);
        for (int i = 1; i < myList.size(); i++) {
            if (minimum > myList.get(i))
                minimum = myList.get(i);
        }

        return minimum;
    }
}
