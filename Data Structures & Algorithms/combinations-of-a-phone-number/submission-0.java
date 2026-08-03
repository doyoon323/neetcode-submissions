class Solution {
    public List<String> letterCombinations(String digits) {
        /*
        2-9
        map(hash)를 해서, for문을 돌리기. 
        */
        if(digits.length()==0) return new ArrayList<String>();
        String[] s = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"
        };
        List<String> res = new ArrayList<>(); 
        back(digits, s, 0,new StringBuilder(),res);
        return res; 
    }

    public void back(String d, String[] s, int idx, StringBuilder store, List<String> res){
        if(idx==d.length()){
            res.add(store.toString());
            return; 
        }
        int n = d.charAt(idx)-'0';
        for(int i=0;i<s[n].length();i++){
            back(d,s,idx+1,store.append(s[n].charAt(i)),res);
            store.deleteCharAt(store.length()-1);
        }
    }
}
