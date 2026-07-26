class Solution {
    public void reverseString(char[] s) {
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < s.length - 1 - i; j++) {
                char temp = s[j];
                s[j] = s[j + 1];
                s[j + 1] = temp;
            }
        }
    }
}