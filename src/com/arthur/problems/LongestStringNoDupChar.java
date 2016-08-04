package com.arthur.problems;

import com.arthur.LeetCodeProblem;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by artcslee on 8/4/16.
 */
public class LongestStringNoDupChar extends LeetCodeProblem {
    @Override
    public Object setupProblem(String[] args) {
        return args[0];
    }

    @Override
    public void solution(Object arg) {
        String s = (String) arg;
        System.out.println("Problem String: [" + s + "]");
        lengthOfLongestSubstring(s);
    }

    public int lengthOfLongestSubstring(String s) {
        String longestString = "";
        String currString = "";
        int currStartingIndex = 0;
        HashMap<Character, Integer> currChars = new HashMap<>();

        for (int i=0; i<s.length(); i++) {
            Integer prevIndex = currChars.put(s.charAt(i), i);
            if (prevIndex != null) {
                if (currStartingIndex <= prevIndex) {
                    currString = s.substring(prevIndex + 1, i);
                    currStartingIndex = prevIndex+1;
                }
            }

            currString += s.charAt(i);
            if (longestString.length() < currString.length()) {
                longestString = currString;
            }
        }

        System.out.println("Longest String: [" + longestString + "] length: [" + longestString.length() + "]");
        return longestString.length();
    }
}
