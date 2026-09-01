package BackTracking;

import java.util.ArrayList;

public class RatInAMaze {

    ArrayList<String> ans;
    boolean[][] visited;

    public ArrayList<String> ratInMaze(int[][] maze) {
        int m = maze.length;
        int n = maze[0].length;
        ans = new ArrayList<>();
        visited = new boolean[m][n];
        solve(0, 0, m, n, new StringBuilder(), maze);
        return ans;
    }

    public void solve(int i, int j, int m, int n, StringBuilder sb, int[][] maze) {
        if (i >= m || i < 0 || j >= n || j < 0 || maze[i][j] == 0 || visited[i][j]) return;

        if (i == m - 1 && j == n - 1) {
            ans.add(sb.toString());
            return;
        }


        visited[i][j] = true;
        //DLRU is lexicographically smaller
        //down
        solve(i + 1, j, m, n, sb.append("D"), maze);
        deleteLastCharacter(sb);

        //left
        solve(i, j - 1, m, n, sb.append("L"), maze);
        deleteLastCharacter(sb);


        //right
        solve(i, j + 1, m, n, sb.append("R"), maze);
        deleteLastCharacter(sb);


        //upward
        solve(i - 1, j, m, n, sb.append("U"), maze);
        deleteLastCharacter(sb);
        visited[i][j] = false;

    }

    public void deleteLastCharacter(StringBuilder sb) {
        sb.deleteCharAt(sb.length() - 1);
    }
}