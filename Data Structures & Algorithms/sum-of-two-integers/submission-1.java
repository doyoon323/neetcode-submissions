class Solution {
    public int getSum(int a, int b) {
        int and = a&b;
        int xor = a^b;
        int dif = ~xor & and; 
        dif<<=1; 
        while((dif&xor)!=0){
            and = dif&xor;
            xor = dif^xor;
            dif = ~xor & and; 
            dif<<=1; 
        }
        dif= dif|xor; 
        return dif; 
    }
}
