class Solution {
    public String mergeAlternately(String word1, String word2) {
        int p = 0;
        int w1 = word1.length(), w2 = word2.length();

        StringBuilder sb = new StringBuilder(w1+w2);
        
        while(p<w1 && p<w2){
            sb.append(word1.charAt(p));
            sb.append(word2.charAt(p++));
        }

        if(p<w1) sb.append(word1.substring(p));
        else sb.append(word2.substring(p));

        return sb.toString();
    }
}