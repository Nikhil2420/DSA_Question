package Binary_Search_Questions;

import java.util.Arrays;

public class AggressiveCows {

    public int aggressiveCows(int[] arr, int k) {

        Arrays.sort(arr);
        int n = arr.length;
        int low = 1;
        int high = arr[n - 1] - arr[0];
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isPossible(mid, arr, k)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    public boolean isPossible(int dis, int arr[], int k) {
        int cnt = 1;
        int lastPlace = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - lastPlace >= dis) {
                cnt++;
                lastPlace = arr[i];
            }

            if (cnt == k) return true;
        }
        return false;
    }
}