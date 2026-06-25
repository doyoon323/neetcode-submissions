class Solution {
    public String mergeAlternately(String word1, String word2) {
        int n = 0;
        int p1=0,p2=0;
        int w1 = word1.length(), w2 = word2.length();

        StringBuilder sb = new StringBuilder();
        
        while(p1<w1 && p2<w2){
            if(n%2==0) sb.append(word1.charAt(p1++));
            else sb.append(word2.charAt(p2++));
            n++;
        }

        while(p1<w1) sb.append(word1.charAt(p1++));
        while(p2<w2) sb.append(word2.charAt(p2++));

        return sb.toString();
    }
}