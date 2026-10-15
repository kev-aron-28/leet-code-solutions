public class MaskingPersonalInformation {
    public String solution(String s) {
        if (s.contains("@")) {
            int at = s.indexOf('@');
            
            String name = s.substring(0, at).toLowerCase();
            String domain = s.substring(at).toLowerCase();
            
            return name.charAt(0) + "*****" 
                + name.charAt(name.length() - 1)
                + domain;
        }

        StringBuilder digits = new StringBuilder();

        for(char c : s.toCharArray()) {
            if(Character.isDigit(c)) {
                digits.append(c);
            }
        }

        if (digits.length() == 10) {
            return "***-***-" + digits.substring(6);
        }

        int countryCodeLength = digits.length() - 10;

        StringBuilder result = new StringBuilder();

        result.append("+");

        for(int i = 0; i < countryCodeLength; i++) {
            result.append("*");
        }

        result.append("-***-***-");
        result.append(digits.substring(digits.length() - 4));

        return result.toString();
    }
}
