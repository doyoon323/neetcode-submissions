class MyHashMap {
    List<Integer> keys;
    List<Integer> values;
    public MyHashMap() {
        keys = new ArrayList<>();
        values = new ArrayList<>();
    }
    
    public void put(int key, int value) {
        int find = keys.indexOf(key);
        if(find!=-1) {
            values.set(find,value);
            return; 
        }
        
        keys.add(key);
        values.add(value);
    }
    
    public int get(int key) {
        int find = keys.indexOf(key);
        if(find==-1) return -1; 
        
        return values.get(find);
    }
    
    public void remove(int key) {
        int find = keys.indexOf(key);
        if(find!=-1){
            keys.remove(find);
            values.remove(find);
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */