public class LongestSubstringwithAtLeastKRepeatingCharacters {
    public int solution(String s, int k) {
        if (s.length() < k) {
            return 0;
        }

        int freq[] = new int[26];

        for(char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // We look for something fewer than k times
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // Cannot belong to any subtring
            if(freq[c - 'a'] < k) {
                String left = s.substring(0, i);
                String right = s.substring(i + 1);

                return Math.max(
                    solution(left, k),
                    solution(right, k)
                );
            } 
        }

        // Every character appears at least k times
        return s.length();
    }
}
