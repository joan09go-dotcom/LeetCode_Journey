class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        int sum = 0;

        // Integer.MAX_VALUE itu nilainya 2147483647
        int minLength = Integer.MAX_VALUE;
        int leftPointer = 0;

        for (int rightPointer = 0; rightPointer < nums.length; rightPointer++) {
            sum += nums[rightPointer];

            while (sum >= target) {
                minLength = Math.min(minLength, rightPointer - leftPointer + 1);
                sum -= nums[leftPointer];
                leftPointer++;
            }
        }

        // Selagi proses tidak menemukan hasil yang memenuhi syarat maka return 0
        if (minLength == Integer.MAX_VALUE) {
            return 0;
        }

        return minLength;
    }
}