
import java.util.HashMap;
import java.util.Map;


// ¿Cuál es la subcadena más larga que puedo convertir en “AAAA…”, “BBBB…”, etc. cambiando como máximo k letras?
// reemplazos necesarios = tamaño de la ventana - frecuencia del carácter más común
public class LongestRepeatingCharacterReplacement {
    public int solution(String s, int k) {
        Map<Character, Integer> freq = new HashMap<>();

        int maxFreqChar = 0;

        int left = 0;

        int max = Integer.MIN_VALUE;

        for(int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);

            freq.put(rightChar, freq.getOrDefault(rightChar, 0) + 1);

            maxFreqChar = Math.max(freq.get(rightChar), maxFreqChar);

            while((right - left + 1) - maxFreqChar > k) {
                char leftChar = s.charAt(left);
                freq.put(leftChar, freq.get(leftChar) - 1);

                left++;
            }

            max = Math.max(max, right - left + 1);
        }


        return max;
    }
    public static void main(String[] args) {
        
    }
}
