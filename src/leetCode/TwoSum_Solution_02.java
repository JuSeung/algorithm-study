package leetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum_Solution_02 {
     public static void main(String[] args) {
        int[] nums = new int[] {2, 7 , 11, 15};
        int target = 18;
        TwoSum_Solution_02 twoSum = new TwoSum_Solution_02();
        int[] results = twoSum.twoSum(nums, target);
        System.out.print(Arrays.toString(results));
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
        }
        return new int[] {};
    }
}
