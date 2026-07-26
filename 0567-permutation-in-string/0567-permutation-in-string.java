import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        // Pake teknik frequency counting utk ngitung brapa kali char tertentu muncul di s1
        for (char c : s1.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0;

        for (int right = 0; right < s2.length(); right++) {
            // Tambahkan char-char kedalam need beserta frekuensi muncul per char
            char in = s2.charAt(right);
            window.put(in, window.getOrDefault(in, 0) + 1);

            // Jika window di s2 sudah melebihi s1.length maka keluarkan satu char dari paling kiri 
            if (right - left + 1 > s1.length()) {
                char out = s2.charAt(left);

                window.put(out, window.get(out) - 1);

                if (window.get(out) == 0) {
                    window.remove(out);
                }

                left++;
            }

            // Bandingkan kedua map jika kondisi panjang window sudah sesuai dengan panjang string s1
            if (right - left + 1 == s1.length()) {
                if (window.equals(need)) {
                    return true;
                }
            }
        }

        return false;
    }
}