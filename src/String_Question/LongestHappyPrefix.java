package String_Question;

import java.util.HashSet;
import java.util.Set;

public class LongestHappyPrefix {

    /*
        MLE->Memory Limit Exceeded
    */
    public String longestPrefix(String s) {
        Set<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length() - 1; i++) {
            sb.append(s.charAt(i));
            set.add(sb.toString());
        }
        String str = "";
        int maxLen = 0;
        String ans = "";
        for (int i = s.length() - 1; i > 0; i--) {
            str = s.charAt(i) + str;
            if (set.contains(str)) {
                if (str.length() > maxLen) {
                    maxLen = str.length();
                    ans = str;
                }
            }
        }
        return ans;
    }
}