package javaLeetcodeSolutions;

import java.util.HashMap;

class containsDuplicateSolution {
    public boolean hasDuplicate(int[] nums) {
        HashMap<Integer, Boolean> numsMap = new HashMap<>();
        for(int i : nums)
        {
            if(numsMap.get(i) == null)
                numsMap.put(i, true);
            else
                return true;
        }

        return false;
    }
}
