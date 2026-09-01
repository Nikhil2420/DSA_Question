package String_Question;

public class ReverseWordsInAString {

    public String reverseWords(String s) {
        int n = s.length();
        String ans = "";
        int idx = 0;
        while (idx < n && s.charAt(idx) == ' ') idx++;
        int i = n - 1;
        while (i >= 0) {
            String str = "";
            int j = i;
            while (j >= 0 && s.charAt(j) == ' ') j--;

            while (j >= 0 && s.charAt(j) != ' ') {
                str = s.charAt(j) + str;
                j--;
            }
            i = j;
            ans = ans + str;
            if (i > idx) ans += " ";
        }
        return ans;
    }
}