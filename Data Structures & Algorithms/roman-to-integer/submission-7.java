class Solution {
    public int romanToInt(String s) {
        int sum = 0; 
        //MCMXCIV : 5-1 +100-10 + 
/*
        I는 V(5)와 X(10) 앞에 놓여 각각 4와 9를 만들 수 있습니다.
X는 L(50)과 C(100) 앞에 놓여 각각 40과 90을 만들 수 있습니다.
C는 D(500)와 M(1000) 앞에 놓여 각각 400과 900을 만들 수 있습니다.
*/
        for(int i=s.length()-1;i>=0;i--){
            System.out.println(sum);
            if(s.charAt(i)=='I'){
                if(i<s.length()-1 && (s.charAt(i+1) != 'I')) {
                    sum-=1;
                    continue;
                }
                sum++;
            }
            else if(s.charAt(i)=='V') sum+=5; 
            else if(s.charAt(i)=='X'){
                if(i<s.length()-1 && (s.charAt(i+1) == 'L' || s.charAt(i+1) == 'C')) {
                    sum-=10;
                    continue;
                }
                sum+=10;
            }
            else if(s.charAt(i)=='L') sum+=50; 
            else if(s.charAt(i)=='C'){
                if(i<s.length()-1 && (s.charAt(i+1) == 'D' || s.charAt(i+1) == 'M')) {
                    sum-=100;
                    continue;
                }
                sum+=100;
            }
            else if(s.charAt(i)=='D') sum+=500; // m
            else sum+=1000;

        }
        return sum; 
    }
}