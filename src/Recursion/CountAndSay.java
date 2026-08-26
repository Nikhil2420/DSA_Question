package Recursion;

public class CountAndSay {

    public String countAndSay(int n) {
        return func(n);
    }

    public String func(int n) {
        if (n == 1) return "1";
        String str = func(n - 1);
        int cnt = 0;
        char last = '/';
        String ans = "";
        for (int i = 0; i < str.length(); i++) {
            if (last == '/' || last == str.charAt(i)) {
                cnt++;
                last = str.charAt(i);
            } else {
                ans += cnt + "" + last;
                last = str.charAt(i);
                cnt = 1;
            }
        }
        ans += cnt + "" + last;
        return ans;
    }
}