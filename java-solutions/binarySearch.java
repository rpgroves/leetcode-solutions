class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r)
        {
            int mid = ((r - l) / 2) + l;
            System.out.println(nums[mid]);
            if(nums[mid] == target)
                return mid;
            if(nums[mid] < target)
            {
                if(mid < nums.length - 1)
                    l = mid + 1;
                else
                    break;
            }
            if(nums[mid] > target)
            {
                r = mid - 1;
            }
        }

        return -1;
    }
}
