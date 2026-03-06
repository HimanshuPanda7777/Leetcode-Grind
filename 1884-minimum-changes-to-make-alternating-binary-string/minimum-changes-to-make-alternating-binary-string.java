class Solution {
    public int minOperations(String s) {
        int changeStartWith0 = 0;
        int changeStartWith1 = 0;

        for(int i = 0; i < s.length(); i++){
            
            // Expected char if starting with 0
            char expected0 = (i % 2 == 0) ? '0' : '1';
            
            // Expected char if starting with 1
            char expected1 = (i % 2 == 0) ? '1' : '0';

            if(s.charAt(i) != expected0){
                changeStartWith0++;
            }

            if(s.charAt(i) != expected1){
                changeStartWith1++;
            }
        }

        return Math.min(changeStartWith0, changeStartWith1);
    }
}