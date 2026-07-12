class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str : strs) sb.append(str.length()).append("#").append(str);
        return sb.toString(); 
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;
        
        while (i < str.length()) {
            int delimiterIdx = str.indexOf('#', i);
            int len = Integer.parseInt(str.substring(i, delimiterIdx));
            int wordStartIdx = delimiterIdx+1;
            
            res.add(str.substring(wordStartIdx, wordStartIdx + len));
            i = wordStartIdx+len;
        }
        return res; 
    }
}
