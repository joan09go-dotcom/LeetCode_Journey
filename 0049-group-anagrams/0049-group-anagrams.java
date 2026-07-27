class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++){
            String s = strs[i];

            char[]key = s.toCharArray();
            Arrays.sort(key);
            String sortedKey = new String(key);

            if(map.containsKey(sortedKey)){
                map.get(sortedKey).add(s);
            }
            else {
                ArrayList<String> list = new ArrayList<>();
                list.add(s);
                map.put(sortedKey, list);
            }
        }

        return new ArrayList<>(map.values());
    }
}