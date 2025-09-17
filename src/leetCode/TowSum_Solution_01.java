package leetCode;


public class TowSum_Solution_01 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 7 , 11, 15};
        int target = 9;
        TowSum_Solution_01 twoSum = new TowSum_Solution_01();
        int[] results = twoSum.twoSum(nums, target);
        for (int i = 0; i < results.length ; i++){
            System.out.print(results[i]);
        }
    }

    public int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }

        return new int[ ] {};
    }

}
