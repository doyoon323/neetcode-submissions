class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int left =0, cur = 0, cnt = 0;
        HashSet<Character> set = new HashSet<>(); 

        while(cur<s.length()){
            char c = s.charAt(cur);
            if(set.contains(c)){
                cnt = Math.max(cnt,cur-left);
                while(set.contains(c)){
                    set.remove(s.charAt(left));
                    left++;
                }
            }

            set.add(c);
            cur++;
        }

        return Math.max(cnt,cur-left);
    }
}
