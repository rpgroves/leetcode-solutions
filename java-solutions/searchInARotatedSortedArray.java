class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1, mid = -1;
        
        while(l < r)
        {
            mid = l + (r - l) / 2;
            if(nums[mid] > nums[r])
                l = mid + 1;
            else
                r = mid;
        }

        int min = l;
        l = 0;
        r = nums.length - 1;

        if(nums[min] > target)
            return -1;
        if(nums[r] < target)
        {
            r = min - 1;
        }
        else
        {
            l = min;
        }

        while (l <= r)
        {
            mid = ((r - l) / 2) + l;
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
        if(nums[l] != target)
            return -1;
        else
            return l;
    }
}
