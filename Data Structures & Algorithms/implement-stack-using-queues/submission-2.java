class MyStack {
    Queue<Integer> in = new ArrayDeque<>(); 
    Queue<Integer> out = new ArrayDeque<>();
    public MyStack() {
        
    }
    
    public void push(int x) {
        out.offer(x);

        while (!in.isEmpty()) {
            out.offer(in.poll());
        }
        Queue<Integer> temp = in;
        in = out;
        out = temp;
    }
    
    public int pop() {
        return in.poll(); 
    }
    
    public int top() {
        return in.peek(); 
    }
    
    public boolean empty() {
        return in.isEmpty(); 
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