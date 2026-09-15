package Question.Array_Question;

public class RearrangeArrayElementsBySign {

    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] positive = new int[n / 2];
        int[] negative = new int[n / 2];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                positive[idx] = nums[i];
                idx++;
            }
        }

        idx = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] < 0) {
                negative[idx] = nums[i];
                idx++;
            }
        }

        int pos = 0;
        int neg = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                nums[i] = positive[pos];
                pos++;
            } else {
                nums[i] = negative[neg];
                neg++;
            }
        }
        return nums;
    }

    public int[] rearrangeArrayOptimized(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        int pos = 0;
        int neg = 1;

        for (int num : nums) {
            if (num > 0) {
                ans[pos] = num;
                pos += 2;
            } else {
                ans[neg] = num;
                neg += 2;
            }
        }
        return ans;
    }
}