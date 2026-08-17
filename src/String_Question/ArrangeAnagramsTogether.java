package String_Question;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ArrangeAnagramsTogether {

    public ArrayList<ArrayList<String>> anagrams(String[] arr) {

        Map<String, ArrayList<String>> map = new HashMap<>();
        for (String str : arr) {
            int[] ch = new int[26];
            for (int j = 0; j < str.length(); j++) {
                ch[str.charAt(j) - 'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 26; j++) {
                sb.append(ch[j]);
                sb.append("#");
            }

            String res = sb.toString();
            if (!map.containsKey(res)) {
                map.put(res, new ArrayList<String>());
            }
            map.get(res).add(str);
        }
        return new ArrayList<>(map.values());
    }
}