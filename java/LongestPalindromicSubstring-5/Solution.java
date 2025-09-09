package LongestPalindromicSubstring-5;

class Solution {
    public String expand(int left, int right, String s) {
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right) ) {
            left--;
            right++;
        }
        
        return s.substring(left + 1 , right);
    }
    
    public String longestPalindrome(String s) {
        if(s == null || s.length() < 1) return "";

        String maxSoFar = "";
        for (int i = 0; i < s.length(); i++) {
            String odd = expand(i, i, s);

            String even = expand(i, i + 1, s);

            String longer = odd.length() > even.length() ? odd : even;

            if(longer.length() > maxSoFar.length()) {
                maxSoFar = longer;
            }
        }

        return maxSoFar;
    }
}