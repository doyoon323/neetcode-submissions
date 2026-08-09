class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] r = new int[temperatures.length];

        for(int i=0;i<temperatures.length;i++){
            int cur = temperatures[i];
            int idx=i+1,res=0;
            while(idx<temperatures.length){
                if(temperatures[idx]>cur) {
                    res = idx-i;
                    r[i]=res; 
                    break; 
                }
                idx++;
            }
        }
        return r;
    }
}
