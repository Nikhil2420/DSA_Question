package Question;

public class ThreeGreatCandidates {

    public int maxProduct(int[] arr) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for (int elem : arr) {
            if (elem > max1) {
                max3 = max2;
                max2 = max1;
                max1 = elem;
            } else if (elem > max2) {
                max3 = max2;
                max2 = elem;
            } else if (elem > max3) max3 = elem;

            if (elem < min1) {
                min2 = min1;
                min1 = elem;
            } else if (elem < min2) min2 = elem;
        }

        return Math.max(max1 * max2 * max3, min1 * min2 * max1);
    }
}
