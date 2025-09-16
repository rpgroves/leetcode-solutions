class Solution {
    public int trap(int[] height) {
        //given an array of integers representing wall heights
        //we want to find out how much water can fit into the spaces between/above the bars

        //Solution idea 1: iterate through the array searching for instances where a bar is lower
        //than the one before, this represents a potential hole. then we find out where the other
        //wall to that hole is by finding either the next highest or next lowest (highest if possible)
        //wall that comes later.

        //while moving to the right, we can store the index of the highest value to the right
        //when moving to the left we can store the index of the highest value to the left

        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];

        int leftMaxCurr = 0;
        for(int i = 0; i < height.length; i++)
        {
            leftMax[i] = leftMaxCurr;
            if(height[i] > leftMaxCurr)
                leftMaxCurr = height[i];
        }
        int rightMaxCurr = 0;
        for(int i = height.length - 1; i >= 0; i--)
        {
            rightMax[i] = rightMaxCurr;
            if(height[i] > rightMaxCurr)
                rightMaxCurr = height[i];
        }

        int totalWater = 0;
        for(int i = 0; i < height.length; i++)
        {
            //System.out.println(height[i] + " " + leftMax[i] + " " + rightMax[i]);
            int sum = Math.min(leftMax[i], rightMax[i]) - height[i];
            if(sum > 0)
                totalWater += sum;
        }

        return totalWater;
    }
}
