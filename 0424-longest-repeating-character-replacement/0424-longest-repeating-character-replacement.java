class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();

        int left = 0;
        int result = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);

            int maxFreq = 0;

            for (Character key : map.keySet()) {
                maxFreq = Math.max(maxFreq, map.get(key));
            }

            while ((right - left + 1) - maxFreq > k) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                left++;

                maxFreq = 0;
                for (Character key : map.keySet()) {
                    maxFreq = Math.max(maxFreq, map.get(key));
                }
            }

            result = Math.max(result, right - left + 1);
        }

        return result;
    }
}