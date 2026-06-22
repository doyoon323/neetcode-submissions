class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
    
        // 알파벳 소문자 26개
        int[] alphabet = new int[26];
        
        for (int i = 0; i < s.length(); i++) {
            alphabet[s.charAt(i) - 'a']++;
            alphabet[t.charAt(i) - 'a']--;
        }
        
        for (int count : alphabet) {
            if (count != 0) return false;
        }
        
        return true;
    }
}