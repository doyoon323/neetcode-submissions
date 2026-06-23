class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> s = new HashSet<>();

        while(n!=1){
            if(s.contains(n)) return false; 
            s.add(n);
            int total =0;
            while(n!=0){
                total += (n%10)*(n%10);
                n/=10; 
            }
            n=total; 
        }
        return true; 
    }
}
