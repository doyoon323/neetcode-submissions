class Solution {
    public int calPoints(String[] operations) {
        Deque<Integer> bf = new ArrayDeque<>();
        
        for (String s : operations) {
            if (s.equals("+")) {
                int n1 = bf.pop();
                int n2 = bf.peek(); 
                bf.push(n1);        
                bf.push(n1 + n2);   
            } else if (s.equals("C")) {
                bf.pop();
            } else if (s.equals("D")) {
                bf.push(bf.peek() * 2);
            } else {
                bf.push(Integer.parseInt(s));
            }
        }
        
        int sum = 0;
        for (int score : bf) sum += score;

        return sum; 
    }
}