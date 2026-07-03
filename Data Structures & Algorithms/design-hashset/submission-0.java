class MyHashSet {
    List<Integer> set = new ArrayList<>(); 
    public MyHashSet() {
    }
    
    public void add(int key) {
        if(set.indexOf(key)==-1){
            set.add(key);
        }
    }
    
    public void remove(int key) {
        int find = set.indexOf(key);
        if(find!=-1) set.remove(find);
    }
    
    public boolean contains(int key) {
        return set.indexOf(key) != -1; 
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */