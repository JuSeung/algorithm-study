package leetCode;

import java.util.ArrayList;
import java.util.List;

public class TwoSum {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7 , 11, 15};
        int target = 9;
        TwoSum twoSum = new TwoSum();
        int[] results = twoSum.twoSum(nums, target);
        for (int i = 0; i < results.length ; i++){
            System.out.println(results[i]);
        }
    }


    public int[] twoSum(int[] nums, int target) {
        List<Integer> indexList = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            for (int j = (i+1); j < nums.length; j++) {
                if (target == (nums[i] + nums[j])) {
                    indexList.add(i);
                    indexList.add(j);
                    break;
                }
            }
        }
        int listSize = indexList.size();
        int[] result = new int[listSize];
        for (int i = 0; i < listSize; i++) {
            result[i] = indexList.get(i);
        }
        return result;
    }


}
