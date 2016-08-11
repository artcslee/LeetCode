package com.arthur.problems;

import com.arthur.LeetCodeProblem;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *  Given a sorted integer array without duplicates, return the summary of its ranges.
 *
 * For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 */
public class SummaryRanges extends LeetCodeProblem {
    @Override
    public Object setupProblem(String[] args) {
        ArrayList<Integer> arg = new ArrayList<>();
        for (int x=0; x<args.length; x++) {
            arg.add(Integer.valueOf(args[x]));
        }
        return arg;
    }

    @Override
    public void solution(Object arg) {
        List<Integer> numList = (List<Integer>) arg;
        Iterator<Integer> numIterator = numList.iterator();

        String problem = "[";
        int[] nums = new int[numList.size()];
        int index = 0;
        while (numIterator.hasNext()) {
            nums[index] = numIterator.next();
            problem += nums[index] + ", ";
            index++;
        }
        problem = problem.substring(0, problem.length()-2) + "]";
        System.out.println("Problem: " + problem);

        List<String> ranges = summaryRanges(nums);
        Iterator<String> rangeIterator = ranges.iterator();
        System.out.print("[" + rangeIterator.next());
        while (rangeIterator.hasNext()) {
            System.out.print(", " + rangeIterator.next());
        }
        System.out.print("]");
    }

    public List<String> summaryRanges(int[] nums) {
        ArrayList<String> ranges = new ArrayList<>();
        if (nums.length == 0) return ranges;

        int startIndex = 0;
        int prev = nums[0];
        for (int i=1; i<nums.length; i++) {
            if (nums[i]-1 != prev) {
                ranges.add(makeRange(startIndex, i-1, nums));
                startIndex = i;
            }
            prev = nums[i];
        }

        ranges.add(makeRange(startIndex, nums.length-1, nums));

        return ranges;
    }

    private String makeRange(int start, int end, int[] nums) {
        String range = String.valueOf(nums[start]);
        if (start != end) {
            range += "->" + nums[end];
        }
        return range;
    }
}
