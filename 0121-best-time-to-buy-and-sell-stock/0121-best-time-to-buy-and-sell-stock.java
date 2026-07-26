class Solution {
    public int maxProfit(int[] prices) {
        int leftPointer = 0;
        int rightPointer = 1;
        int maxProf = 0;

        while (rightPointer < prices.length) {
            if (prices[leftPointer] < prices[rightPointer]) {
                int profit = prices[rightPointer] - prices[leftPointer];
                maxProf = Math.max(maxProf, profit);
            } else {
                leftPointer = rightPointer;
            }
            rightPointer++;
        }

        return maxProf;
    }
}