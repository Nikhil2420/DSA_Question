package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    List<List<String>> ans;

    public List<List<String>> partition(String s) {
        ans = new ArrayList<>();
        solve(s, 0, new ArrayList<>());
        return ans;
    }

    public void solve(String str, int idx, List<String> temp) {
        if (idx >= str.length()) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = idx; i < str.length(); i++) {
            String pref = str.substring(idx, i + 1);
            if (isPalindrome(pref)) {
                temp.add(pref);
                solve(str, i + 1, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}