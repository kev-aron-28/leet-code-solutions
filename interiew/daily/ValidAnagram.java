package daily;

public class ValidAnagram {
    public boolean solution(String s, String t) {
        if(t.length() != s.length()) return false;

        int freq[] = new int[26];

        int n = s.length();

        for(int i = 0; i < n; i++) {
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }

        for(int f : freq) {
            if(f != 0) return false;
        }

        return true;
    }
}
