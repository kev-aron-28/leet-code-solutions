package LongestCommonPrefix-14;

public class Solution {

    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";

        if(strs.length == 1) return strs[0];

        StringBuilder prefix = new StringBuilder(strs[0]);

        for(int i = 1; i < strs.length; i++) {
            String toCompare = strs[i];
            while (prefix.length() > 0 && !toCompare.startsWith(prefix.toString())) { 
                prefix.deleteCharAt(prefix.length() - 1);
            }

            if(prefix.length() == 0) return "";
        }

        return prefix.toString();
    }

}
