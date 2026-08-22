package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        int time = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }

                if (grid[i][j] == 1) fresh++;
            }
        }

        if (fresh == 0) return 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean changed = false;
            while (size-- > 0) {
                int temp[] = queue.remove();
                int row = temp[0];
                int col = temp[1];

                if (col + 1 < n && grid[row][col + 1] == 1) {
                    grid[row][col + 1] = 2;
                    queue.add(new int[]{row, col + 1});
                    changed = true;
                    fresh--;
                }

                if (col - 1 >= 0 && grid[row][col - 1] == 1) {
                    grid[row][col - 1] = 2;
                    queue.add(new int[]{row, col - 1});
                    changed = true;
                    fresh--;
                }

                if (row + 1 < m && grid[row + 1][col] == 1) {
                    grid[row + 1][col] = 2;
                    queue.add(new int[]{row + 1, col});
                    changed = true;
                    fresh--;
                }

                if (row - 1 >= 0 && grid[row - 1][col] == 1) {
                    grid[row - 1][col] = 2;
                    queue.add(new int[]{row - 1, col});
                    changed = true;
                    fresh--;
                }
            }
            if (changed) time++;
        }
        return (fresh == 0 ? time : -1);

    }
}