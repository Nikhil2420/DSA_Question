package DP;

public class TrappingRainWater {

    public int trap(int[] height) {
        int n = height.length;
        int pref[] = new int[n];
        int suff[] = new int[n];

        int prefix = height[0];
        for (int i = 0; i < n; i++) {
            prefix = Math.max(prefix, height[i]);
            pref[i] = prefix;
        }

        int suffix = height[n - 1];
        for (int i = n - 1; i >= 0; i--) {
            suffix = Math.max(suffix, height[i]);
            suff[i] = suffix;
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            ans += Math.min(pref[i], suff[i]) - height[i];
        }
        return ans;

    }
}