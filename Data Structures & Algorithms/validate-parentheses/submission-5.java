class Solution {
    public boolean isValid(String s) {
        //[,(,{ 중 하나가 아니라면 pop else then push
        //pop한 것이 == 하지 않다면 false, 맞다면 계속 
        if (s.length() % 2 != 0) return false;
        Stack<Character> st = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') st.push(c);
            else {
                if (st.isEmpty()) return false;
                char open = st.pop();
                if (c == ')' && open != '(') return false;
                if (c == ']' && open != '[') return false;
                if (c == '}' && open != '{') return false;
            }
        }
        return st.isEmpty(); 
    }
}
