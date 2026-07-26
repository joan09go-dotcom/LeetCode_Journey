class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        // Frekuensi karakter yang dibutuhkan
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int required = need.size();
        int matched = 0;

        int leftPointer = 0;

        int minLength = Integer.MAX_VALUE;
        int start = 0;

        for (int rightPointer = 0; rightPointer < s.length(); rightPointer++) {

            char current = s.charAt(rightPointer);

            // Tambahkan karakter ke window
            window.put(current, window.getOrDefault(current, 0) + 1);

            // Jika karakter ini sudah memenuhi jumlah yang dibutuhkan
            if (need.containsKey(current)
                    && window.get(current).equals(need.get(current))) {
                matched++;
            }

            // Jika window sudah valid, coba perkecil
            while (matched == required) {

                // Simpan window terkecil
                if (rightPointer - leftPointer + 1 < minLength) {
                    minLength = rightPointer - leftPointer + 1;
                    start = leftPointer;
                }

                char leftChar = s.charAt(leftPointer);

                // Keluarkan karakter paling kiri
                window.put(leftChar, window.get(leftChar) - 1);

                // Jika setelah dikurangi jadi tidak memenuhi kebutuhan
                if (need.containsKey(leftChar)
                        && window.get(leftChar) < need.get(leftChar)) {
                    matched--;
                }

                leftPointer++;
            }
        }

        if (minLength == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(start, start + minLength);
    }
}