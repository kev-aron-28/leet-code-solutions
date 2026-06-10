package review-1.HashMapSet.easy;

public class FindTheDifference {
    public char solution(String s, String t) {
        int[] count = new int[26];

        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            count[c - 'a']--;

            if (count[c - 'a'] < 0) {
                return c;
            }
        }

        return ' ';
    } 
}
