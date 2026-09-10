package DP;

import java.util.HashMap;
import java.util.Map;

public class CountPalindromicSubsequences {

    int mod = (int) Math.pow(10, 9) + 7;
    Map<String, Integer> memo;

    public int countPalindromes(String s) {
        int minimumSize = 5;
        memo = new HashMap<>();
        return solve(s, minimumSize, 0, new StringBuilder()) % mod;
    }

    public int solve(String s, int size, int idx, StringBuilder sb) {

        if (sb.length() == size) {
            if (isPalindrome(sb.toString())) {
                return 1;
            }
            return 0;
        }
        if (idx >= s.length() || sb.length() > size) return 0;
        String key = idx + "#" + sb.toString();
        if (memo.containsKey(key)) return memo.get(key);
        //take
        sb.append(s.charAt(idx));
        int take = solve(s, size, idx + 1, sb);
        sb.deleteCharAt(sb.length() - 1);

        int notTake = solve(s, size, idx + 1, sb);
        int ans = (take + notTake) % mod;
        memo.put(key, ans);
        return ans;
    }

    public boolean isPalindrome(String str) {
        int i = 0;
        int j = str.length() - 1;
        while (i <= j) {
            if (str.charAt(i) != str.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}