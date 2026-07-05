class Solution {
    public int maxArea(int[] heights) {
        int left=0, right=heights.length-1;
        int h = Math.min(heights[right],heights[left]);
        int area = (right-left) * h;
        
        while(left<right){
            if(heights[right]>heights[left]){
                while(left<heights.length && h>= heights[left]) left++;
            }else{
                while(right>=0 && h>=heights[right]) right--;
            }
            if(left>=right) break;
            h = Math.min(heights[left],heights[right]);
            area = Math.max(area, h * (right-left));
        }
        return area; 
    }
}
