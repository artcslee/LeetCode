package com.arthur.problems;

import com.arthur.LeetCodeProblem;
import com.arthur.components.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given two linked lists representing two non-negative numbers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 */

public class AddTwoNumber extends LeetCodeProblem {
    @Override
    public Object setupProblem(String[] args) {
        ListNode firstNum = new ListNode(Character.getNumericValue(args[0].charAt(0)));
        ListNode secondNum = new ListNode(Character.getNumericValue(args[1].charAt(0)));

        ListNode currNode = firstNum;
        for (int i=1; i<args[0].length(); i++) {
            currNode.next = new ListNode(Character.getNumericValue(args[0].charAt(i)));
            currNode = currNode.next;
        }

        currNode = secondNum;
        for (int j=1; j<args[1].length(); j++) {
            currNode.next = new ListNode(Character.getNumericValue(args[1].charAt(j)));
            currNode = currNode.next;
        }

        ArrayList<ListNode> nodes = new ArrayList<>();
        nodes.add(firstNum);
        nodes.add(secondNum);

        return nodes;
    }

    @Override
    public void solution(Object arg) {
        List<ListNode> nums = (List<ListNode>) arg;
        ListNode firstNum = nums.get(0);
        ListNode secondNum = nums.get(1);

        System.out.println("Problem: [" + firstNum.toString() + "] + [" + secondNum.toString() + "]");
        ListNode sum = addTwoNumbers(firstNum, secondNum);
        System.out.println("Answer: [" + sum.toString() + "]");
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}
