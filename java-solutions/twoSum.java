package javaLeetcodeSolutions;

import java.util.HashMap;

class twoSumSolution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numsMap = new HashMap<>();

        for(int i = 0; i < nums.length; i++)
        {
            if(numsMap.get(nums[i]) == null)
                numsMap.put(nums[i], i);
            if(numsMap.get(target - nums[i]) != null && numsMap.get(target - nums[i]) != i)
                return new int[]{numsMap.get(target - nums[i]), i};
        }

        return null;
    }
}
