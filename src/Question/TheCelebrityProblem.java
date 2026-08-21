package Question;

public class TheCelebrityProblem {

    public int celebrity(int mat[][]) {
        // code here
        int m = mat.length;
        int n = mat[0].length;
        int knowMe[] = new int[m];
        int iKnow[] = new int[m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1 && i != j) {
                    knowMe[j]++;
                    iKnow[i]++;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            if (iKnow[i] == 0 && knowMe[i] == m - 1) return i;
        }
        return -1;
    }
}