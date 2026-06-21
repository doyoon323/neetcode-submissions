class Solution {
    public boolean isValid(String s) {
        //[,(,{ 중 하나가 아니라면 pop else then push
        //pop한 것이 == 하지 않다면 false, 맞다면 계속 
        if (s.length() % 2 != 0) return false;
        char[] st = new char[s.length()];
        int i=0; 

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                st[i] = c; 
                i++; 
            }
            else {
                if (i==0) return false;
                char open = st[--i];
                if (c == ')' && open != '(') return false;
                if (c == ']' && open != '[') return false;
                if (c == '}' && open != '{') return false;
            }
        }
        return i==0; 
    }
}
