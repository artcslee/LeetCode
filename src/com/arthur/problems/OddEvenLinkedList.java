package com.arthur.problems;

import com.arthur.LeetCodeProblem;
import com.arthur.components.LinkedListNode;

/**
 * Created by artcslee on 7/28/16.
 */
public class OddEvenLinkedList extends LeetCodeProblem {

    @Override
    public Object setupProblem(String[] args) {
        LinkedListNode head = new LinkedListNode(Integer.valueOf(args[0]));
        LinkedListNode curr = head;
        for (int x=1; x<args.length; x++) {
            curr.next = new LinkedListNode(Integer.valueOf(args[x]));
            curr = curr.next;
        }
        return head;
    }

    @Override
    public void solution(Object arg) {
        LinkedListNode head = (LinkedListNode) arg;
        head.printList();
        mutateList(head, head.next, head.next);
        head.printList();
    }

    public void mutateList(LinkedListNode odd, LinkedListNode even, LinkedListNode evenHead) {
        if (even == null) return;

        LinkedListNode nextOdd = even.next;
        if (nextOdd != null) {
            even.next = nextOdd.next;
            odd.next = nextOdd;
            nextOdd.next = evenHead;
            mutateList(nextOdd, even.next, evenHead);
        }
    }
}