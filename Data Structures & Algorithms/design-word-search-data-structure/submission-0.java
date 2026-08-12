class WordDictionary {

    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }

    private final TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (curr.children[index] == null) {
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
        }
        curr.isEnd = true;
    }
    
    public boolean search(String word) {
        return searchInNode(word, 0, root);
    }
    
    private boolean searchInNode(String word, int idx, TrieNode node) {
        if (idx == word.length()) {
            return node.isEnd;
        }

        char c = word.charAt(idx);

        if (c == '.') {
            for (int i = 0; i < 26; i++) {
                if (node.children[i] != null) {
                    if (searchInNode(word, idx + 1, node.children[i])) {
                        return true;
                    }
                }
            }
            return false;
        } 
        
        else {
            int index = c - 'a';
            if (node.children[index] == null) {
                return false;
            }
            return searchInNode(word, idx + 1, node.children[index]);
        }
    }
}