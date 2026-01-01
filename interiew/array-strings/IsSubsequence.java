public class IsSubsequence {
    public static boolean isSubsequence(String s, String t) {

        int i = 0; // THis pointer is to traverse S
        int j = 0; // This pointer is to travers t
        
        while(i < s.length() && j < t.length()) {
            if(s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }

        return i == s.length();
    }
    
    public static void main(String[] args) {
        String s = "kevin";
        String t = "kevin";

        boolean result = isSubsequence(s, t);

        System.out.println(result);
    }
}
