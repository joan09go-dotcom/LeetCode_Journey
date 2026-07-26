class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder result = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                result.append(Character.toLowerCase(c));
            }
        }

        int leftPointer = 0;
        int rightPointer = result.length() - 1;

        while (leftPointer < rightPointer) {
            if (result.charAt(leftPointer) != result.charAt(rightPointer)) {
                return false;
            }

            leftPointer++;
            rightPointer--;
        }

        return true;
    }
}