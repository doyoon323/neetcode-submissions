class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left=0, right=piles[0];
        for(int x : piles){
            if(right<x) right=x; 
        }

        while(left<right){
            int mid = (left+right)/2;
            if(mid==0) break; 
            int t=h; 
            
            for(int i=0;i<piles.length;i++){
                t-=piles[i]/mid;
                if(piles[i]%mid!=0) t-=1;
                if(t<0) break; 
            }
            if(t>=0) right=mid;
            else left=mid+1; 
        }

        return right; 
    }
}