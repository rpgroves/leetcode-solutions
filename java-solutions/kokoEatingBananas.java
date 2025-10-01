class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int k = -1;
        int l = 1, r = -1;

        for(int i = 0; i < piles.length; i++)
        {
            if(r < piles[i])
                r = piles[i];
        }

        while(l < r)
        {
            k = ((r - l) / 2) + l;
            int hours = 0;
            for(int i = 0; i < piles.length; i++)
            {
                int pile = piles[i];
                hours += (pile + k - 1) / k;
            }

            if (hours <= h) 
            {
                r = k;
            } 
            else 
            {
                l = k + 1;
            }
        }

        return l;
    }
}
