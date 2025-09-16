class Solution {
    public int maxArea(int[] heights) {
        int i = 0;
        int j = heights.length - 1;

        int size = 0;
        while(i < j)
        {
            int w = j - i;
            int h = 0;
            if(heights[i] < heights[j])
                h = heights[i];
            else
                h = heights[j];
            if(w * h > size)
                size = w * h;
            
            if(heights[i] < heights[j])
                i++;
            else
                j--;
        }

        return size;
    }
}
