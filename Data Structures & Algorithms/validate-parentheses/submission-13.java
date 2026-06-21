class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;
        Stack<Character> st = new Stack<>();
        char[] arr= s.toCharArray();
        for (char c : arr) {
            if (c == '(' || c == '[' || c == '{') st.push(c);
            else {
                if (st.isEmpty()) return false;
                if (c == ')' && st.pop() == '(') continue;
                else if (c == ']' && st.pop() == '[') continue;
                else if (c == '}' && st.pop() == '{') continue;
                else return false; 
            }
        }
        return st.isEmpty();
    }
}