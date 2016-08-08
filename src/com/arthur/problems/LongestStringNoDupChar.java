package com.arthur.problems;

import com.arthur.LeetCodeProblem;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Examples:
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * Given "bbbbb", the answer is "b", with the length of 1.
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
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
