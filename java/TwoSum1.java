
import java.util.HashMap;

public class TwoSum1 {
  
  public int[] twoSum(int[] nums, int target) {
    HashMap<Integer, Integer> map = new HashMap<>();

    for (int idx = 0; idx < nums.length; idx++) {
      int diff = target - nums[idx];
      
      if(map.containsKey(diff)) {
        return new int[] { map.get(diff), idx };
      
      } 
      
      map.put(nums[idx], idx);
    }


    return new int[0];
  }
  
  
  public static void main(String[] args) {
      
  } 
}
