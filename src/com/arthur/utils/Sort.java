package com.arthur.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by artcslee on 7/28/16.
 */
public class Sort {
    public static List<Comparable> sortDescending (List<Comparable> list) {
        ArrayList<Comparable> descendingList = new ArrayList<>();

        Iterator<Comparable> iterator = list.iterator();
        while(iterator.hasNext()) {
            Comparable insertObj = iterator.next();
            int insertIndex = 0;

            Iterator<Comparable> sortedListIterator = descendingList.iterator();
            while (sortedListIterator.hasNext()) {
                Comparable currNum = sortedListIterator.next();
                if (currNum.compareTo(insertObj) > 0) {
                    insertIndex++;
                }
            }

            if (insertIndex < descendingList.size()) {
                descendingList.add(insertIndex, insertObj);
            } else {
                descendingList.add(insertObj);
            }
        }

        return descendingList;
    }
}
