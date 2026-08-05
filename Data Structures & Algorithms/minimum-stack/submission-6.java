class MinStack {
    List<Integer> ls;
    List<Integer> min; 
    public MinStack() {
        ls = new ArrayList<>();
        min = new ArrayList<>();
    }
    
    public void push(int val) {
        ls.add(val);
        if(min.size()==0 || min.get(min.size()-1) >= val) min.add(val);
    }
    
    public void pop() {
        if(ls.size()==0) return;

        if(ls.get(ls.size()-1).equals(min.get(min.size()-1))) min.remove(min.size()-1);
        ls.remove(ls.size()-1);
    }
    
    public int top() {
        return ls.get(ls.size()-1);
    }
    
    public int getMin() {
        if(min.size()==0) return 0;
        return min.get(min.size()-1);
    }
}
