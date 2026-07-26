import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            int maxKey = 0;
            int maxFreq = -1;

            for (Integer key : map.keySet()) {
                if (map.get(key) > maxFreq) {
                    maxFreq = map.get(key);
                    maxKey = key;
                }
            }

            result[i] = maxKey;

            map.remove(maxKey);
        }

        return result;
    }
}