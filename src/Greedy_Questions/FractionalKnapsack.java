package Greedy_Questions;

import java.util.Arrays;

public class FractionalKnapsack {

    public double fractionalKnapsack(int[] val, int[] wt, int capacity) {

        int n = val.length;
        Knapsack knap[] = new Knapsack[n];
        for (int i = 0; i < n; i++) {
            knap[i] = new Knapsack(val[i], wt[i], (val[i] / (wt[i] * 1.0)));
        }

        Arrays.sort(knap, (a, b) -> Double.compare(b.unitWeight, a.unitWeight));

        double ans = 0;
        for (int i = 0; i < n; i++) {
            if (knap[i].weight <= capacity) {
                ans += knap[i].value;
                capacity -= knap[i].weight;
            } else {
                ans += knap[i].unitWeight * capacity;
                capacity = 0;
                break;
            }
        }
        return ans;
    }
}

