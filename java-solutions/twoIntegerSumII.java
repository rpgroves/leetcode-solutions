class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int rightIndex = numbers.length - 1;
        int leftIndex = 0;

        while(numbers[leftIndex] + numbers[rightIndex] != target)
        {
            int currentSum = numbers[leftIndex] + numbers[rightIndex];
            if(currentSum > target)
                rightIndex--;
            else
                leftIndex++;
        }

        return new int[]{leftIndex + 1, rightIndex + 1};
    }
}
