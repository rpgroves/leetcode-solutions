class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> sequenceMap = new HashMap<>();

        for(int i = 0; i < nums.length; i++)
        {
            sequenceMap.put(nums[i], 0);
        }
        int topSequence = 0;
        for(Map.Entry<Integer, Integer> entry : sequenceMap.entrySet())
        {
            int currentNum = entry.getKey();
            if(sequenceMap.get(currentNum - 1) != null)
                continue;
            else
            {
                int currentSequence = 0;
                int nextNum = currentNum;
                while(sequenceMap.get(nextNum) != null)
                {
                    currentSequence++;
                    if(currentSequence > topSequence)
                        topSequence = currentSequence;
                    nextNum = nextNum + 1;
                }
            }
        }
        return topSequence;
    }
}
