class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        HashMap<Character, Integer> map = new HashMap<>();
        
        for (char x : s.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        for(char x : t.toCharArray()){
            int cnt = map.getOrDefault(x,0)-1; 
            map.put(x,cnt);
            if(cnt<0) return false;
        }
        return true; 
    }
}