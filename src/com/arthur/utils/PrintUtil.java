package com.arthur.utils;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * Created by artcslee on 8/17/16.
 */
public class PrintUtil {
    public static String printSubList(List list, int start, int end) {
        if (start < 0 || start > list.size()-1 || end < 0 || end > list.size()-1) {
            return "[]";
        }
        String sublistString = "[";
        for (int x=start; x<=end; x++) {
            sublistString += list.get(x);
            if (x < end) {
                sublistString += ",";
            }
        }
        return sublistString + "]";
    }

    public static String printList(List list) {
        String listString = "[";
        Iterator<Object> iterator = list.iterator();
        while (iterator.hasNext()) {
            listString += iterator.next();
            if (iterator.hasNext()) {
                listString += ", ";
            }
        }
        return listString + "]";
    }
}
