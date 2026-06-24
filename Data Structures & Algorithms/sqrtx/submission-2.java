class Solution {
    public int mySqrt(int x) {
        if(x==0) return 0; 
        if(x<4) return 1; 
        
        int high = x;
        int low = 0;
        int res = 0; 

        while(low<=high){
            int mid = low+(high-low)/2;
            //System.out.println(low+" "+high+" "+mid);
            
            if(x/mid >= mid){
                low = mid+1;
                res = mid;   
                //System.out.println("res: "+res);
            }else high = mid-1; 
        }
        return res; 
    }
}