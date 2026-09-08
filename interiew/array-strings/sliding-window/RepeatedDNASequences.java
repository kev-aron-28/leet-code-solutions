import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        Set seen = new HashSet();
        Set repeat = new HashSet();

        for(int i = 0; i + 9 < s.length(); i++) {
            String sub = s.substring(i, i + 10);
            if(!seen.add(sub)) {
                repeat.add(sub);
            }
        }
        return new ArrayList(repeat);
    }
}
