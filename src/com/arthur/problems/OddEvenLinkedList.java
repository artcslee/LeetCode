package com.arthur.problems;

import com.arthur.LeetCodeProblem;
import com.arthur.components.ListNode;

/**
 * Created by artcslee on 7/28/16.
 */
public class OddEvenLinkedList extends LeetCodeProblem {

    @Override
    public Object setupProblem(String[] args) {
        ListNode head = new ListNode(Integer.valueOf(args[0]));
        ListNode curr = head;
        for (int x=1; x<args.length; x++) {
            curr.next = new ListNode(Integer.valueOf(args[x]));
            curr = curr.next;
        }
        return head;
    }

    @Override
    public void solution(Object arg) {
        ListNode head = (ListNode) arg;
        head.printList();
        mutateList(head, head.next, head.next);
        head.printList();
    }

    public void mutateList(ListNode odd, ListNode even, ListNode evenHead) {
        if (even == null) return;

        ListNode nextOdd = even.next;
        if (nextOdd != null) {
            even.next = nextOdd.next;
            odd.next = nextOdd;
            nextOdd.next = evenHead;
            mutateList(nextOdd, even.next, evenHead);
        }
    }
}
