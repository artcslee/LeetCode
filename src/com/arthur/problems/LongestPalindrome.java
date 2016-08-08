package com.arthur.problems;

import com.arthur.LeetCodeProblem;

import java.util.HashMap;

/**
 * Given a string S, find the longest palindromic substring in S.
 * You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
 */
public class LongestPalindrome extends LeetCodeProblem {
    @Override
    public Object setupProblem(String[] args) {
        return args[0];
    }

    @Override
    public void solution(Object arg) {
        String s = (String) arg;
        System.out.println("Problem String: [" + s + "]");
        String palindrome = longestPalindrome(s);
        System.out.println("Longest Palindrome: [" + palindrome + "]");
    }

    String checkString;
    String longestPalindrome;

    private static final int ODD = 1;
    private static final int EVEN = 0;

    public String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }
        checkString = s;
        int midPoint = s.length()/2;
        int indexOffset = 0;
        String currPalindrome = longestPalindrome;

        while((midPoint + indexOffset) < s.length()) {
            System.out.println("--------------------------");

            //EXPlORE LEFT
            int palIndex = midPoint-indexOffset;
            String palString = s.substring(0, palIndex);
            String revString = reverseString(palString);

            System.out.println("LEFT: [" + palString + "]");
            if (revString.length()%2 == 0) {
                getPalindrome(palIndex, revString, EVEN);
            } else {
                getPalindrome(palIndex, revString, ODD);
            }

            //EXPLORE RIGHT
            if (indexOffset > 0) {
                palIndex = midPoint + indexOffset;
                int rightLength = s.length() - palIndex - 1;
                palString = s.substring(palIndex - rightLength, palIndex);
                revString = reverseString(palString);
                System.out.println("RIGHT[" + palString + "]");
                if (revString.length()%2 == 0) {
                    getPalindrome(palIndex, revString, EVEN);
                } else {
                    getPalindrome(palIndex, revString, ODD);
                }
            }

            indexOffset++;
            System.out.println("--------------------------");
        }

        return longestPalindrome;
    }

    public String getPalindrome(int index, String revLString, int isOdd) {
        if (longestPalindrome!=null && longestPalindrome.length() > maxPotential(revLString)) return longestPalindrome;
        if (revLString.length() == 0) {
            if (longestPalindrome == null && index-1 >= 0) {
                System.out.println("[" + checkString.charAt(index-1) + "][" + checkString.charAt(index) + "]");
                if(checkString.charAt(index) == checkString.charAt(index-1)) {
                    longestPalindrome = checkString.substring(index - 1, index + 1);
                }
            }
            if (longestPalindrome == null && index+1 < checkString.length()) {
                System.out.println("[" + checkString.charAt(index) + "][" + checkString.charAt(index+1) + "]");
                if (checkString.charAt(index) == checkString.charAt(index+1)) {
                    longestPalindrome = checkString.substring(index, index + 2);
                }
            }
            return longestPalindrome;
        }

        //Create Left String
        String lString = revLString;
        while (index+lString.length()+isOdd > checkString.length()) {
            lString = lString.substring(0, lString.length()-1);
        }
        if (lString.length() == 0) return getPalindrome(index, lString, Math.abs(isOdd));

        //Create Right String
        String rString = checkString.substring(index+isOdd, index+lString.length()+isOdd);

        //Print Comparing
        if (isOdd == ODD) {
            System.out.println("[" + lString + "][" + checkString.charAt(index) + "][" + rString + "]");
        } else {
            System.out.println("[" + lString + "][" + rString + "]");
        }

        //Compare
        String currPalindrome = null;
        if (lString.equals(rString)) {
            currPalindrome = checkString.substring(index-lString.length(), index+rString.length()+isOdd);
            updateLongestPalindrome(currPalindrome);
        }

        if (currPalindrome == null || currPalindrome.length() < maxPotential(revLString)) {
            String longerCurrPalindrome = getPalindrome(index, lString.substring(0, lString.length() - isOdd), Math.abs(isOdd - 1));
            updateLongestPalindrome(longerCurrPalindrome);
        }

        return longestPalindrome;
    }

    public void updateLongestPalindrome(String foundPalindrome) {
        if (foundPalindrome == null) return;
        if (longestPalindrome == null || longestPalindrome.length() < foundPalindrome.length()) {
            longestPalindrome = foundPalindrome;
        }
    }

    public int maxPotential(String lString) {
        return (lString.length()*2) + 1;
    }

    public String reverseString(String s) {
        String reverse = "";
        for (int i=s.length()-1; i>=0; i--) {
            reverse += s.charAt(i);
        }
        return reverse;
    }
}
