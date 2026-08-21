package Greedy_Questions;

import java.util.Arrays;

public class MinimumPlatforms {

    public int minPlatform(int arr[], int dep[]) {

        Arrays.sort(arr);
        Arrays.sort(dep);
        int m = arr.length;
        int n = dep.length;
        int i = 0;
        int j = 0;
        int count = 0;
        int max = 0;
        while (i < m && j < n) {
            if (arr[i] <= dep[j]) {
                i++;
                count++;
            } else {
                j++;
                count--;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
