package com.arthur.problems;

import com.arthur.LeetCodeProblem;

/**
 * Created by artcslee on 8/4/16.
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

    public String longestPalindrome(String s) {
        String palindrome = null;
        if (s.length() == 1) {
            return s;
        }
        int midPoint = s.length()/2;
        int indexOffset = 0;

        while((midPoint - indexOffset) > 0 && (palindrome == null || !checkLongest(s, palindrome, indexOffset))) {
            //EXPlORE LEFT
            System.out.println("--------------------------");
            String palHalf = s.substring(0, midPoint-indexOffset);
            System.out.println("LEFT: [" + palHalf + "] ");
            String rString = reverseString(palHalf);
            String foundPalindrome = fetchPalindrome(s, midPoint-indexOffset, 0, rString);
            palindrome = foundPalindrome == null ? palindrome : foundPalindrome;

            //EXPLORE RIGHT
            if (indexOffset > 0 && !checkLongest(s, palindrome, indexOffset)) {
                int palIndex = midPoint + indexOffset;
                int rightLength = s.length() - palIndex - 1;
                palHalf = s.substring(palIndex-rightLength, palIndex);
                System.out.println("RIGHT: [" + s.substring(palIndex+1, s.length()) + "]");
                rString = reverseString(palHalf);
                int currPalLength = palindrome == null ? 0 : palindrome.length();
                foundPalindrome = fetchPalindrome(s, midPoint+indexOffset, currPalLength, rString);
                palindrome = foundPalindrome == null ? palindrome : foundPalindrome;
            }

            indexOffset++;
            System.out.println("--------------------------");
        }

        return palindrome;
    }

    public String fetchPalindrome(String s, int index, int currLongest, String revLString) {
        String palindrome = null;

        if (revLString.length() == 0) {
            if (s.charAt(index) == s.charAt(index-1)) {
                palindrome = s.substring(index-1, index+1);
            } else if ((index+1<s.length()) && (s.charAt(index) == s.charAt(index+1))) {
                palindrome = s.substring(index, index+2);
            }
            return palindrome;
        }

        int palIndex = index+1;
        if (s.length() < palIndex + revLString.length()) {
            return fetchPalindrome(s, index, currLongest, revLString.substring(0, revLString.length()-1));
        }

    String rString = s.substring(palIndex, palIndex+revLString.length());
    System.out.println("[" + revLString + "][" + s.charAt(index) + "][" + rString + "]");
    if (revLString.equals(rString)) {
        palindrome = s.substring(index-revLString.length(), palIndex + revLString.length());
    } else {
        if (currLongest < revLString.length()) {
            palindrome = fetchPalindrome(s, index, currLongest, revLString.substring(0, revLString.length()-1));
        }
    }
    return palindrome;
}

    public String reverseString(String s) {
        String reverse = "";
        for (int i=s.length()-1; i>=0; i--) {
            reverse += s.charAt(i);
        }
        return reverse;
    }

    public boolean checkLongest(String s, String palindrome, int offSet) {
        if (palindrome == null || palindrome.length()/2 < s.length()/2-offSet) {
            return false;
        }
        return true;
    }
}
