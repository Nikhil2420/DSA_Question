package String_Question;

public class SumOfBeautyOfAllSubstrings {

    /*
            Time Complexity  = O(n³)
            Space Complexity = O(26) = O(1)
     */
    public int beautySum(String s) {
        int n = s.length();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            boolean val = false;
            for (int j = i + 1; j < n; j++) {
                if (!val) {
                    val = checkMoreThanOneCharacter(s, i, j);
                }

                if (val) {
                    sum += calculateBeautySubstring(s, i, j);
                }
            }
        }
        return sum;
    }


    public int calculateBeautySubstring(String s, int startIndex, int endIndex) {
        int ch[] = new int[26];
        for (int i = startIndex; i <= endIndex; i++) {
            ch[s.charAt(i) - 'a']++;
        }
        int max = calculateMaxFrequency(ch);
        int min = calculateMinFrequency(ch);
        return max - min;
    }

    public int calculateMaxFrequency(int ch[]) {
        int max = 0;
        for (int elem : ch) max = Math.max(max, elem);
        return max;
    }

    public int calculateMinFrequency(int ch[]) {
        int min = Integer.MAX_VALUE;
        for (int elem : ch) {
            if (elem > 0) {
                min = Math.min(min, elem);
            }
        }
        return min;
    }

    public boolean checkMoreThanOneCharacter(String s, int startIndex, int endIndex) {
        boolean flag = false;
        char ch = s.charAt(startIndex);
        for (int i = startIndex + 1; i <= endIndex; i++) {
            if (s.charAt(i) != ch) return true;
        }
        return false;
    }


    /*
       Optimal Approach
       Time Complexity  -> O(n² * 26) ≈ O(n²)
       Space Complexity -> O(26) = O(1)
    */
    public int beautySumOptimal(String s) {
        int n = s.length();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int[] ch = new int[26];
            for (int j = i; j < n; j++) {
                ch[s.charAt(j) - 'a']++;
                int max = 0;
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < 26; k++) {
                    if (ch[k] > 0) {
                        max = Math.max(max, ch[k]);
                        min = Math.min(min, ch[k]);
                    }
                }
                sum += (max - min);
            }
        }
        return sum;
    }
}
