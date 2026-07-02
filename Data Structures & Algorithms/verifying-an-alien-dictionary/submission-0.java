
class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        List<Integer>[] graph = new ArrayList[26];
        for (int i = 0; i < 26; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            
            int minLen = Math.min(word1.length(), word2.length());
            boolean hasDiff = false;
            
            for (int j = 0; j < minLen; j++) {
                int c1 = word1.charAt(j) - 'a';
                int c2 = word2.charAt(j) - 'a';
                
                if (c1 != c2) {
                    graph[c1].add(c2); // c1 -> c2 방향의 간선(화살표) 추가
                    hasDiff = true;
                    break; // 첫 번째로 다른 글자만 우선순위를 가집니다.
                }
            }
            
            if (!hasDiff && word1.length() > word2.length()) {
                return false;
            }
        }

        int[] alienOrder = new int[26];
        for (int i = 0; i < order.length(); i++) {
            alienOrder[order.charAt(i) - 'a'] = i;
        }
        
        for (int i = 0; i < 26; i++) {
            for (int neighbor : graph[i]) {
                if (alienOrder[i] > alienOrder[neighbor]) {
                    return false; 
                }
            }
        }
        
        return true;
    }
}