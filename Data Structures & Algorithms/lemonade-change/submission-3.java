class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;

        // 10
        // five = 0
        // ten = 0

        for(int cost : bills){
            System.out.println(cost);
            if(cost == 5) {
                five+=1; 
                continue; 
            }

            if(cost==10){ 
                ten+=1; 
                if(five==0) return false; 
                else{
                    five-=1; continue; 
                }
            }

            if(cost==20){
                if(ten>0 && five>0){
                    ten-=1;
                    five-=1;
                    continue; 
                }
                if(five>=3){
                    five-=3; 
                    continue; 
                }
                return false; 
            }
        }
        return true; 
    }
}