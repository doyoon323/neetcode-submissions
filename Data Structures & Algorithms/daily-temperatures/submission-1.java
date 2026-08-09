class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] r = new int[temperatures.length];
        Deque<Integer> st = new ArrayDeque<>();
        st.push(0);

        for(int i=1;i<temperatures.length;i++){
            //System.out.println(st.peek());
            while(!st.isEmpty() && temperatures[i]>temperatures[st.peek()]){
                //System.out.println(i+ " > " + st.peek());
                r[st.peek()] = i-st.pop();
            }
            st.push(i);//38,30,36
            //System.out.println(st.toString());
        }
        return r;
    }
}
