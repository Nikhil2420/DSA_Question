package Binary_Search_Questions;

public class AllocateMinimumPages {

    public int findPages(int[] arr, int k) {
        if (k > arr.length) return -1;
        long low = 0;
        long high = 0;
        for (int elem : arr) {
            low = Math.max(elem, low);
            high += elem;
        }
        int ans = -1;

        while (low <= high) {
            long mid = (low + high) / 2;
            if (isPossible(mid, arr, k) <= k) {
                ans = (int) mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public int isPossible(long page, int arr[], int k) {
        int cnt = 1;
        int pages = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (pages + arr[i] <= page) {
                pages += arr[i];
            } else {
                cnt++;
                pages = arr[i];
            }
        }
        return cnt;
    }
}