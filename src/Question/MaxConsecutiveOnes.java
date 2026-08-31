package Question;

public class MaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {
        int cnt = 0;
        int max = 0;
        for (int elem : nums) {
            if (elem == 1) cnt++;
            else cnt = 0;
            max = Math.max(max, cnt);
        }

        
        return max;
    }
}