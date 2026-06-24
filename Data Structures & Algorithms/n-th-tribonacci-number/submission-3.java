class Solution {
    public int tribonacci(int n) {
        if(n==0) return 0;
        if(n==1 || n==2) return 1;

        /*
        int[] T = new int[n];
        T[0] = 0;
        T[1] = 1;
        T[2] = 1;
        */
        int t1=0,t2=1,t3=1; 
        int temp = 0; 

        for(int i=3;i<=n;i++){
            //T[i] = T[i-3]+T[i-2]+T[i-1];
            temp = t1+t2+t3;
            t1=t2;
            t2=t3;
            t3=temp;
        }
        return t3;//T[n-3]+T[n-2]+T[n-1];
    }
}