package Question;

public class SortColors {

    public void sortColors(int[] nums) {
        int n = nums.length;
        int i = 0;//0
        int j = 0;//1
        int k = n - 1;//2

        while (j <= k) {
            if (nums[j] == 1) {
                j++;
            } else if (nums[j] == 2) {
                int temp = nums[k];
                nums[k] = nums[j];
                nums[j] = temp;
                k--;
            } else {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
                i++;
            }
        }

    }
}
