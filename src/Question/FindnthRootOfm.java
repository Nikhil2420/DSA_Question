package Question;

public class FindnthRootOfm {

    public int nthRoot(int n, int m) {

        if (m == 1 || m == 0) return m;

        for (int i = 2; i <= m; i++) {
            int val = 1;
            for (int j = 1; j <= n; j++) {
                val *= i;
            }
            if (val == m) return i;
        }
        return -1;
    }

    public int nthRootUsingBinarySearch(int n, int m) {

        if (m == 1 || m == 0) return m;
        int low = 2;
        int high = m;
        while (low <= high) {
            int mid = (low + high) / 2;
            int val = 1;
            for (int j = 1; j <= n; j++) {
                val *= mid;
                if (val > m) break;
            }
            if (val == m) return mid;
            else if (val > m) high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }
}