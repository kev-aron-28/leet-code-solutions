package review-1.HashMapSet.easy;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if(t.length() < s.length() || t.length() > s.length()) return false;

        int map[] = new int[26];

        for(int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 'a']++;
            map[t.charAt(i) - 'a']--;
        }

        for(int val : map) {
            if(val != 0) return false;
        }

        return true;
    }
}
