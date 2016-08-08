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
        ListNode firstNum = l1;
        ListNode secondNum = l2;

        ListNode answer = null;

        int remainder = 0;
        ListNode currNode = answer;
        while (firstNum != null || secondNum != null) {
            int sum = addNodes(firstNum, secondNum) + remainder;
            remainder = sum / 10;
            ListNode sumNode = new ListNode(sum % 10);

            if (answer == null) {
                answer = sumNode;
            } else {
                currNode.next = sumNode;
            }

            currNode = sumNode;
            firstNum = firstNum == null ? null : firstNum.next;
            secondNum = secondNum == null ? null : secondNum.next;
        }

        if (remainder != 0) {
            ListNode lastNode = new ListNode(remainder);
            currNode.next = lastNode;
        }

        return answer;
    }

    public int addNodes(ListNode l1, ListNode l2) {
        int fNum = l1 == null ? 0 : l1.val;
        int sNum = l2 == null ? 0 : l2.val;

        return fNum + sNum;
    }
}
