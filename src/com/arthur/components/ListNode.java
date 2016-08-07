package com.arthur.components;

/**
 * Created by artcslee on 7/28/16.
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }

    public void printList() {
        System.out.print(val);
        if (next != null) {
            System.out.print(" -> ");
            next.printList();
        } else {
            System.out.println("\n");
        }
    }

    @Override
    public String toString() {
        String toString = String.valueOf(val);
        if (next != null) {
            toString += " -> " + next.toString();
        }

        return toString;
    }
}
