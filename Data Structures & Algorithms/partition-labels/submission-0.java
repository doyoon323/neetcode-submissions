class Solution {
    public List<Integer> partitionLabels(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;

        int[] lastIndex = new int[26];
        for (int i = 0; i < n; i++) {
            lastIndex[chars[i] - 'a'] = i;
        }

        List<Integer> result = new ArrayList<>();
        int start = 0;
        int end = 0;

        for (int i = 0; i < n; i++) {
            int currentLast = lastIndex[chars[i]-'a'];
            if (currentLast > end) {
                end = currentLast;
            }

            if (i==end) {
                result.add(end - start + 1);
                start = i+1;
            }
        }

        return result;
    }
}