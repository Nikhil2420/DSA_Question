package Question;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public int romanToInt(String s) {

        Map<Character, Integer> roman = new HashMap<>();
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);
        int sum = 0;
        /* when s.charAt(i+1)>s.charAt(i) subtract s.charAt(i) value else add s.charAt(i) value is in map */
        /*
            I = 1, V = 5
            1 < 5 → subtract I
            sum = -1
            Finally add V
            sum = -1 + 5 = 4
         */
        for (int i = 0; i < s.length() - 1; i++) {
            if (roman.get(s.charAt(i)) < roman.get(s.charAt(i + 1))) {
                sum -= roman.get(s.charAt(i));
            } else {
                sum += roman.get(s.charAt(i));
            }
        }
        return sum + roman.get(s.charAt(s.length() - 1));

    }
}