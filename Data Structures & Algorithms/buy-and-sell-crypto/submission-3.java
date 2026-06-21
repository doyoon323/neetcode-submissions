class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit=0;
        int l=0,r=0; 
        for(int i=1;i<prices.length;i++){
            if(prices[l]<=prices[r+1]){
                r++;
                maxProfit = Math.max(maxProfit,prices[r]-prices[l]);
            }else l=++r;
        }
        return maxProfit; 
    }
}
