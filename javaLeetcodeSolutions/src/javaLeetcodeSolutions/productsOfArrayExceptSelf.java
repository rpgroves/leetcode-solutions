class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] products1 = new int[nums.length];
        int[] products2 = new int[nums.length];

        Arrays.fill(products1, 1);
        Arrays.fill(products2, 1);

        int currentProduct = 1;
        for(int i = 0; i < nums.length; i++)
        {
            products1[i] = currentProduct;
            currentProduct *= nums[i];
        }

        currentProduct = 1;
        for(int i = nums.length-1; i >= 0; i--)
        {
            products2[i] = currentProduct;
            currentProduct *= nums[i];
        }

        for(int i = 0; i < nums.length; i++)
        {
            products1[i] *= products2[i];
        }

        return products1;
    }
}  
