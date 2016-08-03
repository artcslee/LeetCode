package com.arthur.components;

/**
 * Created by artcslee on 7/28/16.
 */
public class LinkedListNode {
    public int val;
    public LinkedListNode next;
    public LinkedListNode(int x) { val = x; }

    public void printList() {
        System.out.print(val);
        if (next != null) {
            System.out.print(" -> ");
            next.printList();
        } else {
            System.out.println("\n");
        }
    }
}
