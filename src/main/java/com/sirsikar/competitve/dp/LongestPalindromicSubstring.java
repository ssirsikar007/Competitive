package com.sirsikar.competitve.dp;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String s = "racecar";
        System.out.println("Longest Palindromic Substring is:"+longestPalindromicSubstring(s));
    }

    private static int longestPalindromicSubstring(String s) {
        int longest = 0;

        for(int i=0;i<s.length();i++){
            int r = i;
            int l = i;
            while(l>=0 && r < s.length() && s.charAt(r)==s.charAt(l)) {
                    longest = Math.max(longest,r-l+1);
                    r++;
                    l--;
            }
            l = i;
            r=i+1;
            while(r<s.length() && l>=0 && s.charAt(r)==s.charAt(l)) {
                longest = Math.max(longest,r-l+1);
                r++;
                l--;
            }

        }
        return longest;
    }
}
