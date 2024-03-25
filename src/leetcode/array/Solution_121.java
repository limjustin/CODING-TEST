package leetcode.array;

class Solution_121 {
    public int maxProfit(int[] prices) {
        int[] profitMax = new int[prices.length];
        int stockMax = -1;

        for (int i = prices.length - 1; i >= 0; i--) {
            if (prices[i] > stockMax)
                stockMax = prices[i];

            profitMax[i] = stockMax;
        }

        int bestProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            if ((profitMax[i] - prices[i]) > bestProfit)
                bestProfit = (profitMax[i] - prices[i]);
        }

        return bestProfit;
    }
}
