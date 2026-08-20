package Question;

public class ProductOfArrayExceptItself {

    public static int[] productExceptSelf(int arr[]) {
        // code here
        int n = arr.length;
        int prefix[] = new int[n];
        int suffix[] = new int[n];
        int ans[] = new int[n];
        int pref = 1;
        int suff = 1;
        for (int i = 0; i < n; i++) {
            pref = pref * arr[i];
            suff = suff * arr[n - i - 1];
            prefix[i] = pref;
            suffix[n - i - 1] = suff;
        }

        for (int i = 0; i < n; i++) {
            int max = 1;
            if (i > 0) {
                max = prefix[i - 1];
            }

            if (i < n - 1) {
                max *= suffix[i + 1];
            }
            ans[i] = max;
        }
        return ans;
    }
}
