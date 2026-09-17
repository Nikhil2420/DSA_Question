package Binary_Search_Questions;

public class FindMinimumInRotatedSortedArray {

    public int findMin(int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = nums.length - 1;
        int ans = Integer.MAX_VALUE;
        /*
                if left half is sorted then pick the smallest element from right i.e. nums[low]
                and look the smaller element in right half.
                if right half is sorted then pick the smallest element from right i.e. nums[mid]
                and look the smaller element in left half.
         */
        while (low <= high) {
            int mid = (low + high) / 2;

            /*
                if the search space is sorted than
                the first element will be the smallest,
                and we don't need to further do binary search
                ex-> 1 2 7 8
             */
            if (nums[low] <= nums[high]) {
                ans = Math.min(ans, nums[low]);
                break;
            } else if (nums[low] <= nums[mid]) {
                ans = Math.min(ans, nums[low]);
                low = mid + 1;
            } else {
                ans = Math.min(ans, nums[mid]);
                high = mid - 1;
            }
        }
        return ans;
    }
}