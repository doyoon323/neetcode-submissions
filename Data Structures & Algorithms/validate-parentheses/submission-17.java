class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        if (n % 2 != 0) return false;
        Stack<Character> st = new Stack<>();
        char c; 
        for(int i=0;i<n;i++) {
            c = s.charAt(i); 
            if (c == '(' || c == '[' || c == '{') st.push(c);
            else {
                if (st.isEmpty()) return false;
                int diff = c - st.pop();
                if (diff != 1 && diff != 2) return false;
            }
        }
        return st.isEmpty();
    }
}