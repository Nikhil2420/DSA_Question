package Question;

public class NextPermutation {

    public void nextPermutation(int[] nums) {
        int idx = -1;
        int n = nums.length;
        for (int i = n - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                idx = i - 1;
                break;
            }
        }

        int rev = -1;
        if (idx != -1) {
            for (int i = n - 1; i > idx; i--) {
                if (nums[i] > nums[idx]) {
                    rev = i;
                    break;
                }
            }
            int temp = nums[idx];
            nums[idx] = nums[rev];
            nums[rev] = temp;
        }
        reverse(idx + 1, nums);
    }

    public void reverse(int i, int nums[]) {
        int j = nums.length - 1;
        while (i <= j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}