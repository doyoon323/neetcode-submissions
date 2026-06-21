class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        if (n % 2 != 0) return false;

        char[] st = new char[n];
        char c; 
        int p=0; 
        for(int i=0;i<n;i++) {
            c = s.charAt(i); 
            if (c == '(') st[p++] = '(';
            else if (c == '[') st[p++] = '[';
            else if (c == '{') st[p++] = '{';
            else {
                if (p==0 || (c - st[--p]!=1&&c-st[p]!=2) ) return false;
                //int diff = c - st[--p];
                //if (diff != 1 && diff != 2) return false;
            }
        }
        return p==0;
    }
}