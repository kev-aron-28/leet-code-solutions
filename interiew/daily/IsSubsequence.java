package daily;

public class IsSubsequence {
    public boolean solution(String s, String t) {

        int i = 0;
        int j = 0;
 
        while(i < s.length() && j < t.length()) {
            if(s.charAt(i) == t.charAt(j)) i++;

            j++;
        }

        return i == s.length();
    }
}
