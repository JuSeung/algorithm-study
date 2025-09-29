package leetCode;


import java.util.Arrays;

public class TwoSum_Solution_01 {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7 , 11, 15};
        int target = 18;
        TwoSum_Solution_01 twoSum = new TwoSum_Solution_01();
        int[] results = twoSum.twoSum(nums, target);
        System.out.println(Arrays.toString(results));
    }

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
               if (nums[i] + nums[j] == target){
                   return new int[]{i,j};
               }
            }
        }
        return new int[] {};
    }

}
