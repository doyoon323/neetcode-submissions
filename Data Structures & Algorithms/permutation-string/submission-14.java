class Solution {
    public boolean checkInclusion(String s1, String s2) {
        /*
            s2의 substring에서 
            s1의 알파벳들이 존재하는가?

            1. s1을 hashset에 넣고
            2. s2가 존재할때까지 찾고, 최초로부터 s1개만큼 탐색 && 있다면? return true
            3. 한번할때마다 복사해야하나? 최적화의 여지가 있나? 
        */

        int n = s1.length();
        HashMap<Character,Integer> map = new HashMap<>();
        for (char c : s1.toCharArray()) {
            map.put(c,map.getOrDefault(c,0)+1);
        }
        System.out.println(String.valueOf(map));
        HashMap<Character,Integer> temp;

        for(int i=0;i<s2.length();i++){
            char c = s2.charAt(i); 
            if(map.containsKey(c)){//first discover
                int j,res=1;
                temp = new HashMap<>(map);
                temp.put(c, temp.get(c)-1);
                if(i+n-1>=s2.length()) return false; 

                for(j=1;j<n;j++){
                    char c2 = s2.charAt(i+j);
                    if(!temp.containsKey(c2)) break;
                    int val = temp.get(c2);
                    if(val <= 0) break; 
                    temp.put(c2, val-1);
                    res++;
                }
                if(res==n) return true; 
            }
        }
        return false; 
    }
}
