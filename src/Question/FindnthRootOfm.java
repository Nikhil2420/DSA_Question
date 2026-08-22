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

}