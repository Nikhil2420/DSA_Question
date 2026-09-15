package Question;

public class RotateImage {

    public void rotate(int[][] matrix) {

        int m = matrix.length;

        //Transpose
        for (int i = 0; i < m; i++) {
            /*
                If we start j from 0 we will reach from where we have started
             */
            for (int j = i; j < m; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }


        //reverse every row
        for (int i = 0; i < m; i++) {
            int point = 0;//col
            int j = m - 1;//col
            while (point < j) {
                int temp = matrix[i][point];
                matrix[i][point] = matrix[i][j];
                matrix[i][j] = temp;
                point++;
                j--;
            }
        }
    }
}