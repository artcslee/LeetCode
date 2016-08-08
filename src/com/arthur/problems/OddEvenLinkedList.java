package com.arthur.problems;

import com.arthur.LeetCodeProblem;
import com.arthur.components.ListNode;

/**
 * Given a singly linked list, group all odd nodes together followed by the even nodes.
 * Please note here we are talking about the node number and not the value in the nodes.
 * You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
 *
 * Example:
 * Given 1->2->3->4->5->NULL,
 * return 1->3->5->2->4->NULL.
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
        oddEvenList(head);
        head.printList();
    }

    public ListNode oddEvenList(ListNode head) {
        if (head!=null) {
            mutateList(head, head.next, head.next);
        }
        return head;
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
