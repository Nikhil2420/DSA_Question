package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class SmallestWindowWthAll {

    public static String minWindow(String s, String p) {
        // code here
        int len = p.length();
        if (len > s.length()) return "";
        Map<Character, Integer> map = new HashMap<>();
        int count = len;
        int startPoint = -1;
        int maxLen = Integer.MAX_VALUE;
        for (int i = 0; i < p.length(); i++) {
            map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0) + 1);
        }

        int i = 0;
        int j = 0;
        while (j < s.length()) {
            if (map.containsKey(s.charAt(j))) {
                if (map.get(s.charAt(j)) > 0) count--;
                map.put(s.charAt(j), map.get(s.charAt(j)) - 1);
            }

            while (count == 0) {

                if (j - i + 1 < maxLen) {
                    maxLen = j - i + 1;
                    startPoint = i;
                }

                if (map.containsKey(s.charAt(i))) {
                    map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
                    if (map.get(s.charAt(i)) > 0) count++;
                }
                i++;
            }
            j++;
        }

        return (maxLen == Integer.MAX_VALUE) ? "" : s.substring(startPoint, startPoint + maxLen);
    }
}