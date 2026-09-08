package Question.Array_Question;

import java.util.*;

public class ReplaceElementsByRanks {


    public void replaceWithRank(int[] arr) {
        int n = arr.length;
        int[][] temp = new int[n][2];
        for (int i = 0; i < n; i++) {
            temp[i][0] = arr[i];
            temp[i][1] = i;
        }

        Arrays.sort(temp, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });

        for (int rank = 0; rank < n; rank++) {
            int originalIndex = temp[rank][1];
            arr[originalIndex] = rank;
        }
    }
}

