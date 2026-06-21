class Solution {
    public boolean isValid(String s) {
        //[,(,{ 중 하나가 아니라면 pop else then push
        //pop한 것이 == 하지 않다면 false, 맞다면 계속 
        Stack<String> st = new Stack<>();
        String[] str = s.split("");

        for(String c : str){
            if (!"({[".contains(c)){
                if(st.isEmpty()) return false; 
                String pair = st.pop();

                if(c.equals(")") && pair.equals("(")) continue; 
                if(c.equals("]") && pair.equals("[")) continue; 
                if(c.equals("}") && pair.equals("{")) continue; 

                return false; 
            }else st.push(c);
        }
        if(!st.isEmpty()) return false;
        return true; 
    }
}
