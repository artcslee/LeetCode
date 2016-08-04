package com.arthur.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Arthur on 8/3/2016.
 */
public class AdapterUtil {
    public static int[] listToArray(List<Integer> list) {
        int[] array = new int[list.size()];
        Iterator<Integer> iterator = list.iterator();
        int index = 0;
        while(iterator.hasNext()) {
            array[index] = iterator.next();
            index++;
        }
        return array;
    }

    public static List<Integer> stringArrayToIntegerList(String[] stringArray) {
        ArrayList<Integer> integerList = new ArrayList<>();
        for (int x=0; x<stringArray.length; x++) {
            integerList.add(Integer.valueOf(stringArray[x]));
        }
        return integerList;
    }
}
