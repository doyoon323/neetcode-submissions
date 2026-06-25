class Solution {
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder(); 
        while(columnNumber>0){
            columnNumber--;
            sb.append(ALPHABET.charAt(columnNumber % 26));
            columnNumber/=26;
        }
        return sb.reverse().toString(); 
    }
}