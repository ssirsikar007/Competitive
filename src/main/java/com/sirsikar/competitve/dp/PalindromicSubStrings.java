package com.sirsikar.competitve.dp;

public class PalindromicSubStrings {
    public static void main(String[] args) {
        String s = "aaa";
        System.out.println("Palindromic substrings are: "+palindromicSubstrings(s));
    }

    private static int palindromicSubstrings(String s) {
        int count = 0;
        for(int i=0;i<s.length();i++){
           count += expand(s,i,i);
           count += expand(s,i,i+1);
        }
        return count;
    }

    private static int expand(String s, int left, int right) {
        int count = 0;
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            count++;
            left--;
            right++;
        }
        return count;
    }
}
