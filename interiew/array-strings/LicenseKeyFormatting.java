public class LicenseKeyFormatting {
    public String solution(String s, int k) {
        int totalChars = 0;

        for(char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                totalChars++;
            }
        }

        int firstGroupSize = totalChars % k;

        if(firstGroupSize == 0) {
            firstGroupSize = k;
        }

        StringBuilder sb = new StringBuilder();
        int count = 0;
        int groupSize = firstGroupSize;

        for(char c : s.toCharArray()){
            if (c == '-') {
                continue;
            }

            if (count == groupSize) {
                sb.append("-");
                count = 0;
                groupSize = k;
            }

            sb.append(Character.toUpperCase(c));
            count++;
        }

        return sb.toString();
    }
}
