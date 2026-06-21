class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n+1];
        res[0]=0; 
        for(int i=1;i<=n;i++){
            int ans=0;
            int val = i; 
            while(val!=0){
                val = val&(val-1);
                ans++; 
            }
            res[i]=ans;
        }
        return res; 
    }
}