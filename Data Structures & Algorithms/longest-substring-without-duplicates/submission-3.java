class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int left =0, cur = 0, cnt = 0;
        HashSet<Character> set = new HashSet<>(); 


// pwwkew => left=0, right=2, cnt=2;
        while(cur<s.length()){
            char c = s.charAt(cur);
            if(set.contains(c)){
                cnt = Math.max(cnt,cur-left); //1-0 == 1 
                while(set.contains(c)){
                    set.remove(s.charAt(left));
                    left++;
                }//left=2,cur=5
                continue; 
            }

            set.add(c);
            cur++;
        }

        return Math.max(cnt,cur-left);
    }
}
