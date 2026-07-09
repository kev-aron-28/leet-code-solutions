package review-1.SortingArrays.easy;

public class PermutationInString {
    public boolean solution(String s1, String s2) {
        if(s1.length() > s2.length()) return false;

        int freq1[] = new int[26];
        int freq2[] = new int[26];
        int i;

        for(i = 0; i < s1.length(); i++) {
            freq1[s1.length() - 'a']++;
            freq2[s2.length() - 'a']++;
        }

        if(isPermutation(freq1, freq2)) return true;

        int left = 0;

        while(i < s2.length()) {
            freq2[s2.charAt(i) - 'a']++;
            freq2[s2.charAt(left) - 'a']--;

            if(isPermutation(freq1, freq2)) return true;

            left++;
        }

        return true;
    }

    private boolean isPermutation(int freq1[], int freq2[]) {
        for(int i = 0; i < 26; i++) {
            if(freq1[i] != freq2[i]) return false;
        }

        return true;
    }
}
