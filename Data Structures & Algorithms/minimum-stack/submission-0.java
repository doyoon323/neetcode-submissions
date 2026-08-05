class MinStack {
    List<Integer> ls;
    public MinStack() {
        ls = new ArrayList<>();
    }
    
    public void push(int val) {
        ls.add(val);
    }
    
    public void pop() {
        ls.remove(ls.size()-1);
    }
    
    public int top() {
        return ls.get(ls.size()-1);
    }
    
    public int getMin() {
        int idx=0;
        for(int i=1;i<ls.size();i++){
            if(ls.get(idx)>ls.get(i)){
                idx = i; 
            }
        }
        return ls.get(idx);
    }
}
