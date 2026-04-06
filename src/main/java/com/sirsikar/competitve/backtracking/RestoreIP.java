package com.sirsikar.competitve.backtracking;

import java.util.ArrayList;

public class RestoreIP {
    public static void main(String[] args) {
        String s = "25525511135";
        restoreIp(s,0,new ArrayList<>());
    }

    private static void restoreIp(String s, int idx, ArrayList<Object> list) {
    if(list.size() > 4) return;
    if (idx == s.length() && list.size() == 4) {
        list.forEach(k -> {System.out.print(k+".");});
        System.out.println();
        return;
    }
    for (int i = idx; i < Math.min(idx + 3, s.length()); i++) {

        String part = s.substring(idx, i + 1);

        // Leading zero check
        if (part.length() > 1 && part.startsWith("0")) continue;

        int num = Integer.parseInt(part);

        if (num > 255) continue;

        list.add(part);
        restoreIp(s, i + 1, list);
        list.remove(list.size() - 1);
    }
    }
}
