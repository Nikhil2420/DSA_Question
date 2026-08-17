package Stock_question;

public class BuyAndSellStock1 {

    /*
        we are maintaining a minimum so far
        and tried to sell each day
                or
         make an auxiliary array which will tell the maximum value after that index
     */
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            profit = Math.max(profit, prices[i] - min);
        }
        return profit;
    }
}