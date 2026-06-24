class Solution {
    public int mySqrt(int x) {
        if(x==0) return 0; 
        if(x<4) return 1; 
        
        int high = x/2;
        int low = 0;

        while(low<=high){
            int mid = low+(high-low)/2;
            if(x/mid == mid) return mid; 
            
            if(x/mid > mid) low = mid+1;
            else high = mid-1; 
        }
        return high; 
    }
}