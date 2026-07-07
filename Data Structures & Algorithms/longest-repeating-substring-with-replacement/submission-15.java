class Solution {
    public int characterReplacement(String s, int k) {
        int left=0,right=0,max=0,window=0,ans=0;
        
        int[] count = new int[26]; 

        while(right<s.length()){ 
            char c = s.charAt(right);
            count[c-'A']++;
            max = Math.max(max,count[c-'A']);
            window = right-left+1;
            
            if(window-max>k){
                count[s.charAt(left)-'A']--; 
                left++;
            }
            ans = Math.max(ans,right-left+1);
            right++; 
        }
        return ans; 
    }
}
