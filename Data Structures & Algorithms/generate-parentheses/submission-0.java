class Solution {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        /*
        n개의 괄호 한 쌍을 가져와야해. 
        근데 모든 경우의 수를 Return해야한다.
        예로들어,n=3
        ()()() [1번열면,닫기]
        (  열고 열거나 닫거나 () 근데 닫는 경우는 끝나고 회수할 필요가 없다.

        */
        back(n,1,0,"(");
        return res; 
    }

    public void back(int n, int lc,int rc, String store){
        if(lc==n){
            while(rc!=n){
                store = store + ")";
                rc++;
            }
            res.add(store);
            return;
        }
        back(n,lc+1,rc, store+"("); //열어
        if(lc>rc) back(n,lc,rc+1,store+")");
    }
}
