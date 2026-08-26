package Matrix_Questions;


import java.util.HashMap;
import java.util.Map;

public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        Map<Pair, Integer> map = new HashMap<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    map.put(new Pair(i, j), 1);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0 && map.containsKey(new Pair(i, j))) {
                    for (int k = 0; k < m; k++) matrix[k][j] = 0;
                    for (int k = 0; k < n; k++) matrix[i][k] = 0;
                }
            }
        }

    }
}
