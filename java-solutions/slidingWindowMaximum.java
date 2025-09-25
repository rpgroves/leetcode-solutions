class Pair implements Comparable<Pair> {
    Integer value;
    Integer index;

    public Pair(Integer value, Integer index) {
        this.value = value;
        this.index = index;
    }

    @Override
    public int compareTo(Pair o) {
        return value - o.value;
    }
}

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ret = new int[(nums.length - k + 1)];
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        int l = 0, r = 0, max = nums[0], step = 0;
        for(; r < k; r++)
        {
            Pair p = new Pair(nums[r], r);
            maxHeap.add(p);
        }
        for(; r < nums.length; r++)
        {
            while(!(maxHeap.peek().index >= l && maxHeap.peek().index <= r))
                maxHeap.remove(maxHeap.peek());
            ret[step] = maxHeap.peek().value;
            step++;
            l++;

            Pair p = new Pair(nums[r], r);
            maxHeap.add(p);
        }
        while(!(maxHeap.peek().index >= l && maxHeap.peek().index <= r))
            maxHeap.remove(maxHeap.peek());
        ret[step] = maxHeap.peek().value;

        return ret;
    }
}
