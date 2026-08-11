package Question;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> one = new ArrayList<>();
        one.add(1);
        ans.add(one);
        for (int i = 1; i < numRows; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            List<Integer> prev = ans.get(i - 1);
            for (int j = 1; j <= i - 1; j++) {
                temp.add(prev.get(j) + prev.get(j - 1));
            }
            temp.add(1);
            ans.add(temp);
        }
        return ans;
    }
}
