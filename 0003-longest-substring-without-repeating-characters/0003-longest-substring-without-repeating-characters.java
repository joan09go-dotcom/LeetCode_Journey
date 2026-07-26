import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {

        if (s.length() == 0) return 0;

        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {

            HashSet<Character> set = new HashSet<>();

            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);

                if (set.contains(c)) {
                    break;
                }

                set.add(c);
            }

            if (set.size() > maxLength) {
                maxLength = set.size();
            }
        }

        return maxLength;
    }
}

