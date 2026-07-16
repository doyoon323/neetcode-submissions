class Solution {
    int[] parent; 
    public boolean validTree(int n, int[][] edges) {
        parent = new int[n]; 
        for(int i=0;i<n;i++) parent[i]=i;
        int eg = 0;
        for(int[] e : edges){
            if(union(e[0],e[1])) eg++;
            else return false;
        }

        return eg==(n-1);
    }

    public boolean union(int x,int y){
        int px = find(x);
        int py = find(y);

        if(px==py) return false;

        parent[py]=px;
        return true; 
    }
    public int find(int x){
        if(parent[x]==x) return x; 
        return parent[x]=find(parent[x]);
    }
}
