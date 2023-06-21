import java.util.*;

class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        Map <Integer,Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            int match = target - nums[i];
            if (numMap.containsKey(match)){
                return new int[]{numMap.get(match),i};
            }
            numMap.put(nums[i],i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}