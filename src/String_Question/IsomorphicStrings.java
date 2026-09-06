package String_Question;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            /*
                s="f11"
                t="b23"
             */
            if (map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) != t.charAt(i)) {
                return false;
            }
            /*
                    s ="badc"
                    t ="baba"
             */
            else if (!map.containsKey(s.charAt(i)) && set.contains(t.charAt(i))) {
                return false;
            }
            set.add(t.charAt(i));
            map.put(s.charAt(i), t.charAt(i));
        }
        return true;
    }
}
