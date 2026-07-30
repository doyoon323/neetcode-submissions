class Solution {
    int[] parent;
    public int[] findRedundantConnection(int[][] edges) {
        //union-find: acyclic? 찾기. 정점을 추가하며
        //candidate list에 넣어두고 맨 마지막을 return 하기. 
        int idx=-1;
        int n = edges.length+1; 
        parent = new int[n+1]; 
        for(int i=1;i<=n;i++) parent[i]=i;

        for(int[] e : edges){
            int v1 = e[0];
            int v2 = e[1]; 

            if(!union(v1,v2)){
                return new int[]{v1,v2};
            }
        }
        return new int[]{}; 
    }

    public boolean union(int v1,int v2){
        int p1 = find(v1);
        int p2 = find(v2);

        if(p1==p2) return false;

        parent[p1]=p2; 
        return true; 
    }

    public int find(int x){
        if(parent[x]==x) return x;
        return parent[x] = find(parent[x]);
    }
}
