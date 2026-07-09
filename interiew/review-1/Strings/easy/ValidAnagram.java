package review-1.Strings.easy;

public class ValidAnagram {
    public boolean solution(String s, String t) {
        if(t.length() < s.length()) return false;

        int count[] = new int[26];

        for(int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for(int c : count) {
            if(c != 0) return false;
        }

        return true;
    }
}
