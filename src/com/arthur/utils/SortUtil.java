package com.arthur.utils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * Created by artcslee on 7/28/16.
 */
public class SortUtil {
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

    public static List<Comparable> quickSort (List<Comparable> list) {
        System.out.println("UNSORTED:" + PrintUtil.printList(list));
        quickSortRecursive(list, 0, list.size()-1);
        System.out.println("SORTED:  " + PrintUtil.printList(list));
        return list;
    }

    private static void quickSortRecursive(List<Comparable> list, int iterator, int rightPivot) {
        if (rightPivot <= iterator) return;
        int iteratorStart = iterator;

        int leftPivot = iterator;
        int duplicate = 0;
        while(iterator < rightPivot) {
            int ivr = list.get(iterator).compareTo(list.get(rightPivot));
            if (ivr <= 0) {
                if (duplicate > 0) {
                    int firstDup = leftPivot - duplicate;
                    swapItems(list, firstDup, leftPivot);
                    swapItems(list, firstDup, iterator);
                } else {
                    swapItems(list, leftPivot, iterator);
                }
                leftPivot++;
            }
            if (ivr == 0) duplicate++;
            iterator++;
        }

        if (leftPivot < rightPivot) {
            swapItems(list, leftPivot, rightPivot);
            leftPivot++;
        }

        if (rightPivot-iteratorStart > 2) {
            quickSortRecursive(list, iteratorStart, leftPivot-1-duplicate);
            quickSortRecursive(list, leftPivot, rightPivot);
        }
    }

    public static void swapItems(List<Comparable> list, int index1, int index2) {
        Comparable swap = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, swap);
    }
}
