class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //-2, 0, 1, 1, 2
        //-2 + 0 + 2 = 2 passes
        //

        Arrays.sort(nums);

        List<List<Integer>> retList = new ArrayList<>();

        for(int i = 0; i < nums.length - 2; i++)
        {   
            int j = i + 1;
            int k = nums.length - 1;
            int currentSum = nums[i] + (nums[j] + nums[k]);
            while(true)
            {
                if(currentSum < 0)
                {
                    if(j >= nums.length - 2)
                        break;
                    else
                    {
                        if(j + 1 != k)
                            j++;
                        else
                            break;
                    }
                }
                if(currentSum > 0)
                {
                    if(k <= i + 1)
                        break;
                    else
                    {
                        if(k - 1 != j)
                            k--;
                        else
                            break;
                    }
                }
                currentSum = nums[i] + (nums[j] + nums[k]);

                if(currentSum == 0)
                {
                    List<Integer> currentTriplet = Arrays.asList(nums[i], nums[j], nums[k]);
                    if(!retList.contains(currentTriplet))
                        retList.add(currentTriplet);
                }
            }            
        }

        return retList;
    }
}
