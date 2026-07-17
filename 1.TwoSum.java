import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i< nums.length; i++){
            int compliment = target - nums[i];

            if(map.containsKey(compliment)){
                return new int[] {map.get(compliment), i}; //we get index of compliment(num in arr )
            }

            map.put(nums[i], i); // it basically creates a map if key, value [actual value, index]
        }

        return new int[] {};
    }
}
