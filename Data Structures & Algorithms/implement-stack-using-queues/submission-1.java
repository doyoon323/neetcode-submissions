class MyStack {
    Queue<Integer> in = new ArrayDeque<>(); 
    Queue<Integer> out = new ArrayDeque<>();
    public MyStack() {
        
    }
    
    public void push(int x) {
        in.offer(x);
    }
    
    public int pop() {
        if(empty()) return -1; 
        top();
        return in.poll(); 
    }
    
    public int top() {
        if(in.size()==1) return in.peek(); 

        if(in.size()==0){
            while(out.size()!=0){
                in.offer(out.poll());
            }
        }
        while(in.size() != 1){
            out.offer(in.poll());
        }
        return in.peek(); 
    }
    
    public boolean empty() {
        return in.size()==0 && out.size()==0; 
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */