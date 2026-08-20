package Question;

import java.util.ArrayList;

public class RemoveDuplicatesSortedArray {

    ArrayList<Integer> removeDuplicates(int[] arr) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        int i = 0;
        int n = arr.length;
        while (i < n) {
            while (i < n - 1 && arr[i] == arr[i + 1]) {
                i++;
            }
            ans.add(arr[i]);
            i++;
        }
        return ans;
    }
}
