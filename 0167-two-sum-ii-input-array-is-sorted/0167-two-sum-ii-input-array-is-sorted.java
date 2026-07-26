class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int leftPointer = 0;
        int rightPointer = numbers.length - 1;
        int[]result = new int[2];

        while(leftPointer < rightPointer){
            int sum = numbers[leftPointer] + numbers[rightPointer];
            if(sum < target){
                leftPointer++;
            } else if(sum > target){
                rightPointer--;
            } else {
                result[0] = leftPointer + 1;
                result[1] = rightPointer + 1;
                break;
            }
        }
        return result;
    } 
}