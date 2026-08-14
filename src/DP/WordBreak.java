package DP;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

    Set<String> set;
    int memo[];

    public boolean wordBreak(String s, List<String> wordDict) {
        set = new HashSet<>();
        memo = new int[s.length()];
        Arrays.fill(memo, -1);
        for (String str : wordDict) set.add(str);
        return solve(s, 0);
    }

    public boolean solve(String str, int idx) {
        if (idx >= str.length()) return true;
        if (memo[idx] != -1) return (memo[idx] == 1);
        for (int i = 1; i + idx <= str.length(); i++) {
            String pref = str.substring(idx, idx + i);
            if (set.contains(pref) && solve(str, idx + i)) {
                memo[idx] = 1;
                return true;
            }
        }
        memo[idx] = 0;
        return false;
    }
}