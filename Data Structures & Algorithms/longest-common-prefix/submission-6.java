class Solution {
    public String longestCommonPrefix(String[] strs) {
        int res =0;
        for(int i=0;i<strs[0].length();i++){
            char s = strs[0].charAt(i);
            for(int j=1;j<strs.length;j++){
                if(strs[j].length()<=i) return strs[0].substring(0,res); 
                if(s!=strs[j].charAt(i)) return strs[0].substring(0,res); 
            }
            res++;
        }
        return strs[0].substring(0,res);  
    }
}