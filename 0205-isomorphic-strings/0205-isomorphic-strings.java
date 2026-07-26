class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;

        HashMap<Character,Character>mapStoT = new HashMap<>();
        HashMap<Character,Character>mapTtoS = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            char a = s.charAt(i);
            char b = t.charAt(i);

            if(mapStoT.containsKey(a) && mapStoT.get(a) != b){
                return false;
            } else {
                mapStoT.put(a,b);
            }

            if(mapTtoS.containsKey(b) && mapTtoS.get(b) != a){
                return false;
            } else {
                mapTtoS.put(b,a);
            }
        }
        
        return true;
    }
}