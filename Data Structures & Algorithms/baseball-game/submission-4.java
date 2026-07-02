class Solution {
    // [5,-2,-4,9,5,14] 
    public int calPoints(String[] operations) {
        Stack<Integer> bf = new Stack<>();
        for(String s : operations){
            if(s.equals("+")){
                int n1=bf.pop();
                int n2=bf.pop();
                System.out.println(n1+"+"+n2);
                bf.push(n2);
                bf.push(n1);
                bf.push(n1+n2);
            }else if(s.equals("C")){
                System.out.println("remove: "+bf.pop());
            }else if(s.equals("D")){
                int n = bf.pop();
                bf.push(n);
                bf.push(n*2);
                System.out.println(n+"&&"+n*2);
            }else {
                System.out.println("push " + s);
                bf.push(Integer.parseInt(s));
            }
        }
        int sum = 0;
        
        while(!bf.isEmpty()) {
            int n = bf.pop();
            sum+=n;
            System.out.println(n);
        }

        return sum; 
    }
}