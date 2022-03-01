package utils;

import java.util.ArrayList;

public class Sorter {

    public static ArrayList<Integer> sortS(ArrayList<Integer> arrList) {
        ArrayList<Integer> newArr = new ArrayList<Integer>(); // New ArrayList we will be returning

        for (int i = 0; i < arrList.size(); i++) {
            /* If current value in arraylist is equal to minimum value, then remove it from the arraylist and add it to the 
            new arraylist. Recheck that spot for the next iteration. */
            if (arrList.get(i) == min(arrList)) {
                newArr.add(arrList.remove(i)); // Remove from arraylist and add to new arraylist.
                i--; // Recheck value.
            } else {
                arrList.add(arrList.remove(i)); // Otherwise add the current value to the end of the arraylist.
                i--; // Recheck value
            }
        }

        return newArr;
    }

    private static int min(ArrayList<Integer> myList) {
        int minimum = myList.get(0); // Start with the first value of the arrayList as minimum
        for (int i = 1; i < myList.size(); i++) {
            if (minimum > myList.get(i)) // if the minimum value is greater than the currenct value, update minimum value to current value
                minimum = myList.get(i);
        }

        return minimum;
    }
}
