package daily;

public class RansomNote {
    public boolean solution(String ransom, String magazine) {
        int freq[] = new int[26];

        for(char c : magazine.toCharArray()) {
            freq[c - 'a']++;
        }

        for(int i = 0; i < ransom.length(); i++) {
            char current = ransom.charAt(i);

            freq[current - 'a']--;

            if(freq[current - 'a'] < 0) return false;
        }

        return true;
    }
}
