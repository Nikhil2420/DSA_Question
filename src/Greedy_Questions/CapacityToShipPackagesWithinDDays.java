package Greedy_Questions;

public class CapacityToShipPackagesWithinDDays {

    public int shipWithinDays(int[] weights, int days) {

        int low = 1;
        int high = 0;
        for (int wt : weights) {
            high += wt;
        }
        int ans = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isPossible(mid, weights, days)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }


    public boolean isPossible(int maxWeight, int wt[], int days) {
        int day = 1;
        int weight = 0;
        for (int elem : wt) {
            if (elem > maxWeight) return false;
            else if (weight + elem <= maxWeight) {
                weight += elem;
            } else {
                day++;
                weight = elem;
            }
        }
        return (day <= days);
    }
}